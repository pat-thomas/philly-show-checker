(ns philly-show-checker.app.util
  (:require [cognitect.transit :as t]))

(defn get-event-value
  [e]
  (.. e -target -value))
