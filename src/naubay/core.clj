(ns naubay.core
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [naubay.config :refer [port]]
    [org.httpkit.server :refer [run-server]])
  (:gen-class))

(defroutes all-routes
  (GET "/" [] "Sälem, Älem!")
  (route/not-found "<p>Page not found.</p>")) ;; all other, return 404

(defn -main []
  (run-server all-routes {:port port}))

