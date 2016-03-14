(ns philly-show-checker.app.models.session
  (:require [philly-show-checker.app.xhr-util :as xhr]
            [philly-show-checker.app.state    :as state]))

(defn get-session
  []
  (xhr/make-xhr {:method      :get
                 :url         "session"
                 :on-complete (fn [resp]
                                (println resp)
                                (swap! state/app-state assoc :session resp))}))

(defn logged-in?
  []
  (let [status (get-in @state/app-state [:session "status"])]
    (= status "OK")))

(defn login
  [{:keys [username password]}]
  (xhr/make-xhr {:method      :post
                 :url         "session"
                 :data        {:username username
                               :password password}
                 :on-complete (fn [resp]
                                (println resp))}))
