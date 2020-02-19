@echo off
echo copy to %ANT_HOME%
rem copy /? xcopy /? robocopy /?
echo f | xcopy /Y .\target\funkj-0.1-SNAPSHOT-jar-with-dependencies.jar "%ANT_HOME%"\lib\funkj.jar 
rem pause
