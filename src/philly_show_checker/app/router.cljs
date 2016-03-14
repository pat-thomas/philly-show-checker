(ns philly-show-checker.app.router
  (:require [philly-show-checker.app.components.home])
  (:require-macros [philly-show-checker.app.history.macros :as h]))

(h/app-route! home)

(def routing-table
  {:home philly-show-checker.app.components.home/self})
