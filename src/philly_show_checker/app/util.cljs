(ns philly-show-checker.app.util)

(defn get-event-value
  [e]
  (.. e -target -value))
