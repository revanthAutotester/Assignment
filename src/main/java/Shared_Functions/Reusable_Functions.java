package Shared_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Reusable_Functions {
	public static ExtentReports extent;
	public static ExtentTest Test; 
	public static String Datapath=System.getProperty("user.dir");
	public static WebDriver driver;
	public static String ResultFolderpath,RemoteNodeURL,RemoteBrowserPath,ResultFilepath,URL,Browser,FirstName,LastName,Prod_desc,Prod_price,Execution,RemoteBrowser;
	static Platform RemotePlatform;
	
	public static String GetDate(String Format)
	{
		System.out.println("Get Date Shared Function");		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Format);
		   LocalDateTime now = LocalDateTime.now();
		   System.out.println(dtf.format(now));
		   return dtf.format(now).toString();
	}
	public static void Webdriver_Wait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static String Get_Text(WebElement element,WebDriver driver)
	{
		Webdriver_Wait(element);
		return element.getText();	
		
	}
	public static void Click_Element(WebElement element)
	{
		try {
			Scroll_To_Element(element);
		}catch(Exception e) {}
		Webdriver_Wait(element);
		element.click();	
		
	}
	public static void Select_Dropdown(WebElement element,String value)
	{
		
		Select drpCountry = new Select(element);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		drpCountry.selectByVisibleText(value);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	}
	public static void Select_DropdownByindex(WebElement element,int value)
	{
		
		Select drpCountry = new Select(element);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		drpCountry.selectByIndex(value);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	}
	public static void SendKeys(WebElement element,WebDriver driver,String value)
	{
		Webdriver_Wait(element);
		element.sendKeys(value);
		
	}
	public static void Javascript_Click(WebElement element,WebDriver driver)
	{
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public static void Javascript_Scroll(WebElement element,WebDriver driver)
	{
		WebElement element1=element;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element1);
	}
	public static void Scroll_down(WebDriver driver) throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("javascript:window.scrollBy(250,350)");
	      Thread.sleep(1000);
	}
	
	public static void Scroll_To_Element(WebElement element) throws InterruptedException
	{
		//WebElement element = driver.findElement(By.id("my-id"));
		Webdriver_Wait(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(200);
	}
	public static String GetFileValue(String Fieldname)
	 {
		 String Fieldvalue = null;
		// System.out.println( "Reached GetFilevalues");
		 File file = new File(Datapath+"\\src\\main\\java\\Configuration.properties");
				 			FileInputStream fileInput = null;
				 			try {
				 				fileInput = new FileInputStream(file);
				 			} catch (FileNotFoundException e) {
				 				e.printStackTrace();
				 			}
				 			Properties prop = new Properties();
				 			try {
				 				prop.load(fileInput);
				 			} catch (IOException e) {
				 				e.printStackTrace();
				 			}
				 			Enumeration KeyValues = prop.keys();
				 			while (KeyValues.hasMoreElements()) {
				 				String key = (String) KeyValues.nextElement();
				 			//	System.out.println(key + " value ");
				 			
				 			    if(Fieldname.toLowerCase().equals(key.toLowerCase()))
				 			    {
				 					Fieldvalue = prop.getProperty(key);
				 					System.out.println(key + " matched value is:  " + Fieldvalue);
				 					//return Fieldvalue; 
				 			    }
				 			}
				 			
				return Fieldvalue; 			
	 }
	public static String CreateDirectory(String Filename)
	{
		Date now = new Date();
		String dateFormat =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());	
		String file = Datapath+"\\Reports\\"+Filename+"_"+dateFormat;
		File dir = new File(file);
		dir.mkdir();
		System.out.println("File Created at "+file);
		return file;
	}
	 public static String CreateHTMLFile(String fileName) throws IOException {
	      
		 ResultFolderpath=CreateDirectory(fileName);      
	      String resultFile = ResultFolderpath+"\\"+fileName +".html";
	      File file = new File(resultFile);
	      file.createNewFile();
	      // if file does exists, then delete and create a new file
	  		extent = new ExtentReports(resultFile, true);
	  		extent.loadConfig(new File(Datapath+"\\extent-config.xml"));
	      return resultFile;
	  }
	 public static void getbrowser(String browserdriver)
	 {
		 
		 if(browserdriver.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.chrome.driver",Datapath+"\\Drivers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		    }
		 else if(browserdriver.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver",Datapath+"\\Drivers\\chromedriver.exe");
		    	 driver = new ChromeDriver();
		    } 
		 else if(browserdriver.equalsIgnoreCase("ie")) {
			 System.setProperty("webdriver.chrome.driver",Datapath+"\\Drivers\\IEDriverServer.exe");
		    	driver = new InternetExplorerDriver();
		    } 		
	 } 
	 public static void getScreenshot(String outputlocation) throws IOException
	 {
		 System.out.println("Capturing the snapshot of the page ");
		 File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcFiler, new File(outputlocation));		
		
	}
	 
	 public static void LaunchApp() throws MalformedURLException
	 {
		 Execution=GetFileValue("Execution");
		 URL=GetFileValue("URL");		 
		 Browser=GetFileValue("Browser");
		 if(Execution.equalsIgnoreCase("Local"))
		 {
			 getbrowser(Browser);		
		     driver.navigate().to(URL);	        
		     driver.manage().window().maximize();
		 }
		 else
		 {
			 LaunchtheRemoteApp();
		 }
		 
	 }
	 
	 public static void LaunchtheRemoteApp() throws MalformedURLException
	 {
		 RemoteBrowser=GetFileValue("RemoteBrowser");
		 
		 if(RemoteBrowser.equalsIgnoreCase("chrome")) {
			 RemoteNodeURL=GetFileValue("RemoteNodeURL");
		     RemoteBrowserPath=GetFileValue("RemoteBrowserPath");
			 String nodeURL1 = RemoteNodeURL;
			 System.setProperty("webdriver.chrome.driver",RemoteBrowserPath);
			 DesiredCapabilities cap = DesiredCapabilities.chrome();
			 cap.setBrowserName(RemoteBrowser);
			 cap.setPlatform(RemotePlatform);
			 driver = new RemoteWebDriver(new java.net.URL(""+RemoteNodeURL), cap);
			 driver.navigate().to(URL);
			 driver.manage().window().maximize();
		 }
	 }
}
