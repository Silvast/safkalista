(ns safkalista-backend.db.queries
  (:require [hugsql.core :as hugsql]))

(hugsql/def-db-fns "safkalista_backend/db/sql/receipts.sql")

(hugsql/def-sqlvec-fns "safkalista_backend/db/sql/receipts.sql")