#!/bin/bash

echo "inicia instalacion contenedor!"
mvn clean package -Dmaven.test.skip=true

echo "container b2c-shoppingcar"
docker build -t b2c-shoppingcar .

echo "inicia contenedor"
docker run \
 --name b2c-shoppingcart \
 -p 10182:9182 \
 -d -it b2c-shoppingcar

exit
