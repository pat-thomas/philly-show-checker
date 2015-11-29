(ns philly-show-checker.server.core
  (:require [clojurewerkz.quartzite.scheduler :as qs]
            [postal.core                      :as email]
            [clojure.tools.nrepl.server       :as nrepl]))

(def mailing-list ["patthomassoftware@gmail.com"
                   "pthomas@relaynetwork.com"])

(def nrepl-server (atom nil))

(defn start-nrepl
  [port]
  (reset! nrepl-server (nrepl/start-server :port port))
  (println (format "starting nrepl on port %s" port)))

(defn send-email
  [{:keys [text receiver]}]
  (email/send-message
   {:from    "admin@philly-show-checker.com"
    :to      [receiver]
    :subject "Test..."
    :body    text}))

(defn send-emails
  [text]
  (doseq [receiver mailing-list]
    (send-email {:text     text
                 :receiver receiver})))

(defn -main
  [& args]
  (start-nrepl 7888))

(comment
  (email/send-message
   {:from    "pt.notifications@pat.thomas"
    :to      ["patthomassoftware@gmail.com"]
    :subject "foofasldkfj asdlfkjasdl flaksdjfklasjdf laksjdf"
    :body    "foof aslkdfjalsd flkajs dlfkjasd"})
  (send-emails "woooo")
  )
