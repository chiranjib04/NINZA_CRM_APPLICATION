package com.ninza.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	WebDriver driver;
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath = "//span[text()='Add Product']")
	private WebElement addProductsLink;

	public WebElement getaddProductsLink() {
		return addProductsLink;
	}
	
	@FindBy (xpath = "//div[@role='alert']")
	private WebElement toastMsgAlertProduct;
	
	
	@FindBy(xpath = "//button[@aria-label='close']/../..//button[@*='close']")
	private WebElement confirmBtncloseProduct;

	
	public WebElement getToastMsgAlertProduct() {
		return toastMsgAlertProduct;
	}

	public WebElement getConfirmBtncloseProduct() {
		return confirmBtncloseProduct;
	}

}
