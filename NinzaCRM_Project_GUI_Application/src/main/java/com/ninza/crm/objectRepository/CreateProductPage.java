package com.ninza.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	WebDriver driver;
	
	public CreateProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver ,this);
	}
	
	@FindBy (name = "productName")
	private WebElement productName;
	
	@FindBy (name = "productCategory")
	private WebElement productCatagory;
	
	@FindBy( name = "quantity")
	private WebElement quantity;
	
	@FindBy (name="price")
	private WebElement price;
	
	@FindBy (name="vendorId")
	private WebElement vendorId;
	
	@FindBy (xpath = "//*[text()='Add']")
	private WebElement AddProductButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCatagory() {
		return productCatagory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAdd() {
		return AddProductButton;
	}
	
}
