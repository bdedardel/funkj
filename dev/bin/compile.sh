#!/bin/bash
echo "format"
ant format

echo "compile"
rm target/funkj-0.1-SNAPSHOT.jar
rm target/funkj-0.1-SNAPSHOT-jar-with-dependencies.jar
mvn --fail-fast clean package

