(defproject philly-show-checker "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main philly-show-checker.server.core
  :dependencies [;; client-side
                 [org.clojure/clojurescript "1.7.170"]
                 [reagent "0.5.1"]

                 ;; server-side
                 [org.clojure/clojure     "1.7.0"]
                 [clojurewerkz/quartzite  "2.0.0"]
                 [com.draines/postal      "1.11.3"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [http-kit                "2.1.18"]
                 [org.clojure/java.jdbc   "0.3.5"]
                 [com.stuartsierra/component "0.2.3"]]
  :cljsbuild {:builds [{:source-paths ["src/philly_show_checker/app"]
                        :compiler     {:output-to     "public/js/philly_show_checker.js"
                                       :optimizations :whitespace
                                       :pretty-print  true}}]})
