(ns philly-show-checker.server.api.v1.session
  (:require [kinematic.dsl                              :as k-dsl]
            [philly-show-checker.server.session-helpers :as session-helpers]
            [philly-show-checker.server.models.account  :as account-model]
            [kinematic.bindings                         :refer [*session*]]))

(k-dsl/defapi :philly-show-checker-api-v1
  ["session"])

(defn attempt-login
  [{:keys [username email password]}]
  (def username username)
  (def email email)
  (def password password)
  (let [user-rec (account-model/lookup-user {:username username
                                             :email    email})]
    (cond
      (and user-rec (account-model/passwords-match? user-rec password))
      {:status "OK"
       :account user-rec}

      user-rec
      {:status "InvalidLogin"}

      :else
      {:status "UserNotFound"})))

(k-dsl/api-post
 (let [sid (session-helpers/session-user-id)]
   (def sid sid)
   (if (nil? sid)
     (if (attempt-login body)
       {:status "OK"
        :session-data @*session*}
       (account-model/signup-new-user body))
     ;; already logged in, just return session data
     {:status       "AlreadyLoggedIn"
      :session-data @*session*})))

(k-dsl/api-get
 {;;:status       "OK"
  :status "womp"
  :session-data @*session*})

(comment
  (conj [:div#main]
        [:div#nav]
        [:meow])
  )
