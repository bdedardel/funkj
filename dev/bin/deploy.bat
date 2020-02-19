@echo off

cd ..

echo ===== compile =====
cmd /C "mvn --quiet package"

echo ===== copy to ant %ANT_HOME% =====
echo f | xcopy /Y .\target\funkj-0.1-SNAPSHOT-jar-with-dependencies.jar "%USERPROFILE%"\.ant\lib\funkj.jar 

echo ===== install to local repo =====
cmd /C "mvn --quiet install:install-file -DgroupId=net.sourceforge.funkj -DartifactId=funkj -Dversion=0.1-SNAPSHOT -Dfile=target\funkj-0.10-SNAPSHOT-jar-with-dependencies.jar -Dpackaging=jar -DgeneratePom=true"

echo ===== done =====
pause