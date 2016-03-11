(ns philly-show-checker.app.components.login
  (:require [reagent.core                           :as reagent]
            [philly-show-checker.app.models.session :as session-model]
            [philly-show-checker.app.history        :as history]
            [philly-show-checker.app.util           :as util]))

(def local-state (reagent/atom {:username ""
                                :password ""}))

(defn self
  []
  [:div#login-form
   [:div
    [:label "Username/Email"]
    [:input {:type      "text"
             :on-change (fn [e]
                          (swap! local-state assoc :username (util/get-event-value e)))
             :val       (get @local-state :username)}]]
   [:div
    [:label "Password"]
    [:input {:type      "password"
             :on-change (fn [e]
                          (swap! local-state assoc :password (util/get-event-value e)))
             :val       (get @local-state :password)}]]
   [:button
    {:on-click (fn [_]
                 (let [login-params (select-keys @local-state [:username :password])]
                   (session-model/login login-params)))}
    "Submit"]
   [:button
    {:on-click (fn [_]
                 (history/redirect "signup"))}
    "Not signed up? Click here to sign up."]])
