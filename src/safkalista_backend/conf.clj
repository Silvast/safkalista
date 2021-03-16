(ns safkalista-backend.conf
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]
            [environ.core :refer [env]]))

(def ^:private config-file "resources/configuration/default.edn")

(defn- load-config [file]
  (with-open [reader (io/reader file)]
    (edn/read (java.io.PushbackReader. reader))))

(defn get-config []
 (let [conf (load-config config-file)]
   (if (some? (System/getenv "DB_URL"))
     (assoc-in conf [:database-url] (System/getenv "DB_URL"))
     conf)))

(def config (get-config))