# CICD Demo Project!

## Description

I built this project to experience the basics principles of CICD pipeline development. I've used Github Actions, (self-hosted) Runners, Junit test cases, Playwright test cases and Docker.

### Environment
- Windows 10
- Intellij 2024.1 CE, SDK 19
- Personal Github account
- DockerDesktop 4.29
 
### CDCD Approach

1. After a Push or Pull Request into master: BuildandPushDocker.yml is executed
2. BuildandPushDocker performs the following 3 steps:
   - Setup: JDK 19 (OpenJDK 'temurin' distribution) is deployed to the runner (self-hosted)
   - Build: Maven builds the project into a JAR, run the tests (in main/test/java) 
   - Docker: Docker creates a new (local) Docker image from the project Dockerfile, copies and executes the project Jar
   
### Things to invest time in

I still want to investigate the following:

0. Support for test executions on multiple browser and platforms, using in-built browser support (FF & CHr)), others incl Browserstack

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

Note: Building and testing on a runner is different from building and runninn on a dedicated Cloud environment. In a microservices architecture, is this the right convoluted approach 
- Build jar and test jar on a runner (mvn package -no test)  
- Deploy jar to target environment with some environment var set.
- Run test classes from the runner
- Rebuild test jar on a runner and point test classes at target environment

2. Explore the use of the free runners provided by GitHub, e.g. linux-latest, windows-latest etc.

   Findings: Easy enough with "linux-latest" and/or "windows-latest" but no control with personal GitHub account over spec of these build servers. Nor their availability:
   Have found that workflow jobs can be queued and will not execute immediately.

3. Explore how link different workflow files to promote change through a series of test environment to production, e.g.:

   Dev -> DevVer -> DevInt -> SIT/UAT -> Production

   This can be managed through tasks in a workflow file

4. Deploy to Docker images built on different operating systems

   The default Docker builder is linux-based. I have not yet found out how to build a Docker image based on Windows. 

6. Explore GitHub MarketPlace for more interesting actions