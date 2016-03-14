(ns philly-show-checker.app.components.home
  (:require [philly-show-checker.app.state          :as state]
            [philly-show-checker.app.components.nav :as nav]))

(defn self
  [opts]
  [:div
   (nav/self)
   [:div#home-container
    [:p "home stuff will go here"]]])
