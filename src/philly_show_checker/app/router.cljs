(ns philly-show-checker.app.router
  (:require [philly-show-checker.app.state             :as state]
            [philly-show-checker.app.components.login  :as login]
            [philly-show-checker.app.components.signup :as signup]))

(def routing-table
  {:login  login/self
   :signup signup/self
   :home home/self})

(defn render-current-view
  []
  (let [current-view      (:current-view @state/app-state)
        current-view-name (:name current-view)
        current-view-fn   (get routing-table current-view-name)]
    (current-view-fn current-view)))

(defn set-current-view!
  [current-view & [opts]]
  (swap! state/app-state assoc :current-view (merge {:name current-view}
                                                    opts)))
