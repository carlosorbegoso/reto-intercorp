#!/bin/bash

microservices=("backend/DataStorageService" "backend/DataTransformerService" "backend/DataViewerService" "backend/XMLReaderService")

for ms in "${microservices[@]}"
do
  echo "Building $ms"
  cd $ms
  ./gradlew build
  cd -
done

echo "Build complete"
