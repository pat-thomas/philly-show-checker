(ns philly-show-checker.app.components.nav
  (:require [philly-show-checker.app.history :as history]))

(defn item
  [{:keys [friendly-name url on-click]}]
  [:div.item {:on-mouse-over (fn [_]
                               (println "huh"))
              :on-click      (fn [_]
                               (if url
                                 (history/nav! url)
                                 (on-click)))}
   friendly-name])

(def item-list
  [{:friendly-name "Home"
    :url           "home"}
   {:friendly-name "Account"
    :url           "account"}
   {:friendly-name "Log Out"
    :on-click      (fn [_]
                     (println "will logout"))}])

(defn self
  []
  (let [items (map item item-list)]
    (apply conj [:div#nav] items)))
