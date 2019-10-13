(ns safkalista-backend.receipts.handler
  (:require [compojure.api.sweet :refer :all]
            [compojure.api.core :refer [route-middleware]]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [safkalista-backend.receipts.receipts :as receipts]
            [ring.middleware.cors :refer [wrap-cors]]))

(def receipt-routes
  (context "/receipts" []
    (GET "/" []
      :return {:result s/Any}
      :query-params [ruoka :- s/Str]
      :summary "Returns receipt"
      (let [ruoka (receipts/get-receipts ruoka)]
        (if (some? ruoka)
          (ok {:result ruoka})
          (not-found
           {:error "Valitettavasti ruokaa ei löydy tietokannastamme!"}))))))
