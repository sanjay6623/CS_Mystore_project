package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.CheckoutPage;
import com.mystore.pageobject.ProductDetails;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUser;
import com.mystore.pageobject.SearchResultPage;

public class TC05_AddProductNoLogin extends BaseClass {
	
	@Test
	public void addProductWithoutLogin() throws InterruptedException {
	RegisteredUser registeruser= new RegisteredUser(driver);
	registeruser.clickOnProduct();
	logger.info("Click on Product ");
	ProductPage productpage=new ProductPage(driver);
	logger.info("Entering into product search page: ");
	productpage.clickOnSearchProduct("TSHIRT");
	logger.info("click on search product and enter TShirt");
	productpage.clickOnSearchButton();
	SearchResultPage searchResult=new SearchResultPage(driver);		
	logger.info("Enter into serch result of Tshirt:  ");
	Thread.sleep(2000);
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
	js.executeScript("window.scrollBy(0, 500);");
	
	logger.info("Java Script entring to scroll page to locate element:   ");
	Thread.sleep(4000);
	searchResult.mouseHoverAddCart();
	
	ProductDetails productdetails=new ProductDetails(driver);
	
	productdetails.ContniueShoping();
	productdetails.enterIntoCart();
	productdetails.cheeckoutProduct();
	CheckoutPage checkoutpage=new CheckoutPage(driver);
	String errorChecout=checkoutpage.checkOutError();
	
	if(errorChecout.equals("Register / Login account to proceed on checkout.")) {
		logger.info("Checkout Error message " +errorChecout );
		Assert.assertTrue(true);
	}
	else {
		
		logger.info("Process to check out failed:  ");
		try {
			captureScreenShot(driver,"addProductWithoutLogin");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Assert.assertTrue(false);
		
	}
	
	}
	
	

}
