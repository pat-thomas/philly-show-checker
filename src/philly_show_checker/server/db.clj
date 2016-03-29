(ns philly-show-checker.server.db
  (:require [clojure.java.jdbc :as jdbc]
            [korma.db          :as korma]))

(korma/defdb db
  (korma/mysql {:db       "philly_show_checker"
                :user     "db_admin"
                :password "1234"}))

(defn store-scraper-results
  [results]
  (println "implement store-scraper-results"))

(defn lookup-by
  [schema-and-table lookup-criteria]
  {:result-set [:implement-me]})
