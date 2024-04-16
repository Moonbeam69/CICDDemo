# Use an official Java runtime as a parent image
FROM openjdk:19

# Set the working directory in the container
WORKDIR /app

RUN ls -la

# Copy the current directory contents into the container at /app
COPY target/HelloWorld-v1.0-SNAPSHOT.jar /app/

# run the application
CMD ["java","-jar","/app/HelloWorld-v1.0-SNAPSHOT.jar"]