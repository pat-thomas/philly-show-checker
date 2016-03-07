(ns philly-show-checker.server.api.v1.session
  (:require [kinematic.dsl                              :as k-dsl]
            [philly-show-checker.server.session-helpers :as session-helpers]
            [philly-show-checker.server.models.account  :as account-model]
            [kinematic.bindings                         :refer [*session*]]))

(k-dsl/defapi :philly-show-checker-api-v1
  ["session"])

(defn attempt-login
  [{:keys [username email password]}]
  )

(k-dsl/api-post
 (def request request)
 (def body body)
 (if (nil? (session-helpers/session-user-id))
   (if (attempt-login body)
     {:status "OK"
      :session-data @*session*}
     (account-model/signup-new-user body))
   ;; already logged in, just return session data
   {:status "AlreadyLoggedIn"
    :session-data @*session*}))

(k-dsl/api-get
 {:status  "OK"
  :message "pong!"})




