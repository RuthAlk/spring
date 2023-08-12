#!/bin/bash

set -e

echo "Simple startup script, should be run from directory where this script is."


cd spring_server
./gradlew dockerCreateDockerfile
cd -

docker-compose build
docker-compose up -d

echo "Now open browser at http://localhost:7070 "
