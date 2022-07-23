#!/bin/bash

# allow access from localhost
xhost + 127.0.0.1

# run google-maps-java-app with X11 forwarding and keep running until it quits
docker run -it -v /tmp/.X11-unix:/tmp/.X11-unix:rw -e DISPLAY=host.docker.internal:0 --privileged --name google-maps-app google-maps-app:latest
