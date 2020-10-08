# CBA Automation Test
## 1) Project Tech Stack: ##
<br>•	Eclipse IDE</br>
<br>•	TestNG Framework</br>
<br>•	HTML Reports – ExtentReports library</br>
<br>•	Coding language – Java</br>
<br>•	Project Build – Maven project</br>
<br>•	Executed Platform – Chrome Browser</br>


## 2) Setup Instructions: ##

<br> 1)	Install Eclipse IDE.</br>
<br> 2)	Once the Eclipse is installed, download the project from Github account into Local drive.</br>
<br> 3)	Import the Project from File->Import->Maven->Existing Maven Projects-> Next-> Browse the project Folder->Click Finish</br>
<br> 4)	Once the project is loaded, Click on Project->Build All. This will install all the packages corresponding to the pom.xml library associated.</br>
<br> 5)	Open the Configuration.properties file located in project Explorer as below</br>
<br> 6)	Once configuration is completed , Open the Car_Quote.java(src/main/java ->Quote)  file from the Package explorer </br>
<br> 7)	Right Click on the Car_Quote.java classfile and Select RunAs->TestNG Test option </br> 
<br> 8)	This will trigger the scripts to execute.</br>
<br> 9)	Once the execution is completed, please open Reports->CBAAutomationResults folder  and choose the most recent created folder.</br>
<br> 10)	Open the html result file to view the results</br>

## 3) Project Framework Components Project: ##
<br>Project is built is based on the Page Object Model Framework. where all the object definitions are stored in separate class files named as "PageObjects"</br>
 
 <br> Framework consists of Following components</br>
 
<br>1) <b><ins>Driver script</ins></b>- Main script where script will trigger execution.(Create_Account.java)</br>
<br>2) <b><ins>Reusable Functions</ins></b>: Contains all the reusable functions across the project.(Shared_Functions->Reusable_Functions.java)</br>
<br>3) <b><ins>Page Objects</ins></b>: Contains all the identified object definitions for each object captured from Application Under Test(AUT). ( PageObjects->CreateAccountPage.java , RegisterPage.java)</br>
<br>4) <b><ins>Configuration File</ins></b>: Contains all the application details like URL,Browser, details ( Configuration.properties file)</br>
<br>5) <b><ins>Test Results</ins></b>: Html results files are generated once the test execution is completed ( library- ExtentReports)</br>
 <b><ins>#Note</ins></b>: Please view "Test_Execution_video.avi" file attached into project for test execution
