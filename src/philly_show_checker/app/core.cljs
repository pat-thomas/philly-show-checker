(ns philly-show-checker.app.core
  (:require [philly-show-checker.app.state                 :as state]
            [philly-show-checker.app.components.nav        :as nav]
            [philly-show-checker.app.components.venue-list :as venue-list]
            [philly-show-checker.app.models.session        :as session]
            [reagent.core                                  :as reagent]))

(enable-console-print!)

(defn main-component
  []
  [:div#app
   [nav/self]
   [venue-list/self]])

(defn main
  []
  (swap! state/app-state assoc :session (session/get-session))
  (reagent/render-component [main-component] (.-body js/document)))

(main)

