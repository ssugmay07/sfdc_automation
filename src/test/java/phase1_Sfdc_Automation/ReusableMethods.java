package phase1_Sfdc_Automation;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ReusableMethods {
	
	
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest Logger;
	
	{
		report=new ExtentReports("C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\Extent jars\\sample.html");
		String Path="C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\Extent jars\\sample.html";
		report=new ExtentReports(Path);
	}
	
	public static ExtentTest createTestScriptReport(String TestScriptName) {
		//String Path="C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\Extent jars\\sample.html";
		//report=new ExtentReports(Path);
		Logger = report.startTest(TestScriptName);
		return Logger;
	}
	
	public static WebDriver callingWebdriver() throws InterruptedException {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		return driver;		
	}


	public static WebDriver enterLoginInfo(String username,String password1,String obj1name,String obj2name,String obj3name) throws InterruptedException {
		
		WebDriver driver = null;
		try {
			driver = callingWebdriver();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Enter UserName//
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
		//userName.sendKeys("ssuganya.nirmal-ap73@force.com");
		enterText(userName,username,obj1name);
		
		
		//Enter Password//
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password,password1,obj2name);
		//password.sendKeys("salesforcejune19");
		Thread.sleep(5000);
		
		//click loginbutton//
		WebElement LoginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		//LoginButton.click();
		
		clickbutton(LoginButton, obj3name);
		return driver;
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

	public static void DeSelectCheckbox(WebElement obj,String objName)
	{

		if (obj.isSelected())
		{
			obj.click();

			System.out.println("Pass " + objName + "is deselected");
			Logger.log(LogStatus.PASS,objName +" is selected ");

		} 

		else {

			System.out.println("Fail" + objName + "is not deselected");
			Logger.log(LogStatus.FAIL,objName +" is not selected ");
		}


	}
	
	public static void viewDropdownvalue(String xpath1,String xpath2,WebDriver driver)
	{


		WebElement Usermenu=driver.findElement(By.xpath(xpath1));
		Usermenu.click();
		WebElement MyProfile=driver.findElement(By.xpath(xpath2));
		MyProfile.click();
	}

	public static void VerifyDropdownvalues(WebElement obj,List<String> listname,String objName)
	{

		Select DrpDwnSel=new Select(obj);
		List<WebElement> DrpDwnList=DrpDwnSel.getOptions();
		//List<String> dropdownitems = Arrays.asList("All Opportunities", "Closing Next Month", "Won");

		List<String> dropdownitems =new ArrayList <String>();//to get the text of webelement dropdown and store//

		for(int i=0;i<DrpDwnList.size();i++){
			dropdownitems.add(DrpDwnList.get(i).getText());	//adding the values of webelement dropdown to dropdownitem list //
		}

		if(dropdownitems.containsAll(listname)) {

			System.out.println("pass :" +objName  + " values are present ");
			Logger.log(LogStatus.PASS,objName +" is selected ");
		}
		else
		{
			System.out.println("Fail :" +objName  + " values are not present ");
			Logger.log(LogStatus.FAIL,objName +" values are not present ");

		}
	}


	

	public static void MouseHover(WebElement obj,String objName) {

		WebDriver driver = null;
		try {
			driver = callingWebdriver();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(obj.isEnabled())
		{
			Actions AccountsTabaction = new Actions(driver);

			AccountsTabaction.moveToElement(obj).build().perform();
			obj.click();

			System.out.println("Pass : " +objName + "  is clicked ");
			Logger.log(LogStatus.PASS,objName +" is clicked ");

		}
		else
		{

			System.out.println("Fail : " +objName + "  is not clicked ");
			Logger.log(LogStatus.PASS,objName +" is selected ");

		}		
	}


	

	
	

}
