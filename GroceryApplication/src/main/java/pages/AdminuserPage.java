package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.PageUtility;

public class AdminuserPage {
	PageUtility pageutilty=new PageUtility();
	public WebDriver driver;

	public AdminuserPage(WebDriver driver)// creating a parameterized constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);// initializing elements using initElements that means invoke element
												// here initializing driver
	}

	@FindBy(xpath = "//a[@onclick=\"click_button(1)\"]")
	WebElement newbutton;

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement usertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
	WebElement saveadminusername;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement assertsavealert;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchaddeduser;
	@FindBy(id = "un")
	WebElement enternewlyaddedusername;
	@FindBy(id = "ut")
	WebElement searchusertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
	WebElement searchbutton;
	@FindBy(xpath = "//h4[text()='Search Admin Users']")
	WebElement asserttextofsearch;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement reset;
	@FindBy(xpath="//h4[text()='Admin Users']") WebElement assertreset;

	public AdminuserPage clickNewButton() {
		newbutton.click();
		return this;
	}

	public AdminuserPage enterAdminUsername(String adminpageusername) {
		username.sendKeys(adminpageusername);
		return this;
	}

	public AdminuserPage enterAdminPassword(String adminpagepassword) {
		password.sendKeys(adminpagepassword);
		return this;
	}
	

	public AdminuserPage selectUsertype() 
	{
		pageutilty.selectDropdownWithIndex(usertype, 1);
		return this;
	}

	public AdminuserPage clickSaveButton() {
		saveadminusername.click();
		return this;

	}

	public Boolean verifyAlertIsDisplayed() {
		return assertsavealert.isDisplayed();
	}

	public AdminuserPage searchButton() {
		searchaddeduser.click();
		return this;
	}
	

	public AdminuserPage newlyAddedUsername(String newlyaddedusername) {
		enternewlyaddedusername.sendKeys(newlyaddedusername);
		return this;
	}

	public AdminuserPage searchNewlyAddedUsertype() 
	{
		pageutilty.selectDropdownWithIndex(searchusertype, 1);
		return this;
	}

	public AdminuserPage clickSearchButton() {
		searchbutton.click();
		return this;

	}

	public Boolean verifyAdminUserSearchDisplayed() {
		return asserttextofsearch.isDisplayed();
	}

	public AdminuserPage resetButton() {
		reset.click();
		return this;
	}
	public Boolean verifyAdminUserResetClicked()
	{
		return assertreset.isDisplayed();
	}
}
