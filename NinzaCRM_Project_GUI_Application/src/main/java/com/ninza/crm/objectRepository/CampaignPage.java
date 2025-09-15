package com.ninza.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	WebDriver driver;
	
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[text()='Create Campaign']")
	private WebElement CreateCampaignLink;
	
	@FindBy (xpath = "//div[@role='alert']")
	private WebElement toastMsgAlert;
	
	
	@FindBy(xpath = "//button[@aria-label='close']/../..//button[@*='close']")
	private WebElement confirmBtnclose;
	
	public WebElement getConfirmBtnclose() {
		return confirmBtnclose;
	}
	
	public WebElement getToastMsgAlert() {
		return toastMsgAlert;
	}

	public WebElement getCreateCampaignLink() 
	{
		return CreateCampaignLink;
	}
	
	
	
}
