# Use an official Java runtime as a parent image
FROM openjdk:19

# Set the working directory in the container
WORKDIR /app

# run DIR command to confirm local directory
RUN DIR

# Copy the current directory contents into the container at /app
COPY "target/*.jar" /app

# run the application
CMD ["java","-jar","app/HelloWorld-v1.0-SNAPSHOT.jar"]