package Pageobmodelpagesnew;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageobmodelutil.TestUtil;

public class TestBase {
	
	
	

	public static WebDriver driver;
	public static Properties prop;
	
	public static ExtentReports report;
	public static ExtentTest Logger;
	
	
	public TestBase()
	{
		
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\ssuga\\eclipse-workspace\\pageobmodel\\src\\main\\java\\PageobmodelConfig\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void initialization()
	{
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\firefox_gecodriver_v20.1\\geckodriver.exe");
			driver=new FirefoxDriver();
		} 
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,  TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		report=new ExtentReports("C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\Extent jars\\sample.html");
		String Path="C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\Extent jars\\sample.html";
		report=new ExtentReports(Path);
		
	}
	
	public static void createTestScriptReport(String TestScriptName) {
		if(report!=null)
			System.out.print("test");
		Logger = report.startTest(TestScriptName);
		
	}

	public static void enterText(WebElement obj,String text,String objName) {

		if(obj.isEnabled())
		{ 
			obj.sendKeys(text);
			System.out.println("pass:" +text +" is entered in "   +objName +" field " );
			Logger.log(LogStatus.PASS,"pass:" +text +" is entered in "   +objName +" field " );
		}
		else
		{
			System.out.println("Fail:" +objName +" field is not enabled ,please check the application" );
			Logger.log(LogStatus.FAIL, text +" is entered in "   +objName +" field " );
		}
	}
	
	
	public static void validateTextMessage(WebElement obj,String ExpectedMessage,String objName)
	{
		String ActualMessage=obj.getText();
		if(obj.isDisplayed())
		{
			if(ActualMessage.contentEquals(ExpectedMessage))
				
			{
				
				System.out.println("Pass  :" + "Dispalyed" +objName + "is exact" );
				Logger.log(LogStatus.PASS,"pass:" + "Dispalyed" +objName + "is exact" );
				
			}
			
			else {
				
				System.out.println("Fail :" + "Dispalyed" +objName + "is inappropriate" );
				Logger.log(LogStatus.FAIL,"Fail:" + "Dispalyed" +objName + "is inappropriate" );
			}
		}
	}
	
	public static void clickbutton(WebElement obj,String objName)
	{
		if(obj.isEnabled())
		{
			obj.click();
			System.out.println("pass :" +objName +" is clicked ");
			Logger.log(LogStatus.PASS,objName +" is clicked ");
		}

		else
		{
			System.out.println("fail :" +objName +" is not clicked ");
			Logger.log(LogStatus.FAIL, objName +" is not clicked ");
		}
	}
	
	
	
	public static void SelectCheckbox(WebElement obj,String objName)
	{

		if (obj.isEnabled())
		{

			obj.click();

			System.out.println("Pass " + objName + "is selected");
			Logger.log(LogStatus.PASS,objName +" is selected ");
		} 

		else {

			System.out.println("fail :" +objName +" is not selected ");
			Logger.log(LogStatus.FAIL, objName +" is not selected ");
			
		}
	}
	
	
	public static void MouseHover(WebElement obj,String objName) {

		if(obj.isEnabled())
		{
			Actions actions = new Actions(driver);

			actions.moveToElement(obj).build().perform();
			obj.click();

			System.out.println("Pass : " +objName + "  is clicked ");
			Logger.log(LogStatus.PASS,objName +" is clicked ");

		}
		else
		{

			System.out.println("Fail : " +objName + "  is not clicked ");
			Logger.log(LogStatus.FAIL,objName +" is not clicked ");

		}		
	}
	
	
}
