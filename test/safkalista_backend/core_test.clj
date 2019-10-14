(ns safkalista-backend.core-test
  (:require [clojure.test :refer :all]
            [safkalista-backend.core :refer :all]
            [ring.mock.request :as mock]
            [cheshire.core :as cheshire]))

(defn parse-body [body]
  (cheshire/parse-string (slurp body) true))

(deftest get-pyynto-test
  (testing "Testing getting pyynto with parameters pyynto"
    (let [response
          (app (mock/request :get "/api/receipts?ruoka=Soijamakaronilaatikko"))
          body (:result (parse-body (:body response)))]
      (is (= (:status response) 200))
      (is (= (:name body) "Soijamakaronilaatikko")))))

(deftest food-not-found-test
  (testing "Testing getting error message for food that is not found"
    (let [response (app (mock/request :get "/api/receipts?ruoka=Lihasose"))
          body (:error (parse-body (:body response)))]
      (println body)
      (is (= (:status response) 404))
      (is (= body "Valitettavasti ruokaa ei löydy tietokannastamme!")))))