-- noinspection SqlNoDataSourceInspectionForFile

-- :name get-receipts-by-name :? :receipt_name
-- :command :query
-- :doc Get receipt by its name
SELECT * FROM receipts WHERE name = :receipt_name

-- :name get-ingredients-by-receipt-name :? :receipt_name
-- :command :query
-- :doc Get receipt ingredients by receipt name
SELECT ingredients.name
  FROM receipts
  JOIN receipts_ingredients
    ON receipts_ingredients.receipt_id = receipts.id
  JOIN ingredients
    ON receipts_ingredients.ingredient_id = ingredients.id
 WHERE receipts.name = :receipt_name