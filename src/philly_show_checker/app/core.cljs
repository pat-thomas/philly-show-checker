(ns philly-show-checker.app.core
  (:require [philly-show-checker.app.components.nav        :as nav]
            [philly-show-checker.app.components.venue-list :as venue-list]
            [reagent.core                                  :as reagent]))

(enable-console-print!)

(def app-state (reagent/atom {}))

(defn main-component
  []
  [:div#app
   [nav/self]
   [venue-list/self]])

(defn main
  []
  (reagent/render-component [main-component] (.-body js/document)))

(main)

