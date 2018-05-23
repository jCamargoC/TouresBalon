 #!/bin/bash

echo "inicia instalacion contenedor!"
#mvn clean package -Dmaven.test.skip=true

docker run \
 -p 80:4200 --name b2cfront \
 -it touresbalon/b2c-frontend

exit
