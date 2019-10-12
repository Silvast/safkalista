(ns safkalista-backend.receipts.receipts
  (:require [safkalista-backend.db.queries :as queries]
            [safkalista-backend.conf :refer [config]]))

(defn get-receipts [name]
  (queries/get-receipts-by-name (:db-conf config) {:receipt_name name}))