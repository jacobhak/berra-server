(ns berra-server.db
  (:require [yesql.core :refer [defqueries]]))

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname "//localhost:5432/berradb"
              })

(defqueries "queries.sql" {:connection db-spec})
;;(insert-round<! {:game 1 :date (java.sql.Date/valueOf "2016-02-12")})

;;(insert-score! {:player 3 :round 2 :score 13})

;;(scores-for-round {:round 1})

(defn add-scores-to-round [round]
  (conj round {:scores (scores-for-round {:round (:id round)})}))

(defn scores-for-all-rounds []
  (map add-scores-to-round (get-rounds)))

(defn store-round [game date scores]
  (let [round (:id (insert-round<! {:game game :date (java.sql.Date/valueOf date)}))]
    (map #(insert-score! {:player (% "player") :score (% "score") :round round}) scores)))

;;(scores-for-all-rounds)

