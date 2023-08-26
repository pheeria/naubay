(ns naubay.db
  (:require [mount.core :refer [defstate]]
            [monger.core :as mg]
            [monger.collection :as mc]
            [naubay.config :refer [uri]]))

(defn start-db []
  (let [{:keys [conn db]} (mg/connect-via-uri uri)]
    db))

(defn stop-db [db]
  (mg/disconnect (:conn db)))

(defstate db
  :start (start-db)
  :stop (stop-db db))

