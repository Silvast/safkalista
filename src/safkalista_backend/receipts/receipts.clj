(ns safkalista-backend.receipts.receipts
  (:require [safkalista-backend.db.queries :as queries]
            [safkalista-backend.conf :refer [config]]
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


(defn get-ingredients-by-ids [ids]
 (map #(:name %) (queries/get-ingredients-by-receipts-ids (:db-conf config)
                                                 {:receipt_ids ids})))


(defn get-random-receipts-by-type [food-type number]
   (vec (queries/get-random-receipts-by-type (:db-conf config) {:number_receipts number :food_type food-type})))

(defn get-food-list [wishes]
  ;[{:type "keitto" :number 1} {:type "uuniruoka" :number 1}]
  (flatten (map #(get-random-receipts-by-type (:food-type %) (:number %)) wishes)))

;; (def ingredients-ids (queries/add-ingredients (:db-conf config) {:names_ingredients [["maito"] ["sipuli"]]}))

;; (:id (first ingredients-ids))
;; (def receipt-id 1)
;; (mapv #(:id %) ingredients-ids)

;;   (queries/insert-receipts-ingredients (:db-conf config) {:receipts_ingredients (mapv #(into [] (list receipt-id (:id %))) ingredients-ids)})

;; (into [] (list 1 2))

(defn add-new-receipt [receipt-data]
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

;; (def receipt-data {:name "kaalilaatikko" :instructions "pistä uuniin" :food-type "uuniruoka" :ingredients [{:name "kaali"} {:name "soijarouhe"} {:name "puuroriisi"}]})

;; (add-new-receipt receipt-data)

;; (assoc receipt-data :id 1)

;; (def receipt         (queries/add-new-receipt (:db-conf config)
;;                                  {:name (:name receipt-data)
;;                                   :instructions
;;                                   (:instructions receipt-data)
;;                                   :food_type
;;                                   (:food-type receipt-data)}))

;; (def receipt-id (:id (first receipt)))

;; (def         ingredients (mapv  #(vec (list (:name %))) (:ingredients receipt-data)))

;; ingredients

;; (def     ingredients-ids (queries/add-ingredients (:db-conf config) {:names_ingredients ingredients}))

;; (add-new-receipt receipt-data)

;; (first (vec (str (first (mapv  #(:name %) (:ingredients data))))))

;; (first (mapv  #(:name %) (:ingredients data)))

;; (mapv  #(str "[" (:name %) "]") (:ingredients ingredients-data))

;;(add-new-receipt data)

;; (sequential? (get-food-list [{:food-type "uuniruoka" :number 1}]))


;; (get-random-receipts-by-type "perusruoka" 2)

;; (type (doall (map #(vector (first %) (* 2 (second %)))
;;             {:a 1 :b 2 :c 3})))

;; (def data [{:type "perusruoka" :number 2} {:type "uuniruoka" :number 1}])

;; (map #(get-random-receipts-by-type (:type %) (:number %)) data)

;; (get-random-receipts-by-type "perusruoka" 1)