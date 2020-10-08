package Register;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import org.testng.Assert;
import org.testng.annotations.*;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

import com.relevantcodes.extentreports.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import PageObjects.*;
import Shared_Functions.Reusable_Functions;
//

public class Create_Account extends Reusable_Functions{   

	
	CreateAccountPage quotepage=new CreateAccountPage(driver);	   
	RegisterPage PP=new RegisterPage(driver);

	   @BeforeTest
	    public void setup() throws IOException
	   {
		   
			System.out.print("Creating HTML Results File");
			ResultFilepath=CreateHTMLFile("CBAAutomationResults");
			System.out.print("ResultFilepath is :"+ResultFilepath);			
			//Create the browser instance and Launches the Application
			LaunchApp();
       }
		
	   @Test  
	    public void Create_Account() throws IOException
	   {

	        //Create Login Page object
			Test=extent.startTest("RegisterCommBiz");		
			quotepage = new CreateAccountPage(driver);
			PP=new RegisterPage(driver);
		    try {
		    	Test.log(LogStatus.PASS,"RegisterCommBiz Started");
		    	PP.Register_Account();	    
			    extent.endTest(Test);
				extent.flush();	
				
				Test=extent.startTest("Enter_Account_Details");
				quotepage.Enter_Account_Details();;
				extent.endTest(Test);
				extent.flush();				
			   
		    }catch(Exception e) {    	
		    	System.out.print("Error Occured:"+e.getMessage());
		    	Reusable_Functions.getScreenshot(ResultFolderpath+"\\REgister_Error.png");
				Test.log(LogStatus.FAIL,"Error on Create Register Page"+e.getMessage()+""+Test.addScreenCapture(ResultFolderpath+"\\Account_Error.png"));
		    }
		    

	    }
	   
	   @AfterTest
	   public void Teardown() throws Exception
	   {
	   extent.endTest(Test);
		   extent.flush();
		   if(driver!=null)
			   driver.quit();
	   }

	}