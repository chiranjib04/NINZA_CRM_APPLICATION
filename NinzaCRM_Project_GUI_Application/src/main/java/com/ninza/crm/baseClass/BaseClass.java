package com.ninza.crm.baseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.ninza.crm.generic.fileUtility.ExcelFileUtility;
import com.ninza.crm.generic.fileUtility.JsonFileUtility;
import com.ninza.crm.generic.webdriverUtility.JavaUtility;
import com.ninza.crm.objectRepository.CampaignPage;
import com.ninza.crm.objectRepository.CreateCampaignPage;
import com.ninza.crm.objectRepository.HomePage;
import com.ninza.crm.objectRepository.LoginPage;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {

	public WebDriver driver = null;

	public static WebDriver sDriver=null;
	public JsonFileUtility jsonFile=new JsonFileUtility();
	public ExcelFileUtility excelUtil=new ExcelFileUtility();
	public HomePage home_page=new HomePage(driver);
	public LoginPage login_page=new LoginPage(driver);
	public CampaignPage campaign_page=new CampaignPage(driver);
	public CreateCampaignPage create_CampPage=new CreateCampaignPage(driver);
	public 	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	public JavaUtility jutil=new JavaUtility();

	/////////////////////////////////////////////////////////////////////////

	@BeforeSuite(groups = {"Smoke" ,"Regression"})
	public void beforeSuite()
	{
		System.out.println("connect to database");
	}

	
	@BeforeTest(groups = {"Smoke" ,"Regression"})
	public void beforeTest() 
	{
		System.out.println("pre condition for parellel execution");
	}

	//	@Parameters("Browser")
	//public void beforeClass(String BROWSER)

	@BeforeClass(groups = {"Smoke" ,"Regression"})
	public void beforeClass() throws IOException, ParseException, org.json.simple.parser.ParseException 
	{ 
		System.out.println("launch the browser");

		JSONObject jf = jsonFile.jsonFileUtility("./src/test/resources/json_CommonData.json");
		String BROWSER = jsonFile.readDataFromJson(jf, "browser");
		System.out.println(BROWSER);
		EdgeOptions edgeOptions=new EdgeOptions();
		edgeOptions.addArguments("disable-notifications");

		//			Webdrivermanager.edgedriver().setup();

		if (BROWSER.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();  
		else if (BROWSER.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver(edgeOptions);     
		else if (BROWSER.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();  
		else if (BROWSER.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();   


		sDriver=driver;
		System.out.println(sDriver);
		System.out.println("launch the browser DONE");
	}


	@BeforeMethod(groups = {"Smoke" ,"Regression"})
	public void beforeMethod() throws IOException, ParseException, org.json.simple.parser.ParseException 
	{

		System.out.println("login");

		JSONObject jf = jsonFile.jsonFileUtility("./src/test/resources/json_CommonData.json");

		String	URL=jsonFile.readDataFromJson(jf, "url");
		String	USERNAME=jsonFile.readDataFromJson(jf, "username");
		String	PASSWORD=jsonFile.readDataFromJson(jf, "password");
		
//		String	USERNAME=System.getProperty("USERNAME");
//		String	PASSWORD=System.getProperty("PASSWORD");
				
		System.out.println("--" + URL + "--" +USERNAME+ "--" +PASSWORD);
		login_page.loginNinza(URL, USERNAME, PASSWORD);

		System.out.println("login DONE");
	}


	@AfterMethod(groups = {"Smoke" ,"Regression"})
	public void afterMethod() throws InterruptedException 
	{
		System.out.println("logout");

		HomePage home=new HomePage(driver);
		home.logout();

		System.out.println("logout DONE");
	}


	@AfterClass(groups = {"Smoke" ,"Regression"})
	public void afterClass() throws InterruptedException {
		System.out.println("close the browser");
		Thread.sleep(3000);
		driver.quit();

		System.out.println("close the browser DONE");

	}


	@AfterTest(groups = {"Smoke" ,"Regression"})
	public void afterTest() 
	{
		System.out.println("post condition for parallel exec");
	}

	@AfterSuite(groups = {"Smoke" ,"Regression"})
	public void afterSuite() 
	{
		System.out.println("disconnect to database");
	}

}