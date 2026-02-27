package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 
{
	public void selectDropdownWithValue(WebElement element, String value)
	{
		Select object=new Select(element);
		object.selectByValue(value);
		
	}
	
	public void selectDropdownWithIndex(WebElement element, int index)
	{
		Select object=new Select(element);
		object.selectByIndex(index);
	}
	
	public void selecDropdownWithVisibleText(WebElement element, String text)
	{
		Select object=new Select(element);
		object.selectByVisibleText(text);
		
	}
	
	public void verifyMouseOver(WebElement element,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();//moveToElement for mouseover
	}
	
	public void verifyRightClick(WebElement element,WebDriver driver)
	{
	    Actions act=new Actions(driver);//control action to class
	    act.contextClick(element).build().perform();//contextClick for right click
	}
	
	public void verifyDoubleClick(WebElement element,WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).build().perform();//doubleClick for doubleclick
	}
	
	
	public void verifyDragAndDrop(WebElement drag,WebElement drop ,WebDriver driver)
	{
		
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();
	}
	
	public void verifyScroll(WebElement element,WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;//javascriptexecuter predefined interface (JavascriptExecutor)driver-casting
		js.executeScript("arguments[0].click();", element);//executescript is a predefined method .it is syntax(js.executeScript("arguments[0].click();", showMessageButton);
		js.executeScript("window.scrollBy(0,350)", "");//

}
}
