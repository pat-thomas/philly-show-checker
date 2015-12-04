(ns philly-show-checker.server.scraper
  (:require [philly-show-checker.server.db    :as db]
            [clojure.string                   :as string]
            [clojurewerkz.quartzite.scheduler :as scheduler]
            [clojurewerkz.quartzite.jobs      :as jobs]
            [org.httpkit.client               :as http-client]))

(defn ->scraper-job-name
  [^clojure.lang.Symbol venue-name]
  (symbol (string/join "" (map string/capitalize (string/split (name venue-name) #"-")))))

(defmacro defscraper
  [venue-name url html-parser-fn]
  `(jobs/defjob ~(->scraper-job-name venue-name)
     [ctx#]
     (let [resp# @(http-client/get ~url)]
       (db/store-scraper-results
        (~html-parser-fn resp#)))))

(defscraper union-transfer
  "www.utphilly.com/listing"
  (fn [raw-html]
    raw-html))

(defn init-jobs!
  []
  (let [s (-> (scheduler/initialize) scheduler/start)]
    ))
