# Selenium Automation Testing Framework 

       This is a Maven framework developed to automate Selenium tests written in Java for web application https://www.saucedemo.com/.

## Prerequisites ##

   Inorder to run this test automation framework in your local machine, you need to:

Install Java - https://www.oracle.com/java/technologies/downloads/
Set java home path in system variables
Install Eclipse - https://www.eclipse.org/downloads/
Copy the repo into your local machine and import the project in Eclipse

# Run tests locally

Right click the project file in Eclipse and select "Run" to start the test.

# Run tests through the commandline

As this project uses Maven, we can invoke the tests using Maven goals.
To run the test, use your CI or point Maven to the project and use the goals.

mvn test -PprofileName -Dbrowser=browsername

Eg: mvn test -PRegression -Dbrowser=firefox

## Project explanation:

**Language**: In our Selenium Project we are using Java language. 

**Type of Framework**: In our project, we are using Data-driven Framework by using Page Object Model design pattern with Page Factory.

**POM**: As per the Page Object Model, we have maintained a class for every web page. Each web page has a separate class and that class holds the functionality and members of that web page. Separate classes for every individual test.

**Packages**: We have separate packages for Pages and Tests. All the web page related classes come under the Pages package and all the tests related classes come under Tests package.
For example, Login Page and ProductCatalogue Page have separate classes to store element locators. 

As per the above maven project, all the tests are kept in the ‘src/test/java‘ and remaining files (such as AbstractComponents, element locators (POM classes), properties file,ExtendReporterNG class) kept under ‘src/main/java‘.

**Test Base Class**: Test Base class (BaseTest.java) deals with all the common functions used by all the pages. This class is responsible for loading the configurations from properties files, Initializing the WebDriver, Extent Reports, Objectmapper class to read data from Json file and also to create the object of FileInputStream which is responsible for pointing towards the file from which the data should be read.

**AbstractComponent Class**: This class also deals with common functions used by all the pages. It includes explicit wait, method to close the browser at the end of all the test cases. 

**Screenshots**:  Screenshots will be captured and stored in a separate folder and also the screenshots of failed test cases will be added to the extent reports. 

**Properties file**: This file (GlobalData.properties) stores the browserName.

**Listener Class**:  Listeners class will monitor the test run and when a test fails, it will pass the method name of the failed test along with screenshot to the html report.

**TestNG**: Using TestNG for Assertions, Grouping, and Parallel execution.

**Maven**: Using Maven for build, execution, and dependency purpose. Integrating the TestNG dependency in the POM.xml file and running this POM.xml file using Jenkins.

**Version Control Tool**: We use Git as a repository to store our test scripts.

**Jenkins**: By using Jenkins CI (Continuous Integration) Tool, we execute test cases on a daily basis and also for nightly execution based on the schedule. Test Results will be sent to the peers using Jenkins.

**Extent Reports**: For the reporting purpose, we are using Extent Reports. It generates beautiful HTML reports. We use the extent reports for maintaining logs and also to include the screenshots of failed test cases in the Extent Report.

























