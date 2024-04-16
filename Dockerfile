# Use an official Java runtime as a parent image
FROM openjdk:19

# Set the working directory in the container
#WORKDIR /app

# Copy the current directory contents into the container at /app
COPY "C:\Data\actions-runner - hello world\_work\HelloWorld\HelloWorld\target" /app



# run the application
CMD ["java","-jar","app/HelloWorld-v1.0-SNAPSHOT.jar"]