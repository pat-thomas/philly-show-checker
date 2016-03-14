(ns philly-show-checker.app.components.home
  (:require [philly-show-checker.app.state :as state]))

(defn self
  []
  (println "rendering home component")
  [:p.home "foof"]
  #_[:div#home-container
     [:p "home stuff will go here"]])
