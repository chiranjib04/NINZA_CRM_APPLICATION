package com.ninza.crm.Campaign_TestCase;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ninza.crm.baseClass.BaseClass;
import com.ninza.crm.objectRepository.CampaignPage;
import com.ninza.crm.objectRepository.CreateCampaignPage;


@Listeners(com.ninza.crm.listenersUtility.ListenersImplementation.class)


public class CreateCampaignPageTest extends BaseClass
{

	@Test (groups = "Smoke")
	public void createCamapignWithMadatoryFieldsTest() throws IOException, ParseException, org.json.simple.parser.ParseException
	{


		System.out.println("hello");
		CampaignPage campaign_page=new CampaignPage(driver);
		wait.until(ExpectedConditions.visibilityOf(campaign_page.getCreateCampaignLink()));
		campaign_page.getCreateCampaignLink().click();

		CreateCampaignPage create_CampPage=new CreateCampaignPage(driver);

		create_CampPage.getCampaignName().sendKeys("chiranjib");

		create_CampPage.getCampaignStatus().sendKeys("running");

		create_CampPage.getTargetSize().clear();
		create_CampPage.getTargetSize().sendKeys("500");

		//		String date = jutil.getCurrentDate();
		//		create_CampPage.getExpectedCloseDate().sendKeys(date);
		//		create_CampPage.getTargetAudience().sendKeys("youthhh");
		//		create_CampPage.getDescription().sendKeys("m busy right now");

		create_CampPage.getCreateCampaign_confirmClick().click();

		wait.until(ExpectedConditions.visibilityOf(campaign_page.getToastMsgAlert()));
		String toast = campaign_page.getToastMsgAlert().getText();
		System.out.println("toast--"+ toast);
		Assert.assertTrue(toast.contains("Successfully"),toast);


//				if(toast.contains("Successfully"))
//					System.out.println("campaign created successully");
//				else
//					System.out.println("not created");

		wait.until(ExpectedConditions.elementToBeClickable(campaign_page.getConfirmBtnclose()));
		campaign_page.getConfirmBtnclose().click();	
		System.out.println("----------Smoke testing done--------------------");


	}

	//  2----------------------------------------------------------------------------	

	@Test(groups = "Regression")
	public void createCamapignWithExpectedCloseDateTest() throws IOException, ParseException, org.json.simple.parser.ParseException, InterruptedException
	{
		String date = jutil.getCurrentDate();

		CampaignPage campaign_page=new CampaignPage(driver);
		wait.until(ExpectedConditions.visibilityOf(campaign_page.getCreateCampaignLink()));
		campaign_page.getCreateCampaignLink().click();

		CreateCampaignPage create_CampPage=new CreateCampaignPage(driver);

		create_CampPage.getCampaignName().sendKeys("chiranjib");

		create_CampPage.getCampaignStatus().sendKeys("running");

		create_CampPage.getTargetSize().clear();
		create_CampPage.getTargetSize().sendKeys("500");

		create_CampPage.getExpectedCloseDate().sendKeys(date);
		create_CampPage.getTargetAudience().sendKeys("youthhh");
		create_CampPage.getDescription().sendKeys("m busy right now");

		create_CampPage.getCreateCampaign_confirmClick().click();

		wait.until(ExpectedConditions.visibilityOf(campaign_page.getToastMsgAlert()));
		String toast = campaign_page.getToastMsgAlert().getText();
		System.out.println(toast);
		Assert.assertTrue(toast.contains("Successfully"), toast);
		
//		if(toast.contains("Successfully"))
//			System.out.println("campaign created successully");
//		else
//			System.out.println("not created");

		wait.until(ExpectedConditions.elementToBeClickable(campaign_page.getConfirmBtnclose()));
		campaign_page.getConfirmBtnclose().click();	
		Thread.sleep(3000);
		System.out.println("---------------Regression testing Done---------------");
	}

}
