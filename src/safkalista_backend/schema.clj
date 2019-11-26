(ns safkalista-backend.schema
  (:require [schema.core :as s]))

(s/defschema Receipt
  "Receipt data"
  {(s/optional-key :id) s/Int
   :ingredients [{:name s/Str :id s/Int}]
   :instructions s/Str})

(s/defschema POSTResponse
  "POST response"
  {:id s/Int})