# CICD Demo Project
[![Build & Test in DevVer and SIT](https://github.com/Moonbeam69/CICDDemo/actions/workflows/CICD_Main_Pipeline.yml/badge.svg)](https://github.com/Moonbeam69/CICDDemo/actions/workflows/CICD_Main_Pipeline.yml)
## Description

I built this project to demonstrate the basics principles of CICD pipeline development. I've used Github Actions, (self-hosted) Runners, Browserstack integration, Junit unit test cases, Playwright browser test cases and the creation of a Docker image.

### Environment
- Local LAN comprising:
  - 3x self-hosted runners: 2x openSUSE Leap 15.5 (CLI & GNOME), 1x Windows 10 Pro
- IDE Intellij 2024.1 CE with Codiumate AI plugin 
- OpenJDK 19 "temurin" or "zulu" on self-hosted runners
- Github Free account
- Browserstack trial account (supports only Windows Chrome)
- Playwright 1.42
- Junit5
- DockerDesktop 4.29 

 
### CICD Release Strategy

1. After a Push or Pull Request into master, CICD_Main_Pipeline.yml is executed
2. CICD_Main_Pipeline.yml performs the following steps:
   - Setup: JDK 19 (OpenJDK temurin|zulu distribution) is deployed to the runner (self-hosted)
   - Build: Maven builds the project, runs tests, uploads test results to Github actions 
   - Tests are Junit tests with and without Playwright running on local or Browserstack browsers 
   - Docker: Docker creates a new Docker image from the project Dockerfile, copies and executes the mainClass from project Jar (no test execution)
   - My workflow yml uses various strategies to test on OS, browsers and platforms. OS and browsers are configured via the strategy syntax and platfoms via Maven profiles 

Note:

Caching is provided by actions/cache but, whilst useful, caches on the cloud. For project dependencies there is valid usecase to cache in the cloud. OpenJDK packages 
have proved very slow to sync onto a self-hosted runner and given the need to constantly update I have added the follow step to my workflow which checks 
for a local installation of (the correct version) of Java:

      - name: Check Java Version
        id: check-java
        run: |
          JAVA_VERSION=19
          if type -p java; then
            echo "Java found in PATH"
            _java=java
          elif [[ -n "$JAVA_HOME" ]] && [[ -x "$JAVA_HOME/bin/java" ]]; then
            echo "Java found in JAVA_HOME"
            _java="$JAVA_HOME/bin/java"
          else
            echo "Java not found"
            echo "java_installed=false" >> $GITHUB_ENV
            exit 1
          fi
          
          if [[ "$_java" ]]; then
            version=$("$_java" -version 2>&1 | awk -F[\"_] '{print $2}')
            echo "Java version: $version"
            if [[ "$version" == "$JAVA_VERSION"* ]]; then
              echo "Java version $JAVA_VERSION is already installed."
              echo "java_installed=true" >> $GITHUB_ENV
            else
              echo "Installed Java version does not match required version."
              echo "java_installed=false" >> $GITHUB_ENV
              exit 1
            fi
          fi

      - name: Set up cache
        if: env.java_installed != 'true'
        uses: actions/cache@v4.0.2
        with:
          key: ${{ runner.os }}-java-${{ hashFiles('**/build.gradle') }}
          restore-keys: |
            ${{ runner.os }}-java-

This script will run in bashrc but not Powershell. I need to investigate a switch.


### Backlog

These are items I would like to explorer further as they will make useful contributions to my understanding of DevOps CICD:

1. Create DORA metrics. Github Actions does not provide these out of the box (why not). Need to investigate what are freeware solutions to quickly expose these KPIs.

2. Explore GitHub MarketPlace for more useful actions

3. Integrate my docker images into Kubernetes

### Limitations

|   | Description                                          | Mitigation                                                        |
|---|------------------------------------------------------|-------------------------------------------------------------------|
| 1 | Cannot run Safari tests on Linux                     | Webkit is supported                                               |
| 2 | Browserstack eval license only supports Win/Chromium | Buy license                                                       |
| 3 | Matrix strategy auto-combines                        | Care must be taken that all target environments support the tests |
