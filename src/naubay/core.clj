(ns naubay.core
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [ring.middleware.json :refer [wrap-json-response wrap-json-body]]
    [ring.util.response :as ring]
    [naubay.config :refer [port]]
    [org.httpkit.server :refer [run-server]])
  (:gen-class))

(defn debug [stuff]
  (println stuff)
  stuff)

(defn cors
  [handler]
  (fn [request]
    (let [response (handler request)]
      (-> response
        (assoc-in [:headers "Access-Control-Allow-Origin"]  "*")
        (assoc-in [:headers "Access-Control-Allow-Methods"] "GET,PUT,POST,DELETE,OPTIONS")
        (assoc-in [:headers "Access-Control-Allow-Headers"] "X-Requested-With,Content-Type,Cache-Control")))))


(defroutes all-routes
  (GET "/" [] (ring/response {:kez "kelgen"}))
  (GET "/:name" [name] (ring/response {:kez (str "kelgen " name)}))
  (route/not-found {:error "not found"}))

(def handlers
  (-> all-routes
      cors
      wrap-json-response
      (wrap-json-body {:keywords? true})))

(defonce server (atom nil))
(defn restart-server []
  (when (some? @server)
    (@server :timeout 100)
    (reset! server nil)
    (reset! server (run-server handlers {:port port}))))

(defn -main []
  (println "Serving commenced!")
  (reset! server (run-server handlers {:port port})))

(comment (restart-server))
