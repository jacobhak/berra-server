(ns berra-server.core
  (:use ring.middleware.json
        compojure.core)
  (:require [compojure.core :refer [defroutes GET POST]]
            [ring.adapter.jetty :as ring]
            [ring.util.response :refer [response]]
            [berra-server.db :as db]
            [compojure.route :as route]))

(defroutes app-routes
  (context "/rounds" []
           (GET "/" [] (db/scores-for-all-rounds))
           (POST "/" {body :body} (db/store-round (body "game") (body "date") (body "scores"))))
  (context "/players" [] 
           (GET "/" [] (db/get-players))
           (POST "/" {body :body} {:result (db/insert-player! {:name (body "name")})}))
  (context "/games" [] 
           (GET "/" [] (db/get-games))
           (POST "/" {body :body} {:result (db/insert-game! {:name (body "name")})}))

  (route/not-found (response {:message "Not found"})))

(def app
  (-> app-routes
      wrap-json-response
      wrap-json-body))

(defonce server (ring/run-jetty #'app {:port 8080 :join? false}))

(defn -main []
  (.start server))

