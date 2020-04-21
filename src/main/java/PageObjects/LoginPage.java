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


public class LoginPage extends Reusable_Functions{
	WebDriver driver;
	Reusable_Functions RF;
	
//************************************
//*****	Page Objects Declarations *****
//*************************************
	
	//****LOgin Page ***
	
	//SignIn text
	@FindBy(id="nav-link-accountList")    
	WebElement Sign_In_Link;
	
	@FindBy(id="ap_email")    
	WebElement Email_Textbox;
	
	@FindBy(id="continue")    
	WebElement Email_Continue_btn;    
    
	//Password
	@FindBy(id="ap_password")    
	WebElement Password_Textbox;
		
	//Sign-In button	
	@FindBy(id="signInSubmit")    
	WebElement SignIn_btn;
	
	
	// Welcome Page
	@FindBy(id="twotabsearchtextbox")    
	WebElement Search_Editbox;
	
	
    //FLy date page
    
    @FindBys(@FindBy(xpath="//button[text()='Confirm']"))
    
    List<WebElement> Fly_Date_Confirm;   
 
    
//************************************
//*****	Page Factory Initialization *****
//*************************************
    public LoginPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        System.out.println("Completed Init");
        

    }
    
    
  //************************************
  //***** Methods Declaration *****
  //*************************************
    
    public  void Login() throws IOException
    {
    	
    	System.out.println("Reached Login ");
    	Webdriver_Wait(Sign_In_Link);
    	Sign_In_Link.click();
    	Webdriver_Wait(Email_Textbox);
    	Email_Textbox.sendKeys(Username);
    	RF.getScreenshot(ResultFolderpath+"\\Username.png");
		Test.log(LogStatus.PASS," Username Page:"+Test.addScreenCapture(ResultFolderpath+"\\Username.png"));
    	Email_Continue_btn.click();
    	Webdriver_Wait(Password_Textbox);
    	Password_Textbox.sendKeys(Password);
    	SignIn_btn.click();
    	Webdriver_Wait(Search_Editbox);
    	RF.getScreenshot(ResultFolderpath+"\\Welcome.png");
		Test.log(LogStatus.PASS,"Welcome Page:"+Test.addScreenCapture(ResultFolderpath+"\\Welcome.png"));
    	System.out.print("Login Successful");
    }
    

    

}
