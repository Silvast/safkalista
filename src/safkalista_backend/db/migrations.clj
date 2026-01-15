(ns safkalista-backend.db.migrations
  (:require [safkalista-backend.conf :refer [config]])
  (:import [org.flywaydb.core Flyway]))

(def db-url
  (or (not-empty (System/getenv "DB_URL"))
      (:database-url config)))

(def flyway
  (-> (Flyway/configure)
      (.dataSource db-url nil nil)
      (.cleanDisabled false)  ;; Required for Flyway 10+ to allow clean
      (.load)))

(defn migrate! []
  (.migrate flyway))

(defn clean! []
  (.clean flyway))