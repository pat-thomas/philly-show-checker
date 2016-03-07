(ns philly-show-checker.server.core
  (:require [philly-show-checker.server.scraper :as scraper]
            [kinematic.core                     :as kinematic]
            [kinematic.dsl                      :as k-dsl]
            [org.httpkit.server                 :as http]
            [ring.middleware.session            :as session]
            [ring.middleware.session.cookie     :as session-cookie]
            [clojure.tools.nrepl.server         :as nrepl]))

(def nrepl-server (atom nil))

(defn start-nrepl
  [port]
  (reset! nrepl-server (nrepl/start-server :port port))
  (println (format "starting nrepl on port %s" port)))

(k-dsl/defweb :philly-show-checker-api-v1
  :mount-point "/v1/"
  :app-ns-prefix :philly-show-checker.server.api.v1
  :before-middleware [#(session/wrap-session % {:store (session-cookie/cookie-store {:key "0b9d0d8b990d4ade"})})])

(defonce stop-server-fn (atom nil))

(defn start-webserver
  [port]
  (when-not (nil? @stop-server-fn)
    (@stop-server-fn))
  (reset! stop-server-fn (http/run-server (k-dsl/dyn-handler :philly-show-checker-api-v1)
                                          {:port port}))
  (println (format "webserver started on port %s" port)))

(defn -main
  [& args]
  (scraper/init-jobs!)
  (start-webserver 6888)
  (start-nrepl 7888))

(comment
  (start-webserver 6888)
  )

