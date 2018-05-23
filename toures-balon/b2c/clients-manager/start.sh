#!/bin/bash

echo "inicia instalacion contenedor!"
mvn clean package -Dmaven.test.skip=true

echo "container b2c-clients"
docker build -t b2c-clients .

echo "inicia contenedor"
docker run \
 --name b2c-clients \
 -p 10181:9181 \
  -it b2c-clients

exit
