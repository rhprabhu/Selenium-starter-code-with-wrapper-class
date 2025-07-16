# Cucumber Selenium Java Starter Code

This repository contains base code for Selenium web-apps test automation framework with Page Object Model design using
Java + Cucumber + Maven + TestNG.
Framework follows many of the industry best practices and Automated web-driver management.

# Technologies/Tools used in building the framework

- IntelliJ - IDE
- Selenium - Web Automation library
- Maven - Build automation tool
- Java - Programming language
- Cucumber - BDD
- Gherkin - DSL
- TestNG - Unit testing framework
- GitHub - Version control

# Framework implements below best practices

- Code re-usability
- Code readability
- Scalable automation
- Uses explicit waits
- Uses tags to run certain set of test cases such as Smoke Test, Regression Test
- Parameterization using config.properties and testdata.properties
- Supports Chrome and Firefox browser
- Capture Screenshots on failure and attach to test report
- Load web driver automatically based on the current browser version
- Detailed test report using Cucumber-HTML-Reporter plugin
- Test report using Cucumber-JSON-Reporter plugin
- Run test-cases in headless mode

# Limitations

- It requires user involvement to describe scenarios right
- Requires maintenance of both steps and scenarios
- While API testing can be automated using Cucumber however, descriptive nature of Cucumber test cases is not suitable
  for API testing

# How to use:

- Download the repository to local directory (Do not clone)
- Extract the downloaded file
- Using IntelliJ IDE, Open the extracted repo directly (You can use any preferred IDE as well)
- Rename the imported repo to desired project name
- Update the ```groupId```, ```artifactId``` and ```version``` in ```pom.xml``` to appropriate values

```
    <groupId>org.example</groupId>
    <artifactId>CucumberJavaSeleniumStarterCode</artifactId>
    <version>1.0-SNAPSHOT</version>
```

- Install Cucumber plugin using the IDE marketplace
- Update the below property in ```pom.xml``` to match the JDK version present in your computer, or you can upgrade the
  installed JDK version to 19.

```
    <properties>
    <maven.compiler.source>19</maven.compiler.source>
    <maven.compiler.target>19</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
```

- Build the project and wait for all the dependencies to be downloaded and installed
- Add ```.feature``` files under ```src/test/resources/Features``` and write your test scenarios in the ```.feature```
  files
- Write steps definitions under ```src/test/java/StepsDefinitions```
- Write method definitions under ```src/main/java/Pages```
- To run the automation suite, run the file ```src/test/java/TestRunner/CucumberRunnerTests.java``` with appropriate
  tags
- To view Cucumber Test results open the file ```target/cucumberReports/report.html``` in any of the web browser

# Links

[Cucumber](https://cucumber.io/) |
[IntelliJ IDEA](https://www.jetbrains.com/idea/) |
[Maven Repository](https://mvnrepository.com/) |
[WebDriverManager](https://bonigarcia.dev/webdrivermanager/)