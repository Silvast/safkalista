INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Soijamakaronilaatikko', 'uuniruoka','kasvisruoka', 'Sekoita kulhossa soijarouhe' ||
 'ja vesi. Anna niiden turvota noin 10 minuuttia. Keitä makaronit suolalla maustetussa,' ||
  'runsaassa vedessä melkein kypsiksi. Kuori ja raasta porkkana. Sekoita raaste, makaronit ja' ||
   'soijaseos keskenään ja kaada voideltuun uunivuokaan. Sekoita munat ja maito keskenään ja kaada' ||
    ' tasaisesti laatikon pinnalle. Paista 200 asteessa noin 40 minuuttia.'),
    ('Nakkikastike', 'perusruoka','liharuoka', 'Paista nakit ja nauti.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('soijarouhe', 'soijapavuista tehty rouhe','kuivatuote', 'vegaaninen');
INSERT INTO ingredients(name, description, ingredient_diet)
VALUES('kananmuna', 'kananmuna', 'laktoovo'),('Öljy', 'rasva', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES (1,1), (1,
2), (1,3);


INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Nakki', 'Nakki nakkipaketista','Jääkaappituote', 'Lihatuote'),
 ('Peruna', 'Juures', 'Viileäkaappituote', 'vegaaninen'),
 ('Sipuli', 'Juures', 'Viileäkaappituote', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(2,4), (2,
5), (2,6);

INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Uuniperuna tonnikalakastikkeella', 'perusruoka','kala', 'Laita ' ||
 'uuni kuumenemaan 225 ' ||
 'asteeseen. Pese perunat, kuivaa ja asettele folioon. Uuniin  tunniksi ja ' ||
  'profit. Sekoita tonnikalaan kermaviiliä, punasipulia ja mausteita. Profit' ||
   '.' ||
 '.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Uuniperuna', 'Esmes Rosamunda','Peruna', 'Vegaaninen'),
 ('Tonnikala', 'Kala', 'Eläin', 'Pesco'),
 ('Punasipuli', 'Juures', 'Sipuli', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(3,7), (3,
8), (3,9);

INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Kasvispihvit ja perunamuusi', 'perusruoka','kasvisruoka', 'Raasta ' ||
 'porkkanaa, perunaa ja kesäkurpitsaa. Lisää muna ja hieman korppujauhoja. ' ||
  'Paista pihvit. Keitä perunat, muussaa, sekoita hieman voita ja maitoa.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Porkkana', 'Kotimainen porkkana','Juures', 'vegaaninen'),
 ('Korppujauho', 'Jauho', '', 'vegaaninen');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(4,10), (4,
11), (4,5);

INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Kalakeitto', 'keittoruoka','kala', 'Keitä perunat ja kasvikset. Lisää' ||
 ' kalaliemikuutio. Nauti kynttilänvalossa.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Lohi', 'Norjalainen merilohi','kala', 'kala');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(5,5), (5,
12), (5,10);

INSERT INTO receipts(name, food_type, food_diet, instructions)
VALUES('Lasagnetti', 'Einesruoka','kasvisruoka', 'Valmista ohjeen mukaan.');

INSERT INTO ingredients(name, description, ingredient_type, ingredient_diet)
 VALUES('Juustoraaste', 'Mikä tahansa juustoraaste','juusto', 'lakto');

INSERT INTO receipts_ingredients(receipt_id, ingredient_id) VALUES(6,1), (6,11);
