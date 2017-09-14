(ns undead.system
  (:require [com.stuartsierra.component :as component]
            [org.httpkit.server :refer [run-server]]
            [undead.web :refer [app]]))

(defn start-server [app port]
  (let [server (run-server app {:port port})]
    (println "Server started on localhost:" port)
    server))

(defn stop-server [server]
  (when server
    ;; run-server returns a fn that stops the server.
    (server)))

(defrecord ParensOfTheDead []
  component/Lifecycle
  (start [this]
    ;; notice the var quote so the start server has always a fresh definition
    (assoc this :server (start-server #'app 9009)))
  (stop [this]
    (stop-server (:server this))))

(defn create-system []
  (ParensOfTheDead.))

(defn -main [& args]
  (.start (create-system)))
