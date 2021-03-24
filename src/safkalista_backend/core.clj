(ns safkalista-backend.core
  (:require [safkalista-backend.receipts.handler :refer [receipt-routes]]
            [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [compojure.handler :refer [site]]
            [ring.adapter.jetty :as jetty]
            [safkalista-backend.db.migrations :as m]
            [schema.core :as s]
            [jumblerg.middleware.cors :refer [wrap-cors]]
            [safkalista-backend.conf :refer [config]])
  (:gen-class))

(def app
  (->
   (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Safkaa"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]}}}
    (context "/api" []
      :tags ["api"]
      receipt-routes))
   (wrap-cors :access-control-allow-origin #"http://localhost:8280"
              :access-control-allow-headers ["Origin" "X-Requested-With"
                                             "Content-Type" "Accept"]
              :access-control-allow-methods [:get :put :post :delete :options])))

(defn -main [& [port]]
  (let [port (Integer. (or port 3001))]
    (m/migrate!)
    (jetty/run-jetty (site #'app) {:port port :join? false})))