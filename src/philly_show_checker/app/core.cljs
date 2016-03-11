(ns philly-show-checker.app.core
  (:require [philly-show-checker.app.state                 :as state]
            [philly-show-checker.app.components.nav        :as nav]
            [philly-show-checker.app.components.venue-list :as venue-list]
            [philly-show-checker.app.components.login      :as login]
            [philly-show-checker.app.models.session        :as session]
            [reagent.core                                  :as reagent]
            [philly-show-checker.app.history :as history]))

(enable-console-print!)

(defn main-component
  []
  (if (session/logged-in?)
    [:div#app
     [nav/self]
     [venue-list/self]]
    [:div#app
     (login/self)]))

(defn main
  []
  (history/init!)
  (swap! state/app-state assoc :session (session/get-session))
  (reagent/render-component [main-component] (.-body js/document)))

(main)

