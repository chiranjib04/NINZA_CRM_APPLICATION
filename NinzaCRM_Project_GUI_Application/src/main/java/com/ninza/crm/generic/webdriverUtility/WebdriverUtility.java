package com.ninza.crm.generic.webdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	

	public void mouseHoverActions(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void waitForVisibilityOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameStringName(WebDriver driver,String value)
	{
		driver.switchTo().frame(value);
	}
	
	public void select(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByContainsVisibleText(value);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String switchToAlertAndGetText(WebDriver driver)
	{
		String text=driver.switchTo().alert().getText();
		return text;
	}
	
	public void switchToAlertAndSendKeys(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);	
	}
	
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();;
	}
	
	public void clickOnElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	
	public void switchToWindow(WebDriver driver)
	{
		String parent=driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		allWindow.remove(parent);
		for(String str : allWindow)
		{
			driver.switchTo().window(str);
		}
	}
	
	public void takeScreenShot(WebDriver driver,String filename) throws IOException
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File temp=ts.getScreenshotAs(OutputType.FILE);
	File perm=new File("./errorshot/" +filename + " .png");
	FileHandler.copy(temp, perm);
	}
	
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick().perform();
	}
	
	public void  rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void passInput(WebDriver driver,WebElement element,String text)
	{
		Actions actions=new Actions(driver);
		actions.click(element).sendKeys(text).perform();
	}
	
	public void toScrollBy(WebDriver driver,WebElement element)
	{
		
	}

}
