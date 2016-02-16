(ns philly-show-checker.app.core
  (:require [reagent.core :as reagent]
            [philly-show-checker.app.components.venue-list :as venue-list]))

(enable-console-print!)

(defn main-component
  []
  [venue-list/self])

(defn main
  []
  (reagent/render-component [main-component] (.-body js/document)))

(main)

