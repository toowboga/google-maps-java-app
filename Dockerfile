FROM maven:3.8.6-eclipse-temurin-17

# Required run-time libraries
ENV RUNTIME_PACKAGES libxext6 libxrender1 libxtst6 libxi6 libgl1 libgtk-3-0 libasound2 mesa-utils libgl1-mesa-glx xvfb

# Install libraries
RUN apt-get update && apt-get install -y $RUNTIME_PACKAGES \
    && rm -rf /var/lib/apt/lists/*

# Copy src folder to /home/app/src
COPY src /home/app/src

# Copy pom.xml to /home/app
COPY pom.xml /home/app

# Run maven to compile sources and start application
# RUN mvn -f /home/app/pom.xml javafx:run

COPY entrypoint.sh /home/entrypoint.sh

# Define container entrypoint starting java application
ENTRYPOINT ["/home/entrypoint.sh"]