-- noinspection SqlNoDataSourceInspectionForFile

-- :name get-receipts-by-name :? :receipt_name
-- :command :query
-- :doc Get receipt by its name
SELECT * FROM receipts WHERE name = :receipt_name