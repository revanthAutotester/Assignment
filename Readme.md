# Poncho Automation Test
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
<br> 9)	Once the execution is completed, please open Reports->PonchoAutomationResults folder  and choose the most recent created folder.</br>
<br> 10)	Open the html result file to view the results</br>

## 3) Project Framework Components Project: ##
<br>Project is built is based on the Page Object Model Framework. where all the object definitions are stored in separate class files named as "PageObjects"</br>
 
 <br> Framework consists of Following components</br>
 
<br>1) <b><ins>Driver script</ins></b>- Main script where script will trigger execution.(Car_Quote.java)</br>
<br>2) <b><ins>Reusable Functions</ins></b>: Contains all the reusable functions across the project.(Shared_Functions->Reusable_Functions.java)</br>
<br>3) <b><ins>Page Objects</ins></b>: Contains all the identified object definitions for each object captured from Application Under Test(AUT). ( PageObjects->PolicyPage.java , QuotePage.java)</br>
<br>4) <b><ins>Configuration File</ins></b>: Contains all the application details like URL,Browser, details ( Configuration.properties file)</br>
<br>5) <b><ins>Test Results</ins></b>: Html results files are generated once the test execution is completed ( library- ExtentReports)</br>


## 4) WebServices Automation : ##

 <br> Webservices Automation is created using Postman</br>
 
 #### Steps ####
 
 <br> 1) Import the API Automation folder into Postman ( should import 2 requests)
 
 #### AC1- Get Current Weather data using latitude and Longitude Steps #### 
 <br> 1) Click on  Poncho_Get_Weather_Data_Latitude_Longitude request
 <br> 2) Click on "Ëllipses" (3) symbol->Edit which opens the Edit collection modal
 <br> 3) On Edit Collection screen, Variables displays the baseurl,APIkey,Latitude,Longitude components
 <br> 4) Now, For executing, Click on Runner on Postman window which opens the Collection Runner window
 <br> 5) Select the above request and click on "Data"->Select File and import "Weather_Data.csv" file
 <br> 6) Now, click on "Start Run" </br>
 <br> 7) Once the results are executed, view in postman console the values captured
 <br> 8) Each API request excutes a test where it compares the Latitude,Longitude values from response are equal to the input values
 
 #### AC2- PostCode Steps ####
  <br> 1) Click on  Get Current Weather data based on Postcode request
 <br> 2) Click on "Ëllipses" (3) symbol->Edit which opens the Edit collection modal
 <br> 3) On Edit Collection screen, Variables displays the baseurl,APIkey,PostCode components
 <br> 4) Now, For executing, Click on Runner on Postman window which opens the Collection Runner window
 <br> 5) Select the above request and click on "Data"->Select File and import "Weather_Data_Postcode.csv" file
 <br> 6) Now, click on "Start Run" </br>
 <br> 7) Once the results are executed, view in postman console the values captured
  

## 5) Comments from Tester for Written response questions: ##

<br> 1) It took close to 5 hours from setting up the framework and installations</br>
<br> 2) Automation Project is coded in Java programming with Selenium while WebServices Automation is coded in Postman Collection Runner</br>
<br> 3) Automation Project: Currently I have implemented testdata in the notepad file. If we need to scale for multiple testdata values, we have to use excel for easy alignment of 
        field values, external libraries like Apache POI which makes selenium to read and write from excel data in faster way.</br>
       
