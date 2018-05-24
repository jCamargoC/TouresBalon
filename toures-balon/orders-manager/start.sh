
#!/bin/bash
echo "======================================================="
echo "inicia instalacion contenedor!"
echo "======================================================="
echo "compila aplicacion"
mvn clean package -Dmaven.test.skip=true
echo "======================================================="
echo "======================================================="
echo "compila imagen docker - reservas"
docker build -t reservas .
echo "======================================================="
echo "======================================================="
echo "corre imagen del contenedor"
docker run \
 --name reservas \
 -p 10183:10183 \
 -it reservas
echo "======================================================="
echo "======================================================="
echo "fin"
exit
