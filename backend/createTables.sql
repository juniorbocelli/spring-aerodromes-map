CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT null,
  password VARCHAR(100) NOT null,
  token VARCHAR(100) null
);

CREATE TABLE aerodromes (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  city VARCHAR(100) NOT NULL,
  description VARCHAR(500) NOT NULL,
  dms VARCHAR(22) NOT NULL
  created_at VARCHAR(10)
);

CREATE TABLE runways (
  id SERIAL PRIMARY KEY,
  designation VARCHAR(5),
  width int NOT NULL,
  length int NOT NULL,
  CONSTRAINT fk_aerodrome_id FOREIGN KEY(aerodrome_id) REFERENCES aerodromes(id)
);
