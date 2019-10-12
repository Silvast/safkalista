(ns safkalista-backend.db.migrations
  (:require [safkalista-backend.conf :refer [db-config]])
  (:import org.flywaydb.core.Flyway))


(def flyway
  (-> (Flyway/configure)
      (.dataSource
        (format
          "jdbc:%s://%s:%d/%s?user=%s&password=%s"
          (:db-type db-config)
          (:db-server db-config)
          (:db-port db-config)
          (:db-name db-config)
          (:db-username db-config)
          (:db-password db-config))
        nil
        nil)
      (.load)))

(defn migrate! []
  (.migrate flyway))

(defn clean! []
  (.clean flyway))