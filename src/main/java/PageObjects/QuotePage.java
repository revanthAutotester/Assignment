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


public class QuotePage extends Reusable_Functions{
	WebDriver driver;
	Reusable_Functions RF;
	
//************************************
//*****	Page Objects Declarations *****
//*************************************
	
	// Car Details Page 
	
	@FindBy(xpath="//*[text()='Car #1']")    
	WebElement Car_header;
	
	@FindBy(xpath="//*[@id='vehicleLicensePlate-0']")    
	WebElement Car_Number;
	
	@FindBy(xpath="//*[@for='vehicleRegistrationState-default-0']")    
	WebElement Car_Reg_State_dropdown;
	
	
	@FindBy(xpath="//*[text()='NSW']")    
	WebElement State_value;
	
	@FindBy(xpath="//*[text()='Search']")    
	WebElement Search_btn;
	
	@FindBy(xpath="//*[text()='Yes, this is my car']")    
	WebElement ThisisMyCar_btn;
	
	
  // Parking Address
	@FindBy(xpath="//*[@placeholder='Search address']")    
	WebElement Car_Parking_Address_Search;
	
	@FindBy(xpath="//*[@class='icon']")    
	WebElement Car_Parking_Address_Search_icon;
	
	
	@FindBy(xpath="//*[text()='55 Pyrmont Bridge Road, Pyrmont, NSW 2009']")    
	WebElement Car_Parking_Search_Results1;
	
	@FindBy(xpath="//*[text()='Yes, this is my address']")    
	WebElement Car_Address_Confirm;	
	
	
	@FindBy(xpath="//*[@id='vehicleDriven-0']")    
	WebElement Car_Kilometers_Editbox;
	
	@FindBy(xpath="//*[@for='vehicleUsagePerWeek-0-0']")    
	WebElement Car_driven_per_week;
	
	@FindBy(xpath="//*[@for='vehicleKmsPerYear-default-0']")    
	WebElement Car_Travel_each_year;
	
	@FindBy(xpath="//*[@class='shared-InputSelect_dropdown-vehicleKmsPerYear']/li[2]")    
	WebElement Car_Travel_each_year_10000;
	
	
	@FindBy(xpath="//*[text()='Personal use only']")    
	WebElement Car_Personal_use_only;
	
	@FindBy(xpath="//*[@for='vehicleModifications-0-0']")    
	WebElement Car_Perf_modif_No;
	
	@FindBy(xpath="//*[@for='vehicleHasEquipment-0-0']")    
	WebElement Car_Fitted_parts_No;
	
	@FindBy(xpath="//*[@for='vehicleHasAccessories-0-0']")    
	WebElement Car_Accessories_No;
	
	
	@FindBy(xpath="//*[text()='No Damage']")    
	WebElement Car_unrepaired_No_Damage;
	
	@FindBy(xpath="//*[text()='No finance']")    
	WebElement Car_No_finance;
	
	
	//Vehicle value
	
	@FindBy(xpath="//*[@id='vehicleValue-0']")    
	WebElement Car_Vehicle_Final_value;
    
 
    
//************************************
//*****	Page Factory Initialization *****
//*************************************
    public QuotePage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
        System.out.println("Completed Init");
        

    }
    
    
  //************************************
  //***** Methods Declaration *****
  //*************************************
    
   
    
    public void Enter_Car_Details() throws InterruptedException 
    {
    	
		 String Car_Reg_No=GetFileValue("Car_Reg_No");
		 String Car_Reg_State=GetFileValue("Car_Reg_State");
		 String Car_Park_address=GetFileValue("Car_Park_address");
		 String Car_Kilometers=GetFileValue("Car_Kilometers");
		 String Car_driven=GetFileValue("Car_driven");
		 String Car_Usage=GetFileValue("Car_Usage");
		 String Car_Performance_Modif=GetFileValue("Car_Performance_Modif");
		 String Car_Accessories=GetFileValue("Car_Accessories");
		 String Car_Accessories_manufacture=GetFileValue("Car_Accessories_manufacture");
		 String Car_Unrepair_accident=GetFileValue("Car_Unrepair_accident");
		 String Car_Finance=GetFileValue("Car_Finance");
		 String Car_Vehicle1=GetFileValue("Vehicle_1");		
		
		 // Entering Car Registration number
		System.out.println("Reached Car Details Page ");
    	Webdriver_Wait(Car_header);
    	Car_Number.sendKeys(Car_Reg_No);
    	Webdriver_Wait(Car_Reg_State_dropdown);
    	 // Clicking State dropdown
    	Click_Element(Car_Reg_State_dropdown);
    	//Car_Reg_State_dropdown.click();
    	Webdriver_Wait(State_value);
    	 // Clicking NSW State 
    	Click_Element(State_value);
    	//State_value.click();
   	    // Clicking Search button
    	Click_Element(Search_btn);
    	//Search_btn.click();
    	Webdriver_Wait(ThisisMyCar_btn);
    	
   	    //Clicking THis is my Car button
    	Click_Element(ThisisMyCar_btn);
    	//ThisisMyCar_btn.click();
    	Webdriver_Wait(Car_Parking_Address_Search);
    	// Entering the Car Address details
    	Car_Parking_Address_Search.sendKeys(Car_Park_address);    	
    	Thread.sleep(5000);
    	Webdriver_Wait(Car_Parking_Search_Results1);
    	// Clicking the Search Results
    	Click_Element(Car_Parking_Search_Results1);
    	//Car_Parking_Search_Results1.click();    	
    	//Wait for the button
    	Webdriver_Wait(Car_Address_Confirm);
    	// Clicking the Car Address Results
    	Click_Element(Car_Address_Confirm);
    	//Car_Address_Confirm.click();    	
    	Webdriver_Wait(Car_Kilometers_Editbox);
    	// Entering Car Kilometers value
    	Car_Kilometers_Editbox.sendKeys(Car_Kilometers);
    	//Clicking the Car driven per week 
    	Click_Element(Car_driven_per_week);
    	//Car_driven_per_week.click();
    	//Clicking the Car Travel each year value
    	Click_Element(Car_Travel_each_year);
    	//Car_Travel_each_year.click();
    	Webdriver_Wait(Car_Travel_each_year_10000);
    	//Clicking the 10000km value
    	Click_Element(Car_Travel_each_year_10000);
    	//Car_Travel_each_year_10000.click();
    	//Clicking the Personal use only button
    	Click_Element(Car_Personal_use_only);
    	//Car_Personal_use_only.click();
    	//Clicking the Car Modifications No Value
    	Click_Element(Car_Perf_modif_No);
    	//Car_Perf_modif_No.click();
    	//Clicking the Car Fitted parts No Value
    	Click_Element(Car_Fitted_parts_No);
    	//Car_Fitted_parts_No.click();
    	//Clicking the Car Accessories parts No Value
    	Click_Element(Car_Accessories_No);
    	//Car_Accessories_No.click();
    	//Clicking the Car parts No Damage
    	Click_Element(Car_unrepaired_No_Damage);
    	//Car_unrepaired_No_Damage.click();
    	//Clicking the Car parts No Finance
    	Click_Element(Car_No_finance);
    //	Car_No_finance.click();
    	//Scrolling to the Final value
    	Scroll_To_Element(Car_Vehicle_Final_value);
    	// Get the value of the Vehicle value
    	String Car_Final_value=Get_Text(Car_Vehicle_Final_value,driver);
    	// Comparing the Vehicle values
    	Assert.assertEquals(Car_Vehicle1, Car_Final_value);
    	if(Car_Vehicle1.equalsIgnoreCase(Car_Final_value))
    	{
    		System.out.println("Cars Final value are matching "+Car_Final_value);
    		Test.log(LogStatus.PASS,"Vehicle value: "+ Car_Vehicle1+ " Matches" );
    	   	try {
				RF.getScreenshot(ResultFolderpath+"\\CarQuote.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Test.log(LogStatus.PASS,"Policy Details Page:"+Test.addScreenCapture(ResultFolderpath+"\\CarQuote.png"));
    	}
    	else
    	{
    		System.out.println("Cars Final value are not  matching "+Car_Final_value + ", "+ Car_Vehicle1);
    		Test.log(LogStatus.FAIL,"Cars Final value are not  matching "+ Car_Final_value + " , " + Car_Vehicle1);
    	   	try {
				RF.getScreenshot(ResultFolderpath+"\\CarQuoteError.png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Test.log(LogStatus.PASS,"Policy Details Page:"+Test.addScreenCapture(ResultFolderpath+"\\CarQuoteError.png"));
    	}
    }
    
    

}
