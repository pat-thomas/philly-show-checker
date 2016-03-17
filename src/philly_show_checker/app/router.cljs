(ns philly-show-checker.app.router
  (:require [philly-show-checker.app.components.home]
            [philly-show-checker.app.history :as history])
  (:require-macros [philly-show-checker.app.history.macros :as h]
                   [secretary.core                         :as s]))

(h/app-route! home)

(s/defroute "*"
  []
  (history/nav! "home"))


(def routing-table
  {:home philly-show-checker.app.components.home/self})
