package pageobmodelPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pageobmodelpagesnew.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[@id='userNavLabel']")WebElement UserLabel;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")WebElement Logout;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);	
	}

	public LoginPage verifyRememberMeChkBox()
	{
		clickbutton(UserLabel,"userlabelheader");
		
		clickbutton(Logout,"logout");
		
		return new LoginPage();
	}
	
}
