(ns philly-show-checker.server.email
  (:require [postal.core :as postal]))

(def mailing-list ["patthomassoftware@gmail.com"
                   "pthomas@relaynetwork.com"])

(defn send-email
  [{:keys [text receiver]}]
  (postal/send-message
   {:from    "admin@philly-show-checker.com"
    :to      [receiver]
    :subject "Test..."
    :body    text}))

(defn send-emails
  [text]
  (doseq [receiver mailing-list]
    (send-email {:text     text
                 :receiver receiver})))

(comment
  (email/send-message
   {:from    "pt.notifications@pat.thomas"
    :to      ["patthomassoftware@gmail.com"]
    :subject "foofasldkfj asdlfkjasdl flaksdjfklasjdf laksjdf"
    :body    "foof aslkdfjalsd flkajs dlfkjasd"})
  (send-emails "woooo")
  )
