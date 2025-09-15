package com.ninza.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProductsPage {

	WebDriver driver;
	public AddProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
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

	public WebElement getAddProductBtn() {
		return AddProductBtn;
	}


	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "productCategory")
	private WebElement productCategory;
	
//	Select class of selenium is used to handle dropdownlist
//	public Select select=new Select(productCategory);
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(name="price")
	private WebElement price;
	
	@FindBy(name="vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//*[text()='Add']")
	private WebElement AddProductBtn;
	
}
