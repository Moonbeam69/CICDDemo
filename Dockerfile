# Use an official Java runtime as a parent image
FROM openjdk:19

# Set the working directory in the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the application
RUN javac MyApp.java

# Run the application
CMD ["java", "MyApp"]
