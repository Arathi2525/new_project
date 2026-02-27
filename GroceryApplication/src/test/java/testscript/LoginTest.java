package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base

{
	HomePage homepage;
	@Test(priority=1,description="user is trying to login with valid credentials",groups= {"smoke"})
	public void verifyUserloginwithValidCredential() throws IOException
	{
			String usernamevalue=ExcelUtility.readStringData(0, 0,"LoginPage");
			String passwordvalue=ExcelUtility.readStringData(0, 1,"LoginPage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);//Chaining
			homepage=loginpage.clickSignInButton();
			Boolean dashboard=loginpage.verifyDashboardDisplayed();
			Assert.assertTrue(dashboard,Constant.VALIDCREDENTIALERROR);

}
	@Test(priority=2,description="user is trying to login with invalid credentials",retryAnalyzer=retry.Retry.class)
	public void verifyUserloginwithInvalidCredential() throws IOException 
	{
		String usernamevalue=ExcelUtility.readStringData(1, 0,"LoginPage");
		String passwordvalue=ExcelUtility.readStringData(1, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickSignInButton();
		String expected="7rmart supermarket";
		String actual=loginpage.getTextofSuperMarket();
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);

	}
	@Test(priority=3,description="user is trying to login with valid username and invalid password")
	public void verifyUserloginwithValidUsernameAndInvalidPassword() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(2, 0,"LoginPage");
		String passwordvalue=ExcelUtility.readStringData(2, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickSignInButton();
		String expected="7rmart supermarket";
		String actual=loginpage.getTextofSuperMarket();
		Assert.assertEquals(actual, expected,Constant.VALIDUSERNAMEINVALIDPASSWORDERROR);

	}
	@Test(priority=4,description="user is trying to login with invalid username and valid password",groups= {"smoke"},dataProvider="loginProvider")
	public void verifyUserloginwithInvalidUsernameAndValidPassword(String usernamevalue,String passwordvalue) throws IOException
	{
		//String usernamevalue=ExcelUtility.readStringData(3, 0,"LoginPage");
		//String passwordvalue=ExcelUtility.readStringData(3, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue).clickSignInButton();
		String expected="7rmart supermarket";
		String actual=loginpage.getTextofSuperMarket();
		Assert.assertEquals(actual, expected,Constant.INVALIDUSERNAMEVALIDPASSWORDERROR);

	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}