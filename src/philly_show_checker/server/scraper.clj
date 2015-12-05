(ns philly-show-checker.server.scraper
  (:require [philly-show-checker.server.db    :as db]
            [clojure.string                   :as string]
            [clojurewerkz.quartzite.scheduler :as scheduler]
            [clojurewerkz.quartzite.jobs      :as jobs]
            [clojurewerkz.quartzite.triggers  :as triggers]
            [clojurewerkz.quartzite.schedule.calendar-interval :as interval]
            [org.httpkit.client               :as http-client]))

(defn ->scraper-job-name
  [^clojure.lang.Symbol venue-name]
  (symbol (string/join "" (map string/capitalize (string/split (name venue-name) #"-")))))

(def jobs (atom {}))

(defmacro defscraper
  [venue-name url html-parser-fn]
  (let [job-name (->scraper-job-name venue-name)]
    `(do
       (jobs/defjob ~job-name
         [ctx#]
         (let [resp# @(http-client/get ~url)]
           (db/store-scraper-results (~html-parser-fn resp#))))
       (swap! jobs assoc ~(keyword venue-name) ~job-name))))

(defscraper union-transfer
  "www.utphilly.com/listing"
  (fn [raw-html]
    raw-html))

(defscraper boot-and-saddle
  "www.bootandsaddlephilly.com/listing"
  (fn [raw-html]
    raw-html))

(defn init-jobs!
  []
  (let [s (-> (scheduler/initialize) scheduler/start)]
    (doseq [[job-name job-def] @jobs]
      (let [job-key (format (str (name job-name) ".%s") 1)
            job     (jobs/build (jobs/of-type job-def) (jobs/with-identity (jobs/key job-key)))
            trigger-key (triggers/key (format "%s.%s" job-key "triggers.1"))
            trigger (triggers/build (triggers/with-identity trigger-key)
                                    (triggers/start-now)
                                    (triggers/with-schedule
                                      (interval/schedule (interval/with-interval-in-days 1))))]
        (println (format "scheduling job %s" job-key))
        (scheduler/delete-trigger s trigger-key)
        (scheduler/schedule s job trigger)))))

(comment
  (init-jobs!)
  )
