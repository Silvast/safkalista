(ns safkalista-backend.receipts.receipts
  (:require [safkalista-backend.db.queries :as queries]
            [safkalista-backend.conf :refer [config]]))

(defn get-ingredients [receipt-name]
  (let [ingredients
        (queries/get-ingredients-by-receipt-name (:db-conf config)
                                                 {:receipt_name receipt-name})]
    (map :name ingredients)))

(defn get-receipts [receipt-name]
  (let [receipt (queries/get-receipts-by-name (:db-conf config) {:receipt_name
                                                     receipt-name})
        ingredients (get-ingredients receipt-name)]
    (merge (first receipt)
           {:ingredients ingredients})))

(defn get-random-receipts [number]
  (queries/get-random-receipts (:db-conf config) {:number_receipts
                                                   number}))
