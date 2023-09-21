#!/bin/bash

echo "Iniciando ambiente de produção..."
cp ./docker/Dockerfile ./Dockerfile

echo "Construindo containers de produção..."
docker image build -t aerodromes_map_server_prod:latest .

rm ./Dockerfile
