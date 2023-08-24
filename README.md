# Technology Stack:
Java, Maven, Git, Cucumber BDD, Selenium, Serenity, IntelliJ IDEA

# Usage:
Framework will be used to perform regression as well as functional testing.

# Product:
E-commerce website.

# Automation flow:
The validation files were written in BDD methodology (with Cucumber framework and Serenity for reports) 
to better understand the requirement and purpose of testing.
Test use xpath mapping to select, display and use functions in testing page based on Selenium documentations.
Page Object Model pattern used.

# Test Execution:
To execute all feature files, need to run terminal and then run maven command:
```bash
mvn clean verify -Dbrowser=chrome
```
(browser which you want to use: chrome, edge or firefox)
in the root of the project.

# Test Results:
Test result are displayed in html file build based on Serenity library.
After execute features file, report will be generated under this path: "target/site/serenity/index.html"

# Requirements:
JDK 17