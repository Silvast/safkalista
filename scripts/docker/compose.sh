cd ../..
lein do clean, ring uberjar
cd scripts/docker/
cp  ../../target/uberjar/server.jar .
docker-compose down
docker-compose build
docker-compose up

