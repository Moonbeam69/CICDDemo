# CICD Demo Project

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

I still want to investigate the following:

1. A JAR deployment for CICD will require the test cases to be packaged and deployed also. If the JAR itself is a managed item that can, in theory, 
be promoted to production, it should not contain any test classes. It is possible to build a jar with the SUT classes and a separate JAR with test classes:

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.3.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>test-jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

but to execute the test Jar on the target envirnment (e.g. Docker) will require separate dependency management. The answer is probably to to install 
Maven on the target environment and let pom.xml do the heavy lifting.

3. Explore the use of the free runners provided by GitHub, e.g. linux-latest, windows-latest etc.

4. Explore how link different workflow files to promote change through a series of test environment to production, e.g.:

   Dev -> DevVer -> DevInt -> SIT/UAT -> Production 

5. Deploy to Docker images built on different operating systems
