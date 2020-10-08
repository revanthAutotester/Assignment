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
public class RegisterPage extends Reusable_Functions{
	//WebDriver driver;
	public static Reusable_Functions RF;
	
//************************************
//*****	Page Objects Declarations *****
//*************************************
	
	//****Register Page ***
	
		//Register button
	
	@FindBy(id="txtUserName")    
	WebElement Username_Register;
	
	@FindBy(id="frmRegistration")    
	WebElement Register_Frame;
	
		@FindBy(xpath="//*[@id=\"form1\"]/div[1]/div[1]/div/a")    
		WebElement Register_button;
		
		//Radio button 
		@FindBy(id="rdoAdvanced")    
		WebElement Advanced_Control_Radio_btn;
		
		//Commbiz Markets input field
		@FindBy(id="chkMMFXSelected")    
		WebElement Commbizz_Markets_checkbox;    
	    
		//Letg_go button
		@FindBy(id="btnNext")    
		WebElement Lets_go_btn;
			
		//Next button	
		@FindBy(xpath="//*[@id='btnSubmit']")    
		WebElement Next_btn;
		
		
	 
	//
	//************************************
	//*****	Page Factory Initialization *****
	//*************************************
	    public RegisterPage(WebDriver driver){

	        Reusable_Functions.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	        System.out.println("Completed RegisterPage Initialisation");
	        

	    }
	    
	    
	  //************************************
	  //***** Methods Declaration *****
	  //*************************************
	
	    public void Register_Account() throws IOException
	    {
	   
	    	System.out.println("Reached Register_Account Page ");	    	
	    	Webdriver_Wait(Username_Register);  
	    	System.out.println("Reached Register_Account Page1 ");	
	    	Username_Register.sendKeys("test");
	    	//Javascript_Click(Register_button,driver);
	    	driver.switchTo().frame(Register_Frame);
	    	Register_button.click();
	    	//Click_Element(Register_button);
	    	Webdriver_Wait(Advanced_Control_Radio_btn);   
	    	Click_Element(Advanced_Control_Radio_btn);
	    	Click_Element(Commbizz_Markets_checkbox);
	    	RF.getScreenshot(ResultFolderpath+"\\Commbizz_Markets_checkbox.png");
	    	Test.log(LogStatus.PASS,"Commbizz_Markets  Page:"+Test.addScreenCapture(ResultFolderpath+"\\Commbizz_Markets_checkbox.png"));
	    	Click_Element(Lets_go_btn);
	    	Webdriver_Wait(Next_btn);   
	    	Click_Element(Next_btn);	    	
	      	RF.getScreenshot(ResultFolderpath+"\\RegisterPage.png");
	    	Test.log(LogStatus.PASS,"Register Page:"+Test.addScreenCapture(ResultFolderpath+"\\RegisterPage.png"));
	    	  
	    
	    	
	    }
	
}
