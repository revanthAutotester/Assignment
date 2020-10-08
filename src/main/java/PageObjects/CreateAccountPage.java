package PageObjects;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import com.relevantcodes.extentreports.*;

import Shared_Functions.*;


public class CreateAccountPage extends Reusable_Functions{
	WebDriver driver;
	Reusable_Functions RF;
	
//************************************
//*****	Page Objects Declarations *****
//*************************************
	
	// User Creation Page 
	
	@FindBy(id="txtUserName")    
	WebElement Username;
	
	@FindBy(id="txtPassword")    
	WebElement Password;
	
	@FindBy(id="txtReenterPassword")    
	WebElement Reenter_Password;
	
	
	@FindBy(id="ddlSecret1")    
	WebElement Security_Question1;
	
	@FindBy(id="txtSecret1")    
	WebElement Security_Answer1;
	
	@FindBy(id="ddlSecret2")    
	WebElement Security_Question2;
	
	@FindBy(id="txtSecret2")    
	WebElement Security_Answer2;
	
	
	@FindBy(id="btnSubmit")    
	WebElement Create_Account_btn;
	
	@FindBy(id="txtCompanyName")    
	WebElement Business_Details_Name;
  
	
 
    
//************************************
//*****	Page Factory Initialization *****
//*************************************
    public CreateAccountPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        System.out.println("Completed Init");
        

    }
    
    
  //************************************
  //***** Methods Declaration *****
  //*************************************
    
   
    
    public void Enter_Account_Details() throws InterruptedException, IOException 
    {
     	FirstName=GetFileValue("FirstName");
		String password=GetFileValue("Password");
		String security_Answer1=GetFileValue("Security_Answer1");
		String security_Answer2=GetFileValue("Security_Answer2");
		 		
		
		 // Entering Car Registration number
		System.out.println("Reached Create Account Page ");
    	Webdriver_Wait(Username);
    	Username.sendKeys(FirstName);
    	Password.sendKeys(password);
    	Reenter_Password.sendKeys(password);
    	Select_DropdownByindex(Security_Question1,1);
    	Security_Answer1.sendKeys(security_Answer1);
    	Select_DropdownByindex(Security_Question2,2);
    	Security_Answer2.sendKeys(security_Answer2);
     	RF.getScreenshot(ResultFolderpath+"\\CreateAccountPage.png");
	    Test.log(LogStatus.PASS,"CreateAccount Details Page:"+Test.addScreenCapture(ResultFolderpath+"\\CreateAccountPage.png"));
    	Click_Element(Create_Account_btn);
    	
    	Webdriver_Wait(Business_Details_Name);

    }   
    

}
