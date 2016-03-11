(ns philly-show-checker.app.history
  (:require [philly-show-checker.app.state             :as state]
            [philly-show-checker.app.components.login  :as login]
            [philly-show-checker.app.components.signup :as signup]
            [secretary.core                            :as secretary]
            [goog.events                               :as events]
            [goog.history.EventType                    :as EventType])
  (:import goog.History))

(def routing-table
  {:login  login/self
   :signup signup/self})

(defn set-current-view!
  [current-view & [opts]]
  (swap! state assoc :current-view (merge {:name current-view}
                                          opts)))

(defn init!
  []
  (let [h (History.)]
    (events/listen h EventType/NAVIGATE #(secretary/dispatch! (.-token %)))
    (doto h (.setEnabled true))))
