package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WaitUtility;

public class LoginPage 
{
	WaitUtility waitutility=new WaitUtility();
	public WebDriver driver;
	public LoginPage(WebDriver driver)//creating a parameterized constructor
	{
	this.driver=driver;	
	PageFactory.initElements(driver, this);//initializing elements using initElements that means invoke element here initializing driver
	}
@FindBy(name="username") WebElement username;
@FindBy(name="password") WebElement password;
@FindBy(xpath = "//button[text()='Sign In']") WebElement signin;

@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement text;

public LoginPage enterUsername(String usernamevalue)
{
	username.sendKeys(usernamevalue);
	return this;
}
public LoginPage enterPassword(String passwordvalue)
{
	password.sendKeys(passwordvalue);
	return this;
}
public HomePage clickSignInButton()
{
	waitutility.waitUntilElementToBeClickable(driver, signin);
	signin.click();
	return new HomePage(driver);
}
public Boolean verifyDashboardDisplayed()
{
	return dashboard.isDisplayed();
}
public String getTextofSuperMarket()
{
	return text.getText();
}
}
