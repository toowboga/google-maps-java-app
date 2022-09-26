# google-maps-java-app
Java Desktop Application with Swing GUI showing Google Maps using a JavaFX WebView component

## Getting Started

You can use Java to build the sources, create a Docker image from the `Dockerfile` or use the `run-script.sh` if you want to use an image from dockerhub.

### The Java way

To build and run the app using Java follow the instructions below:

1. Make sure you have installed JDK 17 on your machine.
2. Clone this repository:
`git clone https://github.com/toowboga/google-maps-java-app.git`
3. Open the Maven project in your favourite IDE.
4. Compile with Maven and run `SwingGUI.main()`.

### The Docker way

To create a Docker image and run the app in a Docker container follow the instructions below:

1. Make sure you have installed Docker on your machine as well as X Window System (X11) for the GUI connection between host and container. 
2. Clone this repository:
`git clone https://github.com/toowboga/google-maps-java-app.git`
3. Open a terminal and move to the project directory.
4. Build a docker image using the command `docker build -f Dockerfile -t google-maps-app:latest . `. The name is up to you, but make sure you use it in the next step.
5. Start the container using the command `docker run -it -v /tmp/.X11-unix:/tmp/.X11-unix:rw -e DISPLAY=host.docker.internal:0 google-maps-app:latest`. The maven build is executed in the container and the app runs until the container is stopped. 

### Execute the run script

The easiest way is to execute the `run-script.sh`. 

1. Make sure you have installed Docker and X11 on your machine.
2. Clone this repository:
`git clone https://github.com/toowboga/google-maps-java-app.git`
3. Open a terminal and execute the script `run-script.sh`

Note: The script downloads an image from dockerhub and starts the docker container and is NOT using the sources in this repository!