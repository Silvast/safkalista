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
