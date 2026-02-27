package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage
{
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)//creating a parameterized constructor
	{
	this.driver=driver;	
	PageFactory.initElements(driver, this);
	
}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newnews;
	@FindBy(id="news") WebElement enternews;
	@FindBy(xpath="//button[@type='submit' ]") WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertpopup;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchbutton;
	@FindBy(xpath="//input[@name='un']") WebElement searchnewstitle;
	@FindBy(xpath="//button[@type='submit']") WebElement submitsearch;
	@FindBy(xpath="//a[@href='http://groceryapp.uniqassosiates.com/admin/news/index?page_ad=1']") WebElement assertforsearchresult;
	
	public ManageNewsPage clickNewButton()
	{
		newnews.click();
		return this;
	}
	
	public ManageNewsPage enterNewNews(String news)
	{
		enternews.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickSave()
	{
		savebutton.click();
		return this;
	}
	
	public Boolean verifyAlertIsDisplayed()
	{
	return alertpopup.isDisplayed()	;
	}
	
	public ManageNewsPage clickSearchButton()
	{
		searchbutton.click();
		return this;
	}
	public ManageNewsPage enterNewsTitle(String newstitle)
	{
		searchnewstitle.sendKeys(newstitle);
		return this;
	}
	public ManageNewsPage clickSubmitSearch()
	{
         submitsearch.click();
         return this;
	}
	public Boolean verifySerachResultIsDisplayed()
	{
	return 	assertforsearchresult.isDisplayed();
	}
}