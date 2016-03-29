(ns philly-show-checker.app.router
  (:require [philly-show-checker.app.components.home]
            [philly-show-checker.app.components.account]
            [philly-show-checker.app.components.signup]
            [philly-show-checker.app.history :as history])
  (:require-macros [philly-show-checker.app.history.macros :as h]
                   [secretary.core                         :as s]))

(h/app-route! home)
(h/app-route! account)
(h/app-route! login)
(h/app-route! signup)

(s/defroute "*"
  []
  (do
    (println "route not found")
    (history/nav! "home")))


(def routing-table
  {:home    philly-show-checker.app.components.home/self
   :account philly-show-checker.app.components.account/self
   :signup  philly-show-checker.app.components.signup/self})
