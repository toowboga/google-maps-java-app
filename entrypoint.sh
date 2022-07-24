#!/bin/bash
# create a virtual monitor with Xvfb
Xvfb :99 -screen 0 1200x800x24 +extension GLX +render -noreset -nolisten tcp &
cd /home/app
# show version infos
mvn --version
java --version
javac --version
# show OpenGL version
glxinfo | grep "OpenGL version"
# start application with mvn javafx:run command
mvn -f pom.xml javafx:run