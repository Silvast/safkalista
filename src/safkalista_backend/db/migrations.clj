(ns safkalista-backend.db.migrations
  (:require [safkalista-backend.conf :refer [config]])
  (:import org.flywaydb.core.Flyway))


;;This stupid hack is because github actions does not find default.edn
(def db-url 
  (if (some? (not-empty (:database-url config)))
    (:database-url config)
    "jdbc:postgresql://localhost:5432/safkalista?user=safkalista_user&password=abc1232"))

(def flyway
  (-> (Flyway/configure)
      (.dataSource
      db-url
       nil
       nil)
      (.load)))


(defn migrate! []
  (.migrate flyway))

(defn clean! []
  (.clean flyway))