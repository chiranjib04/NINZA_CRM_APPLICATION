package com.ninza.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	WebDriver driver;
	
	public CreateCampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "campaignName")
	private WebElement campaignName;
	
	@FindBy (name = "campaignStatus")
	private WebElement campaignStatus;
	

	@FindBy (name = "targetSize")
	private WebElement targetSize;
	
	
	@FindBy (name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy (name = "targetAudience")
	private WebElement targetAudience;
	
	@FindBy (xpath = "//textarea[@name='description']")
	private WebElement description;
	
	@FindBy (xpath = "//button[@type='submit']")
	private WebElement createCampaign_confirmClick;

	
	
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getTargetAudience() {
		return targetAudience;
	}

	public WebElement getDescription() {
		return description;
	}
	
	public WebElement getCreateCampaign_confirmClick() {
		return createCampaign_confirmClick;
	}
	
}
