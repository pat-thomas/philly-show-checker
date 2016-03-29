(ns philly-show-checker.app.core
  (:require [philly-show-checker.app.state            :as state]
            [philly-show-checker.app.models.session   :as session]
            [philly-show-checker.app.components.nav   :as nav]
            [philly-show-checker.app.components.login :as login]
            [philly-show-checker.app.components.login :as signup]
            [philly-show-checker.app.history          :as history]
            [philly-show-checker.app.router           :as router]
            [reagent.core                             :as reagent]))

(enable-console-print!)

(defn main-component
  []
  (let [current-view-name (-> state/app-state deref :current-view :name)]
    (println current-view-name)
    (condp = current-view-name
      :signup
      (do (println "rendering signup")
          (signup/self))

      :login
      (do (println "rendering login")
          (login/self))

      ;;else
      (when-let [current-view-fn (get router/routing-table current-view-name)]
        (apply conj [:div#main]
               (if (session/logged-in?)
                 [(nav/self) (current-view-fn)]
                 (history/nav! "login")))))))

(defn main
  []
  (do
    (history/init!)
    (swap! state/app-state assoc :session (session/get-session))
    (reagent/render-component [main-component] (.-body js/document))))

(main)

