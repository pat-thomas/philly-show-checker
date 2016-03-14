(ns philly-show-checker.app.state
  (:require [reagent.core :as reagent]))

(def app-state (reagent/atom {:current-view {:name :home}}))
