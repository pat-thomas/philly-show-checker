(ns philly-show-checker.server.api.v1.ping
  (:require [kinematic.dsl :as k-dsl]))

(k-dsl/defapi :philly-show-checker-api-v1
  ["ping"])

(k-dsl/api-get
 {:status  "OK"
  :message "pong!"})

(comment
  (conj [:div#nav] [:meow :woof])
  )
