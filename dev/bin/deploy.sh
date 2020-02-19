#!/bin/bash
./bin/compile.sh

if [ -f target/funkj-0.1-SNAPSHOT-jar-with-dependencies.jar ];
then
  echo "deploy to local maven repository"
  mvn install:install-file \
  -DgroupId=net.sourceforge.funkj \
  -DartifactId=funkj \
  -Dversion=0.1-SNAPSHOT \
  -Dfile=target/funkj-0.1-SNAPSHOT-jar-with-dependencies.jar \
  -Dpackaging=jar \
  -DgeneratePom=true

  echo "deploy funkj.jar to $ANT_HOME/lib/"
  cp target/funkj-0.1-SNAPSHOT-jar-with-dependencies.jar $ANT_HOME/lib/funkj.jar      
fi



