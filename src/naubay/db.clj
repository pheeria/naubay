(ns naubay.db
  (:require [mount.core :refer [defstate]]
            [monger.core :as mg]
            [monger.collection :as mc]
            [naubay.config :refer [uri]])
  (:import com.mongodb.DB))

; (defonce ^DB dbV
;   (let [{:keys [conn db]} (mg/connect-via-uri uri)]
;     db))

(defn get-products []
  (let [{:keys [conn db]} (mg/connect-via-uri uri)
    docs (mc/find-maps db "documents")]
    (println docs)
    (map #(dissoc % :_id) docs)))



; (defn stop-db [db]
;   (mg/disconnect (:conn db)))

; (defonce database (atom nil))

; (defstate db
;   :start (start-db)
;   :stop (stop-db db))

; (defn get-database []
;   (when (nil? @database)
;     (reset! database (start-db)))
;   database)
