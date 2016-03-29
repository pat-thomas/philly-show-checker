(defproject philly-show-checker "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main philly-show-checker.server.core
  :plugins [[lein-cljsbuild "1.1.3"]]
  :dependencies [;; shared
                 [prismatic/schema "1.0.5"]

                 ;; client-side
                 [org.clojure/clojurescript  "1.7.170"]
                 [reagent                    "0.5.1"]
                 [com.cognitect/transit-cljs "0.8.237"]
                 [secretary                  "1.2.3"]

                 ;; server-side
                 [org.clojure/clojure        "1.7.0"]
                 [com.cemerick/friend        "0.2.1"]
                 [clojurewerkz/quartzite     "2.0.0"]
                 [com.draines/postal         "1.11.3"]
                 [org.clojure/tools.nrepl    "0.2.12"]
                 [http-kit                   "2.1.18"]
                 [org.clojure/java.jdbc      "0.3.5"]
                 [com.relaynetwork/kinematic "1.3.12"]
                 [korma                      "0.4.2"]
                 [org.clojure/java.jdbc      "0.3.7"]
                 [com.stuartsierra/component "0.2.3"]]
  :cljsbuild {:builds [{:source-paths ["src/philly_show_checker/app"]
                        :compiler     {:output-to     "public/js/philly_show_checker.js"
                                       :optimizations :whitespace
                                       :pretty-print  true}}]})
