(ns safkalista-backend.core
  (:require [safkalista-backend.receipts.handler :refer [receipt-routes]]
            [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s])
  (:gen-class))

(def app
  (api
   {:swagger
    {:ui "/"
     :spec "/swagger.json"
     :data {:info {:title "Safkaa"
                   :description "Compojure Api example"}
            :tags [{:name "api", :description "some apis"}]}}}
   (context "/api" []
     :tags ["api"]
     receipt-routes)))