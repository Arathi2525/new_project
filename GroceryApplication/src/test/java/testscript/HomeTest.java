package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;

public class HomeTest extends Base
{
	HomePage homepage;
	@Test(description="user is trying to logout successfully")
	
public void verifywhetherUserisAbletoSuccessfullyLoggedOut() throws IOException
{

	String usernamevalue=ExcelUtility.readStringData(0, 0,"LoginPage");
	String passwordvalue=ExcelUtility.readStringData(0, 1,"LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
	homepage=loginpage.clickSignInButton();
	homepage.clickAdmin();
	loginpage=homepage.clickLogout();
	
	
	String expected="7rmart supermarket";
	String actual=loginpage.getTextofSuperMarket();
	Assert.assertEquals(actual, expected,Constant.USERISABLETOSUCCESSFULLYLOGGEDOUTERROR);

		
		     
	
}
}
