package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.RegisteredUser;
import com.mystore.pageobject.SignupPage;

public class TC0101_LoginPage_ValidLogin extends BaseClass {
	
	@Test
	public void verifyCorrectLogin() throws IOException {
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
		logger.info("Verifiy correct loging *****************************TC01***************** Test Case end");





	}

}
