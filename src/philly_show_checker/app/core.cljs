(ns philly-show-checker.app.core
  (:require [philly-show-checker.app.state                 :as state]
            [philly-show-checker.app.models.session        :as session]
            [philly-show-checker.app.components.nav        :as nav]
            [philly-show-checker.app.history               :as history]
            [reagent.core                                  :as reagent]))

(enable-console-print!)

(defn main-component
  []
  [:div#main
   (let [current-view (:current-view @state/app-state)]
     (if (session/logged-in?)
       (nav/self)
       [:p "you're not logged in "]))])

(defn main
  []
  (do
    ;;(history/init!)
    (swap! state/app-state assoc :session (session/get-session))
    (reagent/render-component [main-component] (.-body js/document))))

(main)

