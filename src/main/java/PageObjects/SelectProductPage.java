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
public class SelectProductPage extends Reusable_Functions{
	//WebDriver driver;
	public static Reusable_Functions RF;
	
//************************************
//*****	Page Objects Declarations *****
//*************************************
	
	//****LOgin Page ***
	
	//SignIn text
	@FindBy(id="twotabsearchtextbox")    
	WebElement Search_Editbox;
	
	//SearchDropDown
	@FindBy(id="searchDropdownBox")    
	WebElement Search_Dropdown;	
	
	//Search_Icon
	
	@FindBy(xpath="//*[@value='Go']")    
	WebElement Search_icon;
	
	
	//Select the 60-69 checkbox
	@FindBy(xpath="//span[text()='50-59 in']")    
	WebElement Filter_55_chckbox;
	
	
	//Product results number
	@FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")    
	WebElement Results_count;
	//
	
	//Product-Description
	@FindBy(xpath="//div[@class='a-section a-spacing-medium']")    
	List<WebElement> Products;
	
	// Product page
	
	@FindBy(id="productTitle")    
	WebElement Product_Title;	
	
	
	//Price
	@FindBy(id="priceblock_ourprice")    
	WebElement Product_price;	
	
	@FindBy(xpath="//span[@id='price_inside_buybox']")    
	WebElement Product_price_insidebuybox;	
	
	
	//Add to Cart
	@FindBy(xpath="//*[@value='Add to Cart']")    
	WebElement Add_to_Cart_btn;	
	
	//Proceed to Checout Page
	
	// Cart Price
	@FindBy(xpath="//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")    
	List<WebElement> Proceed_To_Cart_Price;	
	
	//Proceed to cart button
	@FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")    
	List<WebElement> Proceed_To_Cart_button;	
	//
	
	//Standard_Delivery-Continue button
	@FindBy(xpath="//input[@value='Continue']")    
	List<WebElement> Standard_Delivery_Continue_btn;
	//
		
	//Email_Continue
	 @FindBy(xpath="//a[contains(text(),'Deliver to this address')]")    
	 WebElement Deliver_this_address_btn;
		//
	 @FindBy(xpath="*[text()='Select a payment method']")    
	 WebElement Select_Payment_Page;
	 
	//
	//************************************
	//*****	Page Factory Initialization *****
	//*************************************
	    public SelectProductPage(WebDriver driver){

	        Reusable_Functions.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	        System.out.println("Completed SelectProductPage Initialisation");
	        

	    }
	    
	    
	  //************************************
	  //***** Methods Declaration *****
	  //*************************************
	
	    public void SearchProduct() throws IOException
	    {
	    	  System.out.println("Reached SelectProductPage");
	    	//Wait until the Search Editbox is displayed
	    	Webdriver_Wait(Search_Editbox);
	    	
	    	//Select 'Ëlctronics' from search dropdown
	    	
	    	Select_Dropdown(Search_Dropdown,"Electronics");
	    	String Search_Text=GetFileValue("Search_Text");
	    	//Entering the Search text
	    	Search_Editbox.sendKeys(Search_Text);
	    	
	    	//Clicking on the Search icon
	    	Search_icon.click();
	    	
	    	Webdriver_Wait(Filter_55_chckbox);
	    	
	    	//Clicking on the 60-69 inch filter under TC screen size
	    	Click_Element(Filter_55_chckbox);
	    	
	    	Webdriver_Wait(Products.get(0));
	    	RF.getScreenshot(ResultFolderpath+"\\Products_results.png");
			Test.log(LogStatus.PASS,"Welcome Page:"+Test.addScreenCapture(ResultFolderpath+"\\Products_results.png"));
	    	System.out.println("displayed 55inch products");    	
	    	
	    }
	    
	    public void SelectProduct() throws IOException
	    {
	    	int count=0;
	    	String results_text=Results_count.getText();
	    	String[] string_text_array=results_text.split(" ");
	    	int results_text_count=Integer.parseInt(string_text_array[0]);
	    	System.out.println("results_text_count is "+results_text_count);
	    	//generate randome number
	    	 Random rand = new Random(); 
	         int random_prod_no = rand.nextInt(results_text_count+1);
	         if(random_prod_no==0)
	         {
	        	 random_prod_no=random_prod_no+2;
	         }
	         System.out.println("random_prod_no is "+random_prod_no);
	         
//	    	for(WebElement element: Products)
//	    	{	    	
	    		Prod_desc=Products.get(random_prod_no-1).findElement(By.xpath("div[2]")).getText();
	    		
	    			count=count+1;
	    			
		    			System.out.println("Selected Product is "+Prod_desc);
		    			Prod_price=Products.get(random_prod_no-1).findElement(By.xpath("div[4]")).getText();
		    			System.out.println("Selected Product is "+Prod_price);
		    			Click_Element(Products.get(random_prod_no-1));	    			
		    			Webdriver_Wait(Product_Title);
		    			RF.getScreenshot(ResultFolderpath+"\\Selected_Products_Page.png");
		    			Test.log(LogStatus.PASS,"Selected_Products_Page Page:"+Test.addScreenCapture(ResultFolderpath+"\\Selected_Products_Page.png"));
	    		
	    	//}
	    }
	    
	    public void Product_Price_Comparisions() throws IOException, InterruptedException
	    {
	    	Webdriver_Wait(Product_Title);
	    	
	    	//Comparing the product description with product title page
	    	String prod_title=Product_Title.getText();
	    	
	    	Assert.assertEquals(Prod_desc, prod_title);
	    	Test.log(LogStatus.PASS,"Prod_desc value:"+Prod_desc + "  Matching with Product Title page:"+prod_title);
	    	//Adding'.'to price
	    	 String temp=Prod_price.substring(Prod_price.length()-2,Prod_price.length());
	         System.out.println("temp :"+temp);
	         Prod_price=Prod_price.substring(0,Prod_price.length()-2);
	         Prod_price=Prod_price+"."+temp;
	         Prod_price = Prod_price.replaceAll("\\s","");
	    	System.out.println("Prod_price Product is "+Prod_price);		
	    			
	    	//Comparing the product price	     	
	    	
	    	String prod_price=Product_price.getText();
	    	Assert.assertEquals(Prod_price, prod_price);
	    	Test.log(LogStatus.PASS,"Prod_price value:"+Prod_price + "  Matching with Product Price page:"+prod_price);
	    	
	    	//Comparing Price in Buybox	    	
	    	String prod_price_buybox=Product_price_insidebuybox.getText();
	    	Assert.assertEquals(Prod_price, prod_price_buybox);
	    	Test.log(LogStatus.PASS,"Prod_price value:"+Prod_price + "  Matching with prod_price_buyboxe page:"+prod_price_buybox);
	    	
	    	//Clickng on Add_To_Cart button
	    	Click_Element(Add_to_Cart_btn);  	
	    	
	    	//Webdriver_Wait(Email);
	    	Webdriver_Wait(Proceed_To_Cart_Price.get(0));
	    	
	    	// Proceed to Cart page
	    	
	    	for(WebElement Cart_price:Proceed_To_Cart_Price)
	    	{
	    		Scroll_To_Element(Cart_price);
	    		Assert.assertEquals(Cart_price.getText(), Prod_price);
	    		RF.getScreenshot(ResultFolderpath+"\\Proceed_Cart_Page.png");
	    		Test.log(LogStatus.PASS,"Prod_price value:"+Prod_price + "  Matching with Proceed to Cart_price page:"+prod_price_buybox+Test.addScreenCapture(ResultFolderpath+"\\Proceed_Cart_Page.png"));
	    	}
	    	
	    	//Clicking on Cart button
	    	Click_Element(Proceed_To_Cart_button.get(0));
	    	Webdriver_Wait(Deliver_this_address_btn);
	    	
	    }
	    
	    public void Purchase_Product() throws IOException
	    {
	    	Webdriver_Wait(Deliver_this_address_btn);
	    	RF.getScreenshot(ResultFolderpath+"\\Delivery_Page.png");
			Test.log(LogStatus.PASS,"Delivery Page:"+Test.addScreenCapture(ResultFolderpath+"\\Delivery_Page.png"));
			
			//Clickng on Delivery to this address button
	    	Deliver_this_address_btn.click();	        	
	    	
	    	Webdriver_Wait(Standard_Delivery_Continue_btn.get(0));
	    	Click_Element(Standard_Delivery_Continue_btn.get(0));
	    	
	    	//Payment Page
	    	Webdriver_Wait(Select_Payment_Page);
	    	RF.getScreenshot(ResultFolderpath+"\\Select_Payment_Page.png");
			Test.log(LogStatus.PASS,"Select_Payment_Page Page:"+Test.addScreenCapture(ResultFolderpath+"\\Select_Payment_Page.png"));
	    }
	
}
