(ns philly-show-checker.app.xhr-util
  (:require [goog.events       :as events]
            [cognitect.transit :as t])
  (:import [goog.net XhrIo]
           goog.net.EventType
           [goog.events EventType]))

(def ^:private meths
  {:get    "GET"
   :put    "PUT"
   :post   "POST"
   :delete "DELETE"})

(def json-reader (t/reader :json))
(def json-writer (t/writer :json-verbose))

(defn make-xhr
  [{:keys [method url data on-complete]}]
  (let [url (str "http://localhost:3141/api/v1/" url)
        xhr (XhrIo.)]
    (events/listen xhr goog.net.EventType.COMPLETE
                   (fn [e]
                     (on-complete (t/read json-reader (.getResponseText xhr)))))
    (. xhr
       (send url
             (meths method)
             (.stringify js/JSON (clj->js data))
             #js {"Content-Type" "application/json"}))))
