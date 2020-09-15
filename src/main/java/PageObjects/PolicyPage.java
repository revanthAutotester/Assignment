package PageObjects;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Shared_Functions.Reusable_Functions;
public class PolicyPage extends Reusable_Functions{
	//WebDriver driver;
	public static Reusable_Functions RF;
	
//************************************
//*****	Page Objects Declarations *****
//*************************************
	
	//****Quote Page ***
	
		//Poncho Header text
		@FindBy(xpath="//*[text()='Hi, we’re Poncho']")    
		WebElement Ponch_Home_Page;
		
		//Firstname input field
		@FindBy(id="policyStartFirstName")    
		WebElement Policy_FirstName;
		
		//LastName input field
		@FindBy(id="policyStartLastName")    
		WebElement Policy_LastName;    
	    
		//POlicyStartDate input field
		@FindBy(id="policyStartDate")    
		WebElement POlicy_StartDate;
			
		//Sign-In button	
		@FindBy(xpath="//*[text()='Get a quote']")    
		WebElement Get_a_Quote_btn;
	 
	//
	//************************************
	//*****	Page Factory Initialization *****
	//*************************************
	    public PolicyPage(WebDriver driver){

	        Reusable_Functions.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	        System.out.println("Completed PolicyPage Initialisation");
	        

	    }
	    
	    
	  //************************************
	  //***** Methods Declaration *****
	  //*************************************
	
	    public void PersonDetails() throws IOException
	    {
	    	FirstName=GetFileValue("FirstName");
			LastName=GetFileValue("LastName");
	    	System.out.println("Reached Quote Page ");
	    	Webdriver_Wait(Ponch_Home_Page);    	
	    	Policy_FirstName.sendKeys(FirstName);	    	
	    	Webdriver_Wait(Policy_LastName);
	    	Policy_LastName.sendKeys(LastName);
	    	//SignIn_btn.click();
	    	Webdriver_Wait(Get_a_Quote_btn);
	      	RF.getScreenshot(ResultFolderpath+"\\PolicyPage.png");
	    	Test.log(LogStatus.PASS,"Policy Details Page:"+Test.addScreenCapture(ResultFolderpath+"\\PolicyPage.png"));
	    	Get_a_Quote_btn.click();	  
	    	System.out.print("Login Successful");
	    	
	    }
	
}
