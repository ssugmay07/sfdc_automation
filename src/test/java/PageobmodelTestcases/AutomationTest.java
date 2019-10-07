package PageobmodelTestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pageobmodelpagesnew.TestBase;
import junit.framework.Assert;
import pageobmodelPages.ForgotPwdPage;
import pageobmodelPages.HomePage;
import pageobmodelPages.LoginPage;

public class AutomationTest extends TestBase {
	
	LoginPage login;
	HomePage homepage;
	ForgotPwdPage forgotpwd;
	
	
	public AutomationTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		login=new LoginPage();
		homepage=new HomePage();
		forgotpwd=new ForgotPwdPage();
	}
	
	
	/*public void loginpageTitleTest()
	{
		String Title=login.validateLoginPageTitle();
		Assert.assertEquals(Title, "Login");
	}*/
	
	@Test(priority=1)
	public void SalesforceLogoImgTest()
	{
		boolean flag=login.validateSalesforceImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void ValidLoginTest()
	{
		createTestScriptReport("ValidLoginTest");
		homepage=login.verifyvalidLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyLoginErrormsg()
	{
		createTestScriptReport("verifyLoginErrormsg");
		login.LoginErrorMessage(prop.getProperty("username"), " ");
	}
	
	@Test
	public void CheckRememberme()
	{
		createTestScriptReport("CheckRememberme");
        homepage=login.CheckRememberMe(prop.getProperty("username"), prop.getProperty("password"));
        
	}
	
	@Test
	public void TestForgotpwdlink()
	{
		createTestScriptReport("TestForgotpwdlink");
		forgotpwd=login.verifyForgotPwdlink();
	}
	
	public void validatecancelbutton()
	{
		createTestScriptReport("validatecancelbutton");
		forgotpwd.TestForgotPwdcancel(prop.getProperty("username"));
	}
	
	
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		report.endTest(Logger);
		report.flush();
	}

}
