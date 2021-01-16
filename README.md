
# Pre-requisites to run this project

1. Java 1.8
2. Maven 3.6.0
3. Chrome browser 87
4. Eclipse or anyother Java IDE (Optional)

# Setup
Install the pre-requisites.

# Steps to run the project
1. Import the project as maven project
2. open src\test\java\com\testassessment\TestRunner.java
3. Change the Cucumber tag
3. Run the Test Runner class as Junit Test 

# Command to run the test from CLI
mvn clean test -Dcucumber.filter.tags="*Test tag*"

Eg: mvn clean test -Dcucumber.filter.tags="@GUI"



# Test Report
The framework will generate cucumber report in 3 formats.
1. Cucumber.json - Report will generated and saved in /target/cucumber-json folder
2. Cucumber-report.html - Report will generated and saved in /target folder
3. Cucumber.xml - Report will generated and saved in /target folder




