(ns safkalista-backend.receipts.handler
  (:require [compojure.api.sweet :refer :all]
            [compojure.api.core :refer [route-middleware]]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [safkalista-backend.receipts.receipts :as receipts]
            [ring.middleware.cors :refer [wrap-cors]]
            [safkalista-backend.schema :as schema]))

(def receipt-routes
  (context "/receipts" []
    (GET "/" []
      :return {:result s/Any}
      :query-params [ruoka :- s/Str]
      :summary "Returns receipt"
      (let [ruoka (receipts/get-receipts ruoka)]
        (if (some? (:name ruoka))
          (ok {:result ruoka})
          (not-found
           {:error "Valitettavasti ruokaa ei löydy tietokannastamme!"}))))
    (GET "/random" []
      :return {:result s/Any}
      :query-params [number :- s/Int]
      :summary "Returns random receipts"
      (let [response (receipts/get-random-receipts number)]
        (if (some? response)
          (ok {:result response})
          (not-found
           {:error "Joku meni nyt kyllä mönkään!"}))))
    
    (POST "/list" [:as request]
      :return {:result schema/WishesResponse}
      :body [wishes schema/Wishes]
      :summary "Returns random receipts"
      (let [response (receipts/get-food-list wishes)]
        (if (some? response)
          (ok {:result response})
          (not-found
           {:error "Joku meni nyt kyllä mönkään!"}))))
    
    (POST "/add-new" [:as request]
      :return {:result schema/Receipt}
      :body [receipt schema/Receipt]
      :summary "Adds new receipt"
      (let [response (receipts/add-new-receipt receipt)]
        (if (some? response)
          (ok {:result response})
          (not-found
           {:error "Joku meni nyt kyllä mönkään!"}))))
    ))