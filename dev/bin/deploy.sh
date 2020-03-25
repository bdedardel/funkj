#!/bin/bash
./bin/compile.sh

# see: https://www.baeldung.com/maven-goals-phases
# mvn help:describe -Dcmd=package
# It is a part of the lifecycle for the POM packaging 'jar'. This lifecycle includes the following phases:
# validate: Not defined
# initialize: Not defined
# generate-sources: Not defined
# process-sources: Not defined
# generate-resources: Not defined
# process-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:resources
# compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:compile
# process-classes: Not defined
# generate-test-sources: Not defined
# process-test-sources: Not defined
# generate-test-resources: Not defined
# process-test-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:testResources
# test-compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile
# process-test-classes: Not defined
# test: org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test
# prepare-package: Not defined
# package: org.apache.maven.plugins:maven-jar-plugin:2.4:jar
# pre-integration-test: Not defined
# integration-test: Not defined
# post-integration-test: Not defined
# verify: Not defined
# install: org.apache.maven.plugins:maven-install-plugin:2.4:install
# deploy: org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy

if [ -f target/funkj-0.1-SNAPSHOT-jar-with-dependencies.jar ];
then
  echo "deploy to local maven repository"
  mvn install:install-file \
  -DgroupId=com.bidjisoft.funkj \
  -DartifactId=funkj \
  -Dversion=0.1-SNAPSHOT \
  -Dfile=target/funkj-0.1-SNAPSHOT-jar-with-dependencies.jar \
  -Dpackaging=jar \
  -DgeneratePom=true

  echo "deploy funkj.jar to $ANT_HOME/lib/"
  sudo cp target/funkj-0.1-SNAPSHOT-jar-with-dependencies.jar $ANT_HOME/lib/funkj.jar      
fi



