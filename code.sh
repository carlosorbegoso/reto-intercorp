#!/bin/bash

# Lista de directorios de microservicios
microservices=("backend/DataStorageService" "backend/DataTransformerService" "backend/DataViewerService" "backend/XMLReaderService")

# Bucle a través de cada microservicio
for ms in "${microservices[@]}"
do
  echo "Building $ms"
  cd $ms
  ./gradlew build
  cd -
done

echo "Build complete"
