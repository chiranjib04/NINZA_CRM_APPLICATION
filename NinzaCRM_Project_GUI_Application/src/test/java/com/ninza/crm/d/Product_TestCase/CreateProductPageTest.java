package com.ninza.crm.d.Product_TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ninza.crm.baseClass.BaseClass;
import com.ninza.crm.objectRepository.AddProductsPage;
import com.ninza.crm.objectRepository.HomePage;
import com.ninza.crm.objectRepository.ProductsPage;

@Listeners(com.ninza.crm.listenersUtility.ListenersImplementation.class)

public class CreateProductPageTest extends BaseClass
{
	
	@Test(groups = "Smoke")
	public void CreateProductWithMandatoryFieldsTest() throws InterruptedException
	{
		HomePage home=new HomePage(driver);
		home.getProductsLink().click();
		
		ProductsPage prod_page=new ProductsPage(driver);
		prod_page.getaddProductsLink().click();
		
		int randomNum = jutil.randomNumberGenerator();
		AddProductsPage addProduct=new AddProductsPage(driver);
		addProduct.getProductName().sendKeys(randomNum +"bmw" + randomNum);
		
		addProduct.getQuantity().clear();
		addProduct.getQuantity().sendKeys("1256");
		
		addProduct.getPrice().clear();
		addProduct.getPrice().sendKeys("151*1000");
		
		Select selectProductCategory=new Select(addProduct.getProductCategory()); 
		selectProductCategory.selectByContainsVisibleText("Electronics");
	
//		wait.until(ExpectedConditions.elementToBeSelected(addProduct.getVendorId()));
		Select selectVendorId=new Select(addProduct.getVendorId());
			selectVendorId.selectByValue("VID_447");

		addProduct.getAddProductBtn().click();
		
		wait.until(ExpectedConditions.visibilityOf(prod_page.getToastMsgAlertProduct()));
		String toast = prod_page.getToastMsgAlertProduct().getText();

		System.out.println(toast);
		Assert.assertTrue(toast.contains("Successfully"), toast);
		
//		if(toast.contains("Successfully"))
//			System.out.println("campaign created successully");
//
//		else
//			System.out.println("not created");

		wait.until(ExpectedConditions.elementToBeClickable(prod_page.getConfirmBtncloseProduct()));
		prod_page.getConfirmBtncloseProduct().click();
		Thread.sleep(2000);
		System.out.println("-------------------Smoke testing---------------------");

	}
//    2-------------------------------------------------------------------------//
	
	@Test(groups = "Regression")
	public void CreateProductWithoutAddProductTest() throws InterruptedException
	{
		HomePage home=new HomePage(driver);
		home.getProductsLink().click();
		
		ProductsPage prod_page=new ProductsPage(driver);
		prod_page.getaddProductsLink().click();
		
		int randomNum = jutil.randomNumberGenerator();
		AddProductsPage addProduct=new AddProductsPage(driver);
		addProduct.getProductName().sendKeys(randomNum +"bmw"+ randomNum);
		
		addProduct.getQuantity().clear();
		addProduct.getQuantity().sendKeys("1256");
		
		addProduct.getPrice().clear();
		addProduct.getPrice().sendKeys("151*1000");
		
		Select selectProductCategory=new Select(addProduct.getProductCategory()); 
		selectProductCategory.selectByContainsVisibleText("Electronics");
	
//		wait.until(ExpectedConditions.elementToBeSelected(addProduct.getVendorId()));
		Select selectVendorId=new Select(addProduct.getVendorId());
		selectVendorId.selectByValue("VID_447");

//		addProduct.getAddProductBtn().click();
//		
//		wait.until(ExpectedConditions.visibilityOf(prod_page.getToastMsgAlertProduct()));
//		String toast = prod_page.getToastMsgAlertProduct().getText();
//
//		if(toast.contains("Successfully"))
//			System.out.println("campaign created successully");
//
//		else
//			System.out.println("not created");
//
//		wait.until(ExpectedConditions.elementToBeClickable(prod_page.getConfirmBtncloseProduct()));
//		prod_page.getConfirmBtncloseProduct().click();

	System.out.println("---------------Regression test case--------------------");

	}
}
