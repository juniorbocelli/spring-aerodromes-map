#!/bin/bash

echo "Iniciando ambiente de produção..."
cp ./docker/react_server/Dockerfile-prod ./Dockerfile

echo "Construindo containers de produção..."
docker image build -t aerodromes_map_client_prod:latest .

rm ./Dockerfile
