# selenium-webdriver-java-cucumber-testng-assesment

Java-based test automation framework built on top of the most popular solutions Selenium WebDriver, TestNG, Cucumber and Maven.

Automation Scenarios:
1. Verify the Home Page for a User
2. User votes and comments. Then User verifies the comment
3. User only votes without commenting

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing
purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites:
1. Add "geckodriver.exe" path mentioned in /src/main/resources to 'PATH' system variable in 'Environment Variables'
2. Latest version of Chrome should be installed on the machine
3. Latest version of Firefox browser should be installed on the machine
4. Maven should be installed on the machine in order to run the tests via command prompt

Configuration

In the "src/test/resources/config" folder you will be able to find the config.properties file
where I have placed all the data such as login, password , browser , url and many more.

Running the tests
1. Via command prompt using maven -
   Go to the folder where you have stored the project and execute command
   Example -
    1. To run the entire feature test
       mvn test -- To run the entire test
    2. To run a specific scenario, add scenarios to feature file and then
       mvn test -Dcucumber.filter.tags="@smoke"
2. Via IDE run file - "testng.xml" -- To run the entire test

Built With frameworks & tools:
- Java
- Selenium WebDriver
- TestNG
- Cucumber (BDD) / Gherkin
- Maven

CI/CD Configuration:
In order to run in Jenkins you just have to upload the project. I have added headless mode option in "config.properties".
This option is one of the best options to run the tests in a jenkins pipeline.

Note:
I have just included 2 browsers in this tests.