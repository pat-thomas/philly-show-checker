(ns philly-show-checker.server.models.account
  (:require [cemerick.friend.credentials   :as creds]
            [korma.core                    :as korma]
            [philly-show-checker.server.db :as db]))

(korma/defentity users)

(defn lookup-user-by-email
  [email]
  (korma/select users
                (korma/where {:email email})))

(defn signup-new-user
  [{:keys [email password]}]
  (let [hashed-password (creds/hash-bcrypt password)]
    (if-let [existing-user (lookup-user-by-email email)]
      {:status  "UserAlreadyExists"}
      {:status  "OK"
       :message "implement-signup-new-user"})))

(defn passwords-match?
  "This needs to decrypt that password out of user-rec at some point"
  [user-rec password]
  (= (:password user-rec)
     password))
