# CICD Demo Project

## Description

I built this project to demonstrate the basics principles of CICD pipeline development. I've used Github Actions, (self-hosted) Runners, Browserstack integrationb, Junit unit test cases, Playwright browser test cases and the creation of a Docker image.

### Environment
- Local env Windows 10
- 3x self-hosted runners: 2x openSUSE Leap 15.5, 1x Windows 10
- Browserstack trial account
- IDE Intellij 2024.1 CE, SDK 19
- OpenJDK 19 "temurin" on runners
- Personal Github account
- Playwright 1.42
- Junit5
- DockerDesktop 4.29

 
### CICD Release Strategy

1. After a Push or Pull Request into master, CICD_Main_Pipeline.yml is executed
2. CICD_Main_Pipeline.yml performs the following 4 steps:
   - Setup: JDK 19 (OpenJDK 'temurin' distribution) is deployed to the runner (self-hosted)
   - Build: Maven builds the project into a JAR, run the tests (in main/test/java) 
   - Docker: Docker creates a new Docker image from the project Dockerfile, copies and executes the mainClass from project Jar (no test execution)
   - Pipeline yml to executes with the following test data combos:
   
      DevVer with profile for self-hosted runner: linux + chrome
      DevInt with profile for self-hosted runner: linux + chrome + firefox
      SIT    with profile for Browserstack: Windows10 + chrome

### Backlog

0. Support for test executions on multiple browser and platforms, using in-built browser support (FF & Chr)), others incl Browserstack

Done. using matrix syntax in workflow yml. Safari is supported if self-hosted host has Safari installed. No Safari support on Linux.
Multiple profiles in pom.xml can be used to refine which test cases are executed.

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

Note: Building and testing on a runner is different from building and running on a dedicated Cloud environment. In a microservices architecture, is this the right convoluted approach? 
- Build jar and test jar on a runner (mvn package -no test)  
- Deploy jar to target environment with some environment var set.
- Run test classes from the runner
- Rebuild test jar on a runner and point test classes at target environment

Done: Cloud environments can be setup as runners and use maven to build the app and its dependencies.

2. Explore the use of the free runners provided by GitHub, e.g. linux-latest, windows-latest etc.

   Findings: Easy enough with "linux-latest" and/or "windows-latest" but no control with personal GitHub account over spec of these build servers. Nor their availability:
   Have found that workflow jobs can be queued and will not execute immediately.

3. Explore how link different workflow files to promote change through a series of test environment to production, e.g.:

   Dev -> DevVer -> DevInt -> SIT/UAT -> Production

   This can be managed through tasks in a workflow file

4. Deploy to Docker images built on different operating systems

   The default Docker builder is linux-based. I have not yet found out how to build a Docker image based on Windows. 

5. https://github.com/Moonbeam69/CICDDemo/issues/9

6. Explore GitHub MarketPlace for more interesting actions
