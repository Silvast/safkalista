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

-- :name get-random-receipts :? :number_receipts
-- :command :query
-- :doc Get random receipts, have to fix this though, not very efficient
SELECT * FROM (SELECT DISTINCT * FROM receipts) AS r ORDER BY RANDOM() LIMIT :number_receipts

-- :name get-random-receipts-by-type :? :number_receipts :food_type
-- :command :query
-- :doc Get random receipts, have to fix this though, not very efficient
SELECT id, name, instructions FROM (SELECT DISTINCT * FROM receipts WHERE food_type = :food_type) AS r ORDER BY RANDOM() LIMIT :number_receipts

-- :name get-ingredients-by-receipts-ids :? :receipt_ids
-- :command :query
-- :doc Get receipt ingredients by receipt ids
SELECT ingredients.name
  FROM receipts
  JOIN receipts_ingredients
    ON receipts_ingredients.receipt_id = receipts.id
  JOIN ingredients
    ON receipts_ingredients.ingredient_id = ingredients.id
 WHERE receipts.id  IN (:v*:receipt_ids)


-- :name get-receipts-by-receipts-ids :? :receipt_ids
-- :command :query
-- :doc Get receipt names and instructions by receipt ids
SELECT name, instructions FROM receipts WHERE id IN (:v*:receipt_ids)

-- :name add-new-receipt :<!
-- :doc insert receipt names and instructions
insert into receipts (name, instructions, food_type) values (:name, :instructions, :food_type) returning id

-- :name add-ingredients :? :names_ingredients :<!
-- :doc insert ingredients
insert into ingredients (name) values :tuple*:names_ingredients returning id

-- :name insert-receipts-ingredients  :? :receipts_ingredients :<!
-- :doc Insert multiple characters with :tuple* parameter type
insert into receipts_ingredients (receipt_id, ingredient_id)
values :tuple*:receipts_ingredients returning id