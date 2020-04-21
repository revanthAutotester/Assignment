package amazon;

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
public class AmazonPurchase extends Reusable_Functions{   

	  LoginPage loginpage=new LoginPage(driver);	   
	  SelectProductPage SPP=new SelectProductPage(driver);
	    

	   @BeforeTest
	    public void setup() throws IOException
	   {
		   
			System.out.print("Creating HTML Results File");
			ResultFilepath=CreateHTMLFile("AmazonTestResults");
			System.out.print("ResultFilepath is :"+ResultFilepath);
			
			//Create the browser instance and Launches the Application
			LauncApp();
       }

	   @Test  
	    public void Purchase() throws IOException
	   {

	        //Create Login Page object
			Test=extent.startTest("Login");			
		
			loginpage = new LoginPage(driver);
			SPP=new SelectProductPage(driver);
		    try {
		    	Test.log(LogStatus.PASS,"Login Started");
		    	loginpage.Login();	    
			    extent.endTest(Test);
				extent.flush();	
				
				Test=extent.startTest("SearchProduct");
				SPP.SearchProduct();
				extent.endTest(Test);
				extent.flush();
				
				Test=extent.startTest("SelectProduct");
				SPP.SelectProduct();
				extent.endTest(Test);
				extent.flush();
				
				Test=extent.startTest("Product_Price_Comparisions");
				SPP.Product_Price_Comparisions();
				extent.endTest(Test);
				extent.flush();
				
				Test=extent.startTest("Purchase_Product");
				SPP.Purchase_Product();
				extent.endTest(Test);
				extent.flush();
			
			   
		    }catch(Exception e) {    	
		    	System.out.print("Error Occured:"+e.getMessage());
		    	Reusable_Functions.getScreenshot(ResultFolderpath+"\\Products_results.png");
				Test.log(LogStatus.FAIL,"Error on Amazon Page"+e.getMessage()+""+Test.addScreenCapture(ResultFolderpath+"\\Products_results.png"));
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