INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Soijamakaronilaatikko', 'uuniruoka','kasvisruoka', 'Sekoita kulhossa soijarouhe ja vesi. Anna niiden turvota noin 10 minuuttia. Keitä makaronit suolalla maustetussa, runsaassa vedessä melkein kypsiksi. Kuori ja raasta porkkana. Sekoita raaste, makaronit ja soijaseos keskenään ja kaada voideltuun uunivuokaan. Sekoita munat ja maito keskenään ja kaada tasaisesti laatikon pinnalle. Paista 200 asteessa noin 40 minuuttia.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('soijarouhe', 'soijapavuista tehty rouhe','kuivatuote', 'vegaaninen');

INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('kananmuna', 'kananmuna', 'laktoovo');

INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('Öljy', 'rasva', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(1,1);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(1,2);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(1,3);


INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Nakkikastike', 'perusruoka','liharuoka', 'Paista nakit ja nauti.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Nakki', 'Nakki nakkipaketista','Jääkaappituote', 'Lihatuote');

INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('Peruna', 'Juures', 'vegaaninen');

INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('Sipuli', 'Juures', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(2,4);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(2,5);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(2,6);
