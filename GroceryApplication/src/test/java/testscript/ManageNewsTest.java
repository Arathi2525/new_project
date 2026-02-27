package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base
{
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description="user is trying to add new News")
	
public void verifyUserisAbletoAddNewNews() throws IOException
{
	String usernamevalue=ExcelUtility.readStringData(0, 0,"LoginPage");
	String passwordvalue=ExcelUtility.readStringData(0, 1,"LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
	homepage=loginpage.clickSignInButton();
	managenewspage=homepage.clickManageNewsMoreInfo();
	String news=ExcelUtility.readStringData(0, 0,"ManageNewsPage");
	managenewspage.clickNewButton().enterNewNews(news).clickSave();
	
	
	Boolean alertpopup=managenewspage.verifyAlertIsDisplayed();
	Assert.assertTrue(alertpopup,Constant.USERISABLETOADDNEWSERROR);

}
	@Test(description="user is trying to search newly added News")
	public void verifyWhetherUserisAbletoSuccessfullySearchNewlyAddedNews() throws IOException
	{
		String usernamevalue=ExcelUtility.readStringData(0, 0,"LoginPage");
		String passwordvalue=ExcelUtility.readStringData(0, 1,"LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		homepage=loginpage.clickSignInButton();
		managenewspage=homepage.clickManageNewsMoreInfo();
		String newstitle=ExcelUtility.readStringData(0, 0,"ManageNewsPage");
		managenewspage.clickSearchButton().enterNewsTitle(newstitle).clickSubmitSearch();
		
		Boolean assertforsearchresult=managenewspage.verifySerachResultIsDisplayed();
		Assert.assertTrue(assertforsearchresult,Constant.USERISABLETOSEARCHNEWLYADDEDNEWSERROR);

	}

}

