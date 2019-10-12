(ns safkalista-backend.db.migrations
  (:require [safkalista-backend.conf :refer [config]])
  (:import org.flywaydb.core.Flyway))

(def flyway
  (-> (Flyway/configure)
      (.dataSource
       (format
        "jdbc:%s://%s:%d/%s?user=%s&password=%s"
        (:db-type (:db-conf config))
        (:db-server (:db-conf config))
        (:db-port (:db-conf config))
        (:db-name (:db-conf config))
        (:db-username (:db-conf config))
        (:db-password (:db-conf config)))
       nil
       nil)
      (.load)))

(defn migrate! []
  (.migrate flyway))

(defn clean! []
  (.clean flyway))