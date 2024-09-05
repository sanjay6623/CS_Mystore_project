package com.mystore.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.CheckoutPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.PaymentDone;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.ProductDetails;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUser;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.SignupPage;

public class TC04_AddProductCart extends BaseClass {


	@Test
	public void productAddToCartAndPayment() throws IOException, InterruptedException {
		HomePage homepage= new HomePage(driver);
		homepage.clickOnLogin();
		logger.info("Click on singup/login button");
		System.out.println("Loging page title:  "+homepage.pageTitle());
		logger.info("Get the title of homepage: ");
		SignupPage signuppage= new SignupPage(driver);
		logger.info("Enter into signup page for login");
		String loginvisibleText=signuppage.loginVisible();
		System.out.println("Loging visible for user to enter email and password:  "+loginvisibleText);
		String loginExpetedText="Login to your account";
		Assert.assertEquals(loginvisibleText,loginExpetedText );
		logger.info("Login for registred user visible:  ");
		signuppage.enterRegistredEmail("sanjay663@gmail.com");
		logger.info("Entring email id done:  ");
		signuppage.enterRegistredPass("sanjay");
		signuppage.clickLogin();
		logger.info("click on login for registed user:  ");
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
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0, 500);");
		
		logger.info("Java Script entring to scroll page to locate element:   ");
		searchResult.viewProductDetails();
		logger.info("Enter into View product details:   ");
		
		ProductDetails productdetails=new ProductDetails(driver);
		
		
		//Actions actions=new Actions(driver);
		logger.info("product detail page title: " +productdetails.productDetailTitle() );
		productdetails.productQuantity("2");
		productdetails.AddtoCart();
		logger.info("product added into cart...");
		Thread.sleep(3000);
		productdetails.ContniueShoping();
		
		productdetails.enterIntoCart();
		productdetails.cheeckoutProduct();
		
		CheckoutPage checkout=new CheckoutPage(driver);
		
		logger.info("checkout page title:  " + checkout.checkoutPageTitle());
		
		List<String> value=checkout.confirmAddress();
		System.out.println(value);
		if(value.contains("Jaina")) {
			logger.info("Address confirmation done:  ");
			Assert.assertTrue(true);
		}
		else {
			
			logger.info("Address found wrong: ");
			captureScreenShot(driver,"Addressconfirmtion failed");
			Assert.assertTrue(false);
		}
		
		
		Thread.sleep(2000);
		checkout.messageComment("This is my Tshirt order   ");
		
		checkout.placeOrder();
		
		PaymentPage payPage=new PaymentPage(driver);
		payPage.payment("sanjay kumar", "123456781234", "234", "12", "2025");
		payPage.payConfirmOrder();
		PaymentDone payDone=new PaymentDone(driver);
		
		logger.info("Payment done Text confirmation:  "+payDone.paymentDoneText());
		payDone.ContinueBtn();
		logger.info("Payment Done:  ");
		registeruser.logoutuser();
		//String loginAfterLogout=signuppage.loginVisible();
		
		logger.info("User Logout and lend to Loging page again:  ");
		String loginExpeted="Login to your account";
		if(loginvisibleText.equals(loginExpeted)) {
			logger.info("After payment loging visible:  ");
			Assert.assertTrue(true);
			
		}
		else {
			
			logger.info("Logut failed after Payment: ");
			
			captureScreenShot(driver,"productAddToCartAndPayment");
			Assert.assertTrue(false);
		}
		
		
		logger.info("Add to card product and Payment *****************************TC04***************** Test Case end");
		
				
			
			
		
		

		


	}


}
