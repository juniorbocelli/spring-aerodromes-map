#!/bin/bash

docker kill aerodromes_map_client_prod
docker rm aerodromes_map_client_prod

docker run -d --restart=always -p 80:80 --name aerodromes_map_client_prod \
    aerodromes_map_client_prod
