(ns safkalista-backend.schema
  (:require [schema.core :as s]
            [safkalista-backend.receipts.receipts :as r]))

(s/defschema Receipt
  "Receipt data"
  {(s/optional-key :id) s/Int
   :ingredients [{:name s/Str (s/optional-key :id) s/Int}]
   :instructions s/Str
   :food-type s/Str
   :name s/Str})

(s/defschema POSTResponse
  "POST response"
  {:id s/Int})


(s/defschema Wishes
  "Receipt wishes data"
  {:number s/Int
    :food-type s/Str})

(s/defschema WishesResponse
  "Wishes response  data"
{:food-list 
 [{:id s/Int
   :name s/Str
   :instructions s/Str}]
 :ingredients-list [s/Str]})