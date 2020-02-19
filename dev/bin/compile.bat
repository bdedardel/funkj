@echo off
echo compile
del target\funkj-0.1-SNAPSHOT.jar
del target\funkj-0.1-SNAPSHOT-jar-with-dependencies.jar
mvn --fail-fast package
pause
