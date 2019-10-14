cd ../..
lein do clean, ring uberjar
cd scripts/docker/
cp  ../../target/uberjar/server.jar .
cd ../..
docker-compose down
docker-compose build
docker-compose up

