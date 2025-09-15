package com.ninza.crm.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	public 	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(linkText ="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText ="Leads")
	private WebElement LeadsLink;
	
	@FindBy(linkText ="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText ="Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText ="Quotes")
	private WebElement QuotesLink;
	
	@FindBy(linkText ="Purchase Order")
	private WebElement Purchase_Order_Link;

	@FindBy(linkText ="Sales Order")
	private WebElement Sales_Order_Link;
	
	@FindBy(linkText ="Invoice")
	private WebElement Invoice_Link;
	
	@FindBy(xpath = "//li[text()='Admin Console']")
	private WebElement Admin_Console;
	
	@FindBy(xpath="//*[@*='user-icon']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logoutButton;
	
	

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getQuotesLink() {
		return QuotesLink;
	}

	public WebElement getPurchase_Order_Link() {
		return Purchase_Order_Link;
	}

	public WebElement getSales_Order_Link() {
		return Sales_Order_Link;
	}

	public WebElement getInvoice_Link() {
		return Invoice_Link;
	}

	public WebElement getAdmin_Console() {
		return Admin_Console;
	}

	public WebElement getUsericon() {
		return userIcon;
	}

	public void logout() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(getUsericon()));
		actions.moveToElement(getUsericon()).perform();
		wait.until(ExpectedConditions.elementToBeClickable(getLogoutButton()));
		actions.moveToElement(getLogoutButton()).click().perform();
	}
}
