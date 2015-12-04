(ns philly-show-checker.server.core
  (:require [philly-show-checker.server.scraper :as scraper]
            [clojure.tools.nrepl.server         :as nrepl]))

(def nrepl-server (atom nil))

(defn start-nrepl
  [port]
  (reset! nrepl-server (nrepl/start-server :port port))
  (println (format "starting nrepl on port %s" port)))

(defn start-webserver
  [port]
  (println (format "implement start-webserver (running on port %s)" port)))

(defn -main
  [& args]
  (start-webserver 6888)
  (scraper/init-jobs!)
  (start-nrepl 7888))


