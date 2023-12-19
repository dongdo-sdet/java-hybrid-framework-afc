set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllureReport\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libSeleniumTestNG\*;%ProjectPath%libWebDriverManager\*;%ProjectPath%libLog4j2\*;%ProjectPath%libReportNG\*;%ProjectPath%libExtentReport\*;%ProjectPath%libAllureReport\*" org.testng.TestNG "%ProjectPath%bin\runNopCommerceTest.xml"
allure serve .\allure-results\
pause