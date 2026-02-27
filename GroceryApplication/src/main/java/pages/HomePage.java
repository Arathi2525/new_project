package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
		public WebDriver driver;
		public HomePage(WebDriver driver)//creating a parameterized constructor
		{
		this.driver=driver;	
		PageFactory.initElements(driver, this);//initializing elements using initElements that means invoke element here initializing driver
		}
		
		@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement adminbutton;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class=\"dropdown-item\" ]") WebElement logoutbutton;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminusermoreinfo;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer'] ") WebElement managenewsmoreinfo;

		public HomePage clickAdmin()
		{
			adminbutton.click();
			return this;
		
		}
		public LoginPage clickLogout()
		{
			logoutbutton.click();
			return new LoginPage(driver);
		}
		public AdminuserPage clickAdminuserMoreinfo()
		{
			adminusermoreinfo.click();
			return new AdminuserPage(driver);
		}
		public ManageNewsPage clickManageNewsMoreInfo()
		{
			managenewsmoreinfo.click();
			return new ManageNewsPage(driver);
		}
}
