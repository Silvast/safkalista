(ns safkalista-backend.core
  (:require [safkalista-backend.receipts.handler :refer [receipt-routes]]
            [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [compojure.handler :refer [site]]
            [ring.adapter.jetty :as jetty]
            [safkalista-backend.db.migrations :as m]
            [schema.core :as s]
            [jumblerg.middleware.cors :refer [wrap-cors]]
            [clojure.tools.logging :as log]
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

(defn -main [& args]
  (let [port (Integer. (or (first args) 3001))
        run-migrations (or (second args) (System/getenv "RUN_MIGRATIONS") false)]
    (if run-migrations
     (m/migrate!)
     (log/info "No migrations will be run"))
    (jetty/run-jetty (site #'app) {:port port})))