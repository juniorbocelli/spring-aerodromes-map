#!/bin/bash

docker kill aerodromes_map_server_prod
docker rm aerodromes_map_server_prod

docker run -d --restart=always -p 8080:8080 -p 5432:5432 --name aerodromes_map_server_prod \
    aerodromes_map_server_prod
