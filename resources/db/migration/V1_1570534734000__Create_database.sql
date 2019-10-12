CREATE TABLE receipts(
   id SERIAL PRIMARY KEY,
   created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   updated_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
   name VARCHAR(40),
   instructions TEXT,
   created_by_email TEXT,
   created_by_name TEXT,
   food_type VARCHAR(20),
   food_diet VARCHAR(20),
   version INTEGER
);

CREATE TABLE ingredients(
     id SERIAL PRIMARY KEY,
     name VARCHAR(25),
     description TEXT,
     ingredient_type VARCHAR(20),
     ingredient_diet VARCHAR(20)
);

CREATE TABLE receipts_ingredients(
    id SERIAL PRIMARY KEY,
    receipt_id INTEGER REFERENCES receipts(id),
    ingredient_id INTEGER REFERENCES ingredients(id)
);