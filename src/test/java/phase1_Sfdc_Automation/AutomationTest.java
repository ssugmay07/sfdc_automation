package phase1_Sfdc_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AutomationTest extends ReusableMethods{
	
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest Logger;
	
	//String Path="C:\\Users\\ssuga\\Documents\\tek Arch\\selenium\\Extent jars\\sample.html";

	public static void main(String[] args) throws InterruptedException {
		
		ReusableMethods re = new ReusableMethods();
		TC01_Login_ErrorMsg();
		TC02_LoginToSfdc();
		ReusableMethods.report.endTest(Logger);

	}
	
	
    @Test
	public static void TC01_Login_ErrorMsg() throws InterruptedException {

		createTestScriptReport("TC01_Login_ErrorMsg");
		enterLoginInfo("nirmalpratheep-v9d8@force.com","","username","password","login");
		//driver.close();


	}
    
    @Test
	public static void TC02_LoginToSfdc() throws InterruptedException {
		
		createTestScriptReport("TC02_LoginToSfdc");
		enterLoginInfo("nirmalpratheep-v9d8@force.com","suganya111987 ","username","password","login");
	}
    
    @Test
	public static void TC03_CheckRememberMe() throws InterruptedException {
		WebDriver driver = null;
		try {
			driver = callingWebdriver();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
		enterText(userName,"nirmalpratheep-v9d8@force.com","username");
		Thread.sleep(1000);


		//Enter Password//
		WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
		enterText(password,"suganya111987","password");
		Thread.sleep(1000);

		//Remember Me//
		WebElement RememberMe=driver.findElement(By.xpath("//input[@id='rememberUn']"));
		SelectCheckbox(RememberMe,"Remember Me checkbox");
		Thread.sleep(5000);

		//clicking Login button
		WebElement LoginButton=driver.findElement(By.xpath("//input[@id='Login']"));
		clickbutton(LoginButton,"login");

		Thread.sleep(5000);
		WebElement userLabel=driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		clickbutton(userLabel,"userlabelheader");


		WebElement LogoutButton=driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickbutton(LogoutButton,"logout");

	}
    @Test
    public static void TC04A_ForgotPwd() throws InterruptedException {

		WebDriver driver = null;
		try {
			driver = callingWebdriver();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Thread.sleep(5000);

		//Click on forgot password link//
		WebElement ForgotPassword=driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		clickbutton(ForgotPassword,"Forgot password link");

		WebElement userName=driver.findElement(By.xpath("//input[@id='un']"));
		enterText(userName,"nirmalpratheep-v9d8@force.com","username");
		Thread.sleep(5000);

		WebElement continueButton=driver.findElement(By.xpath("//input[@id='continue']"));
		clickbutton(continueButton,"continue");

	}
    @Test
	public static void TC04B_WrongLoginDetails() throws InterruptedException {

		WebDriver driver=enterLoginInfo("gdshh","12345","username","password","login");
	}


	
	
}
