(ns philly-show-checker.app.components.venue-list)

(def venue-data
  {:boot-and-saddle  {:friendly-name "Boot & Saddle"}
   :union-transfer   {:friendly-name "Union Transfer"}
   :philamoca        {:friendly-name "Philamoca"}
   :johnny-brendas   {:friendly-name "Johnny Brenda's"}
   :underground-arts {:friendly-name "Underground Arts"}})

(defn self
  []
  [:div 
   (map (fn [[venue-key venue-data]]
          [:div {:on-mouse-over (fn [_]
                                  (println "ok"))}
           (:friendly-name venue-data)])
        venue-data)])
