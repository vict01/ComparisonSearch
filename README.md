# Comparison Financial Search - Automated Testing
## This is the test automation framework based on Selenium-Webdriver, Junit and Maven to create tests easily for Comparison Financial Search.

In this framework we used different components resumed above, but below we will explain its functionality:
```
1. Selenium webdriver: Selenium is the framework used to automate the actions in the browser and locate elements.
   In this case, we use Chrome as browser and ChromeDriver as driver.
2. JUnit: Is the framework to create, organize and execute test.
3. Maven: Is the software applications that allows packaging and manage the dependencies.
4. Java: The programing language to build the test logic.
```

## Requirements:
- Selenium-Webdriver
- Junit
- Java 8
- Maven (latest version)
- Having installed chrome browser version 84
  - If you have other than version 84 you can download yours here: https://chromedriver.chromium.org/downloads
  - Then place it in ""..\\TestFramework\\src\\" replacing the existing version there.
##

## Test Scope:
#### Introduction:
* Within the module RegressionTests there are three java classes: HappyPathTesting, NegativeCaseTesting and TestSuiteRunning.
* Within HappyPathTesting class there are 2 tests or scenarios: doComparisonSearch and validateSearchResult.
* Within NegativeCaseTesting class there is one test o scenario: doComparisonSearchWithAmountInBlank.
* TestSuiteRunning class contains the set of both testing. That is, it allows us to run both previous classes together.

#### Test Explanation:
- doComparisonSearch: Run a happy path testing in which the customer do a comparison search entering all valid values.
- validateSearchResult: Run a happy path testing in which the customer validate if the search result corresponds to the input data.
- doComparisonSearchWithAmountInBlank: Run a negative test case in which the customer do a comparison search leaving in blank the amount field.
##

## How to use the test suite:
```
1. Go to RegressionTests module and run any of the Java class contained in it accordingly to the "run test" option/button
   in any "@Test()" section within any class if you're using IntelliJ IDE, or by right click the class and choose "Run as Junit" with Eclipse.
2. Pay attention while test runs in the browser.
3. Once test finish to run, in the panel and dashboard of Junit in the IDE, you can see the testing summary report.
```
