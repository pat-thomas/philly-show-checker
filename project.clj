(defproject philly-show-checker "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main philly-show-checker.core
  :dependencies [;; client-side
                 [org.clojure/clojurescript "1.7.170"]
                 [reagent "0.5.1"]

                 ;; server-side
                 [org.clojure/clojure     "1.7.0"]
                 [clojurewerkz/quartzite  "2.0.0"]
                 [com.draines/postal      "1.11.3"]
                 [org.clojure/tools.nrepl "0.2.12"]])
