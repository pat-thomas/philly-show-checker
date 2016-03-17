(ns philly-show-checker.app.history
  (:require [philly-show-checker.app.state          :as state]
            [secretary.core                         :as secretary]
            [goog.events                            :as events]
            [goog.history.EventType                 :as EventType])
  (:import goog.History))

(def history (atom nil))

(defn init!
  []
  (let [h (History.)]
    (events/listen h EventType/NAVIGATE #(secretary/dispatch! (.-token %)))
    (reset! history h)
    (doto h (.setEnabled true))))

(defn nav!
  [token]
  (.setToken @history token))
