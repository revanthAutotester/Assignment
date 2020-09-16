package Quote;

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

public class Car_Quote extends Reusable_Functions{   

	
	QuotePage quotepage=new QuotePage(driver);	   
	PolicyPage PP=new PolicyPage(driver);

	   @BeforeTest
	    public void setup() throws IOException
	   {
		   
			System.out.print("Creating HTML Results File");
			ResultFilepath=CreateHTMLFile("PonchoAutomationResults");
			System.out.print("ResultFilepath is :"+ResultFilepath);			
			//Create the browser instance and Launches the Application
			LaunchApp();
       }
		
	   @Test  
	    public void Poncho_CarQuote() throws IOException
	   {

	        //Create Login Page object
			Test=extent.startTest("PolicyHolderPage");		
			quotepage = new QuotePage(driver);
			PP=new PolicyPage(driver);
		    try {
		    	Test.log(LogStatus.PASS,"PolicyDetails Started");
		    	PP.PersonDetails();	    
			    extent.endTest(Test);
				extent.flush();	
				
				Test=extent.startTest("Car_Details");
				quotepage.Enter_Car_Details();
				extent.endTest(Test);
				extent.flush();				
			   
		    }catch(Exception e) {    	
		    	System.out.print("Error Occured:"+e.getMessage());
		    	Reusable_Functions.getScreenshot(ResultFolderpath+"\\Quote_Error.png");
				Test.log(LogStatus.FAIL,"Error on Create Quote Page"+e.getMessage()+""+Test.addScreenCapture(ResultFolderpath+"\\Quote_Error.png"));
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