(ns naubay.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [naubay.config :refer [uri]])
  (:import com.mongodb.DB))

(defonce ^DB database
  (let [{:keys [conn db]} (mg/connect-via-uri uri)]
    db))

(defn get-products []
    (let [docs (mc/find-maps database "documents")]
    (map #(dissoc % :_id) docs)))

