#!/bin/bash
### OHNE SUDO!!! ###


host=127.0.0.1
user=postgres
port=5432

container=$(docker run -d -p $port:5432 postgres_with_scripts:latest) 
# postgres_create_db_scripts)
echo $container
sleep 5
docker exec  $container /bin/bash "createDb.sh" $host  $user


