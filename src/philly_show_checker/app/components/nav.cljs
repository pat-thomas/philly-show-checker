(ns philly-show-checker.app.components.nav)

(defn item
  [params]
  [:div.item {:on-mouse-over (fn [_]
                               (println "huh"))}
   (:name params)])

(def item-list
  [{:name "home"}
   {:name "logout"}])

(defn self
  []
  (let [items (map item item-list)]
    (apply conj [:div#nav] items)))
