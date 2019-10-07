package pageobmodelPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pageobmodelpagesnew.TestBase;

public class ForgotPwdPage extends TestBase {
	
	
	@FindBy(xpath="//input[@id='un']")WebElement username;
	
	@FindBy(xpath="//a[@class='secondary button fiftyfifty mb16']") WebElement CancelButton;
	
	@FindBy(xpath="//input[@id='continue']")WebElement ContinueButton;

	public ForgotPwdPage()
	{
		
		PageFactory.initElements(driver, this);	
	}
	
	public void TestForgotPwdcancel(String un)
	{
		enterText(username,un,"username");
		clickbutton(CancelButton,"cancel");
	}
	
	
	
	
	
}
