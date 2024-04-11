# Use an official Java runtime as a parent image
FROM openjdk:19

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

RUN dir

# run the application
run java -jar app/HelloWorld-v1.0.jar