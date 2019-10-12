(ns safkalista-backend.receipts.handler
  (:require [compojure.api.sweet :refer :all]
            [compojure.api.core :refer [route-middleware]]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [safkalista-backend.receipts.receipts :as receipts]))


  (def receipt-routes
       (context "/receipts" []
                      (GET "/" []
                                 :return {:result s/Str}
                                 :query-params [ruoka :- s/Str]
                                 :summary "Returns receipt"
                                 (let [ruoka (:name (first (receipts/get-receipts ruoka)))]
                                   (ok {:result (str "this is your ruoka: " ruoka)})))))