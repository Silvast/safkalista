(ns safkalista-backend.core
  (:require [safkalista-backend.receipts.handler :refer [receipt-routes]]
            [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [jumblerg.middleware.cors :refer [wrap-cors]]
            ;;[ring.middleware.cors :refer [wrap-cors]]
            )
  (:gen-class))

(def app
  (-> (api
       {:swagger
        {:ui "/"
         :spec "/swagger.json"
         :data {:info {:title "Safkaa"
                       :description "Compojure Api example"}
                :tags [{:name "api", :description "some apis"}]}}}
       (context "/api" []
         :tags ["api"]
                receipt-routes))
      (wrap-cors :access-control-allow-origin #"http://localhost:3449"
                 :access-control-allow-headers ["Origin" "X-Requested-With"
                                                "Content-Type" "Accept"]
                 :access-control-allow-methods [:get :put :post :delete :options])))