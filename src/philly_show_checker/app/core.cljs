(ns philly-show-checker.app.core
  (:require [philly-show-checker.app.state                 :as state]
            [philly-show-checker.app.router                :as router]
            [philly-show-checker.app.models.session        :as session]
            [philly-show-checker.app.history               :as history]
            [philly-show-checker.app.components.nav        :as nav]
            [philly-show-checker.app.components.venue-list :as venue-list]
            [reagent.core                                  :as reagent]))

(enable-console-print!)

(defn app-container
  []
  [:div#app
   [nav/self]
   (router/render-current-view)])

(defn main-component
  []
  (if (session/logged-in?)
    (router/set-current-view! :home)
    (router/set-current-view! :login)))

(defn main
  []
  (do
    (history/init!)
    (swap! state/app-state assoc :session (session/get-session))
    (reagent/render-component [main-component] (.-body js/document))))

(main)

