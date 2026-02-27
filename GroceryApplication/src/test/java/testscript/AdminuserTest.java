package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.AdminuserPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.RandomDataUtility;

public class AdminuserTest extends Base
{
HomePage homepage;
AdminuserPage adminuserpage;
	@Test(description="user is trying to add newuser")
	
public void verifywhetherUserisAbletoAddNewuser() throws IOException
{

	String usernamevalue=ExcelUtility.readStringData(0, 0,"LoginPage");
	String passwordvalue=ExcelUtility.readStringData(0, 1,"LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
	homepage=loginpage.clickSignInButton();
	adminuserpage=homepage.clickAdminuserMoreinfo();
	RandomDataUtility randomdatautility=new RandomDataUtility();
	String adminpageusername=randomdatautility.randomUserName();
	String adminpagepassword=randomdatautility.randomPasswordName();
	adminuserpage.clickNewButton().enterAdminUsername(adminpageusername).enterAdminPassword(adminpagepassword).selectUsertype().clickSaveButton();
	
	
	Boolean assertsavealert=adminuserpage.verifyAlertIsDisplayed();
	Assert.assertTrue(assertsavealert,Constant.ADDNEWUSERERROR);

	
}

	@Test(description="user is trying to search newlyadded user")
public void verifyWhetherUserisAbletoSuccessfullySearchNewlyAddedUser() throws IOException
{
	
	String usernamevalue=ExcelUtility.readStringData(0, 0,"LoginPage");
	String passwordvalue=ExcelUtility.readStringData(0, 1,"LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
	homepage=loginpage.clickSignInButton();
	adminuserpage=homepage.clickAdminuserMoreinfo();
	String newlyaddedusername=ExcelUtility.readStringData(0, 0,"AdminPage");
	adminuserpage.searchButton().newlyAddedUsername(newlyaddedusername).searchNewlyAddedUsertype().clickSearchButton();
	
	
	Boolean asserttextofsearch=adminuserpage.verifyAdminUserSearchDisplayed();
	Assert.assertTrue(asserttextofsearch,Constant.SEARCHNEWLYADDEDUSERERROR);

	
}
	@Test(description="user is able to click reset button successfully")
	public void verifyWhetherUserisAbletoReset() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickSignInButton();
		adminuserpage=homepage.clickAdminuserMoreinfo();
	    adminuserpage.resetButton();
		
		Boolean assertreset=adminuserpage.verifyAdminUserResetClicked();
		Assert.assertTrue( assertreset,Constant.USERISABLETORESETERROR);
	}
	
}
	

