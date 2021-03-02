(ns safkalista-backend.receipts.receipts
  (:require [safkalista-backend.db.queries :as queries]
            [safkalista-backend.conf :refer [config]]
            [clojure.tools.logging :as log]
            [try-let :refer [try-let]]))

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


(defn get-ingredients-by-receipt-ids [ids]
 (map #(:name %) (queries/get-ingredients-by-receipts-ids (:db-conf config)
                                                 {:receipt_ids ids})))


(defn get-random-receipts-by-type [food-type number]
   (vec (queries/get-random-receipts-by-type (:db-conf config) {:number_receipts number :food_type food-type})))

(defn get-food-list [wishes]
  (let [receipts (flatten (map #(get-random-receipts-by-type (str (:food-type %))(:number %)) wishes))
        receipt-ids (map #(:id %) receipts)]
    (if (> (count receipt-ids) 0)
      {:food-list receipts :ingredients-list (get-ingredients-by-receipt-ids receipt-ids)}
      (log/info "no receipts found"))))


(defn add-new-receipt [receipt-data]
  (log/info receipt-data)
  (try-let [receipt
            (queries/add-new-receipt (:db-conf config)
                                     {:name (:name receipt-data)
                                      :instructions
                                      (:instructions receipt-data)
                                      :food_type
                                      (:food-type receipt-data)})
            receipt-id (:id (first receipt))
            ingredients (mapv  #(vec (list (:name %))) (:ingredients receipt-data))
            ingredients-ids (queries/add-ingredients (:db-conf config) {:names_ingredients ingredients})
            receipts-ingredients (mapv #(into [] (list receipt-id (:id %))) ingredients-ids)
            receipts-ingredients-result  (queries/insert-receipts-ingredients (:db-conf config) {:receipts_ingredients receipts-ingredients})]
        (assoc receipt-data :id receipt-id) 
      (catch Exception e (str "caught exception: " (.getMessage e)))))