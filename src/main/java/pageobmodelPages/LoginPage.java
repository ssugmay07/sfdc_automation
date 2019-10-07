package pageobmodelPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pageobmodelpagesnew.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory
	@FindBy(id="username") WebElement UserName;
	
	@FindBy(xpath="//input[@id='password']") WebElement Password;
	
	@FindBy(xpath="//input[@id='Login']") WebElement LoginButton;
	
	@FindBy(id="rememberUn") WebElement RemembermeChkbox;
	
	@FindBy(xpath="//a[@id='forgot_password_link']") WebElement ForgotPwdLink;
	
	@FindBy(xpath="//img[@id='logo']") WebElement Logo;
	
	@FindBy(xpath="//div[@id='error']") WebElement ErrorMsg;
	
	//Initializing the Pageobjects
	public LoginPage()
	{
		
		PageFactory.initElements(driver, this);	
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		
		return driver.getTitle();
		
	}
	
	public boolean validateSalesforceImage()
	{
	return Logo.isDisplayed();
		
	}
		
	
	public HomePage verifyvalidLogin(String un,String pwd )
	{
		//UserName.sendKeys(un);
		//UserName;
		enterText(UserName,un,"username");
		
		enterText(Password,pwd,"password");
		
		clickbutton(LoginButton, "Login");
		//Password.sendKeys(pwd);
		
		//LoginButton.click();
		
		return new HomePage();
		
	}
	
	public void LoginErrorMessage(String un,String pwd)
	{
		/*UserName.sendKeys(un);
		Password.sendKeys(pwd);
		LoginButton.click();*/
		
		enterText(UserName,un,"username");
		enterText(Password,pwd,"password");
		clickbutton(LoginButton, "Login");
		validateTextMessage(ErrorMsg,"Please enter your password.","ErrorMessage");
		
	}
	
	
	public HomePage CheckRememberMe(String un,String pwd)
	{
		/*UserName.sendKeys(un);
		Password.sendKeys(pwd);
		RemembermeChkbox.click();
		LoginButton.click();*/
		
		enterText(UserName,un,"username");
		enterText(Password,pwd,"password");
		clickbutton(RemembermeChkbox, "Rememberme checkbox");
		clickbutton(LoginButton, "Login");
		
		return new HomePage();
	}
	
	
	public ForgotPwdPage verifyForgotPwdlink()
	{
		clickbutton(ForgotPwdLink, "forgot password link");
		
		return new ForgotPwdPage();
		
	}
	
	

}

