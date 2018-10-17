This is a simple solution which shows only one of the varieties possible approaches. Please, do not consider as a best practice. :)

Project has 5 main packages.

1)applogic: Contains Application class which is used for methods
and useful variables. Related to business logic.

2)tests: Contains test classes and TeasBase class for all.
TestBase used for keeping common test-run related methods and variables. SimpleTest class as a default test suite. MappedTest class to demonstrate java objects mapping usage.

3)model: Contains subject area models. For example City class for providing and comparison data in tests. Also data models
for JSON mappings. For exaple Summury class to map data from response.

4)dataproviders: Contains data provider class for paricular test

5)utils: Contains classes which help with environment selection.

This is a maven project, so it could be started with simple maven command: mvn test.(Please, be sure all necessary libraries are installed firstly with mvn install).

By default the only test class from testsuite.xml  will be run.
There is appKey which is used for requests. By default it's real. But also could be fake.

env.properties file in resurce folder contains endpoints and keys.

You can change key and endpoint (based on prperties file) using maven command.

That is how you can run MappedTest:

mvn clean -Dtest=MappedTest -Denv=mock -Dkey=fake_key test

I'm using allure-framework for reporting.

Before it's could be used you have to install allure comandline:

for Linux:
sudo apt-add-repository ppa:qameta/allure
sudo apt-get update 
sudo apt-get install allure

for Windows(must have scoop)
scoop install allure

For more details:
https://docs.qameta.io/allure/#_installing_a_commandline

report could be generated from default allure-results folder:
allure serve allure-results - Will start local server with generated report.
Or report could be generated from target/surefire-reports:
allure serve target/surefire-reports

Serve comand run local server, but there is a possibility to generate report in html format in separate folder 

allure generate allure-results -will create allure-report folder in the project directory with report in html format. 


     