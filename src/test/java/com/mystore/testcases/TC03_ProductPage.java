package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.RegisteredUser;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.SignupPage;

public class TC03_ProductPage extends BaseClass {
	
	
	@Test(priority=5)
	public void productSearchPage() throws IOException, InterruptedException {
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
		System.out.println(registeruser.checkAccountName());
		logger.info("User Registration name     " + registeruser.checkAccountName());
		String accountname=registeruser.checkAccountName();
		String actualAccountname="sanjay kumar";

		if(accountname.equals(actualAccountname)) {
			logger.info("Verify login with correct credential is passed: ");

			Assert.assertTrue(true);
			
		}
		else
		{
			logger.info("Verify login Name is Failed: ");
			captureScreenShot(driver,"verifyCorrectLogin");
			
			Assert.assertTrue(false);
			
		}
		
		
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
		String searchText=searchResult.SearchResult();
		System.out.println("Search Text:  "+searchText);
		String searchTextExpeted="Tshirt";
		
		if(searchText.equals(searchTextExpeted)) {
			logger.info("Comparing result and checking for correct product: "  );
			System.out.println("Search Result text:  "+searchText);
			Assert.assertTrue(true);
			
		}
		else {
			
			logger.info("verfiy Tshirt Result failed:  ");
			captureScreenShot(driver,"productSearchPage");
			Assert.assertTrue(false);
		}
		
		
			registeruser.logoutuser();
			logger.info("User has been logout sucessfully:   ");
			System.out.println(signuppage.loginVisible());
			System.out.println("Loging visible for user to enter email and password:  "+loginvisibleText);
			
			if(loginvisibleText.equals("Login to your account")) {
				
				Assert.assertTrue(true, "Logout test passed");
			}
			else {
				captureScreenShot(driver,"productSearchPage");
				Assert.assertTrue(false,"Logout failed :  ");
				
			}
			
			logger.info("Product Search page *****************************TC03***************** Test Case end");


	}

}
