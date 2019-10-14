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


INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Uuniperuna tonnikalakastikkeella', 'perusruoka','kala', 'Laita ' ||
 'uuni kuumenemaan 225 ' ||
 'asteeseen. Pese perunat, kuivaa ja asettele folioon. Uuniin  tunniksi ja ' ||
  'profit. Sekoita tonnikalaan kermaviiliä, punasipulia ja mausteita. Profit' ||
   '.' ||
 '.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Uuniperuna', 'Esmes Rosamunda','Peruna', 'Vegaaninen');
INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('Tonnikala', 'Kasvis', 'kalaruoka');
INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('Punasipuli', 'Juures', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(3,7);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(3,8);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(3,9);


INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Kasvispihvit ja perunamuusi', 'perusruoka','kasvisruoka', 'Raasta ' ||
 'porkkanaa, perunaa ja kesäkurpitsaa. Lisää muna ja hieman korppujauhoja. ' ||
  'Paista pihvit. Keitä perunat, muussaa, sekoita hieman voita ja maitoa.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Porkkana', 'Kotimainen porkkana','Juures', 'vegaaninen');
INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('Korppujauho', 'Jauho', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(4,10);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(4,11);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(4,5);

INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Kalakeitto', 'keittoruoka','kala', 'Keitä perunat ja kasvikset. Lisää' ||
 ' kalaliemikuutio. Nauti kynttilänvalossa.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Lohi', 'Norjalainen merilohi','kala', 'kala');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(5,5);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(5,12);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(5,10);

INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Lasagnetti', 'Einesruoka','kasvisruoka', 'Valmista ohjeen mukaan.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Juustoraaste', 'Mikä tahansa juustoraaste','juusto', 'lakto');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(6,1);
INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(6,11);