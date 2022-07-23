#!/bin/bash
#remove old 
#rm /tmp/.X99-lock #needed when docker container is restarted
Xvfb :99 -screen 0 640x480x8 -nolisten tcp &
cd /home/app
ls -al
mvn --version
java --version
javac --version
mvn -f pom.xml javafx:run
