#!/bin/bash

docker kill xmobots-postgresql
docker rm xmobots-postgresql

docker run \
  --name xmobots-postgresql \
  -e POSTGRES_PASSWORD=test1234 \
  -p 5432:5432 postgres
