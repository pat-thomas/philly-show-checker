(ns philly-show-checker.server.models.account
  (:require [schema.core :as s]))

(def SignupCriteria
  {(s/required-key :username) s/Str
   (s/required-key :email)    s/Str
   (s/required-key :password) s/Str})

(s/defn signup-new-user
  [signup-criteria :- SignupCriteria]
  (let [{:keys [username email password]} signup-criteria]
    {:status  "OK"
     :message "implement-signup-new-user"}))
