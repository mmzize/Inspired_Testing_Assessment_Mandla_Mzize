# Inspired_Testing_Assessment_Mandla_Mzize

Online Banking Tests

This project is developed using IntelliJIDEA with Java programming language.The basic functionality of the project is to
navigate to http://www.way2automation.com/angularjs-protractor/banking/#/login online banking and do Deposit,Withdrawal and 
confirm the transaction for the specific accounts.

To run the project there are more than one ways to do it

1. You can right click on the Online_Banking_Tests class and select "Run"
2. You can right click on the project name and select open terminal , once the terminal is opened you can use Maven
commands to run and specify which profile you want to run (see the pom.xml file for profile names)
3. You can run the project via TestNG file name WebTests.xml

This project was developed using a mix of existing technologies and frameworks
- I used extentreport4 to create the report that can be found under Banking Report folder , this folder will be created 
on the first run of the project and the report will be generated with the current date appended at the end of the report name

To open the report you need to right click the .html file and select Open in Browser and then you can select the browser of your choice.

I used TestNG to control the flow of the test and also so that I can use Maven pom.xml and specify the profiles that point to
specific tests that I need to run . This helps a lot when you want to hook your test to CI/CD pipelines like Jenkins.

I used Maven so that the project can auto-download all the dependencies needed when copied to a new machine
I used POM with PageFactory so that the project can only initialise the elements that are needed on runtime.

API Users Tests

This API project is develeped using IntelliJIDEA with Java programming language. It utilises RestAssured framework to
Access certain endpoints and perform actions that were in the requirement document.

except for addition on RestAssured it basically follow the same setup as the above Online Banking Test when it comes to 
frameworks and dependenies.

To Run the project you can right click and select Run from User_API_Tests class or you an open terminal and use maven commands 
and specify the correct profile that can be found on the pom.xml file
