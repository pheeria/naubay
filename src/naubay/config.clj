(ns naubay.config)

(def port (Integer/parseInt
           (or (System/getenv "PORT") "8000")))
