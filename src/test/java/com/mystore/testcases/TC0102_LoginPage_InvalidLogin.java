package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.RegisteredUser;
import com.mystore.pageobject.SignupPage;

public class TC0102_LoginPage_InvalidLogin extends BaseClass {
	

	@Test(groups="SmokeTest")
	public void verifyInvalidEmailLogin() throws IOException {
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
		signuppage.enterRegistredEmail("sanjay6@gmail.com");
		logger.info("Entring email id done:  ");
		signuppage.enterRegistredPass("sanjay");
		signuppage.clickLogin();
		logger.info("click on login for incorrect Email user:  ");

		String incorrectEmail=signuppage.incorrectEmailMessage();
		System.out.println(incorrectEmail);
		String acctualMessage="Your email or password is incorrect!";

		if(incorrectEmail.equals(acctualMessage)) {

			logger.info("Incorrect email login passed:  " +incorrectEmail );
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		logger.info("Verifiy  invalid loging *****************************TC01***************** Test Case end");



	}

}
