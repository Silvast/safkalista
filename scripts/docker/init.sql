CREATE USER docker;
CREATE DATABASE safkalista;
CREATE ROLE "safkalista_user" WITH PASSWORD 'possu' login;
GRANT ALL PRIVILEGES ON DATABASE safkalista TO "safkalista_user";