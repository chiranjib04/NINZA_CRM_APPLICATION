package com.ninza.crm.baseClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Demo_BaseClass_Concept {
	@BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Login to application");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("logout  to application");
	  }

	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Launch the browser");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("close browser");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("pre condition for parellel execution");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("post condition for parellel execution");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("connect to database");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("disconnect to database");
	  }
}
