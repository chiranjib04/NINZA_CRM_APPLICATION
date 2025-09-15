package com.ninza.crm.objectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ninza.crm.baseClass.BaseClass;


public class LoginPage {

	  WebDriver driver;
	  
	public LoginPage(WebDriver driver)
	{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id ="username")
	private WebElement username;

	@FindBy(id ="inputPassword")
	private WebElement password;

	@FindBy(xpath ="//button[@type='submit']" )
	private WebElement login;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

	public void loginNinza(String url,String un,String pwd) 
	{
		//maximize window
		driver=BaseClass.sDriver;
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to ninza crm
		driver.get(url);

		LoginPage lp=new LoginPage(driver);
		lp.getUsername().sendKeys(un);
		lp.getPassword().sendKeys(pwd);
		lp.getLogin().click();
		
	}
	
}
