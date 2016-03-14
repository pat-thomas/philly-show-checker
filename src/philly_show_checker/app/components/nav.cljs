(ns philly-show-checker.app.components.nav)

(defn item
  [params]
  [:div.item params])

(def item-list
  [{:foof :barf}
   {:bazf :quxf}])

(defn self
  []
  ;;[:div#nav (map item item-list)]
  [:p "hello"])
