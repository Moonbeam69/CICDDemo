# CICD Demo Project.

## Description

I built this project to experience the basics principles of CICD pipeline development. I've used Github Actions, (self-hosted) Runners, Junit test cases, Playwright test cases and Docker.

### Setup
Windows 10
Intellij 2024.1 CE, SDK 19
Personal Github account
DockerDesktop 4.29

### Basic steps

1. After a Push or Pull Request into master: BuildandPushDocker.yml is executed by GitHub Actions
2. BuildandPushDocker performs the following 3 steps:
   1. Setup: JDK 19 (temurin distribution) is deployed to the runner
   2. Build: Maven builds the project into a JAR 
   3. Docker: Docker creates a new (local) Docker image from the project Dockerfile, copies and executes the project Jar
   
### Things to invest time in

I still want to be able to do the following

1. Deploy the JAR into a test environment, will require the test cases to be packaged and deployed also. For the JAR
to becom deployable to higher test enviroments, it should not contain test classes. According to Maven
(https://maven.apache.org/plugins/maven-jar-plugin/examples/create-test-jar.html), that requires a seperate project which I 
will invest in later. 
2. Explore the use of the free runners provided by GitHub, e.g. ubuntu9 (?)
