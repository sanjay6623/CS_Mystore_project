package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginAccountCreation;
import com.mystore.pageobject.RegisteredUser;
import com.mystore.pageobject.SignupPage;
import com.mystore.utilities.RandomEmailGenerator;



public class TC01_LoginPage extends BaseClass {

	@Test (enabled=true)
	public void Singnup_login() throws InterruptedException 
	{

		HomePage homepage= new HomePage(driver);
		homepage.clickOnLogin();
		logger.info("Click on singup/login button");
		System.out.println("Loging page title:  "+homepage.pageTitle());
		logger.info("Get the title of homepage: ");
		SignupPage signuppage= new SignupPage(driver);
		signuppage.enterName("sanjay kumar");
		Thread.sleep(2000);
		
		logger.info("Random email generator started:  ");
		RandomEmailGenerator email=new RandomEmailGenerator();
		String emails=email.emailGenerator();
		
		logger.info("Random email given to user filed:  ");
		signuppage.enterEmail(emails);
		signuppage.clickSingupButton();
		LoginAccountCreation accountCreation=new LoginAccountCreation(driver);
		logger.info("Account information enttring started: ");
		accountCreation.selectTitleMr();
		accountCreation.enterPassword("sanjay");
		logger.info("Date of birth entring started: ");
		accountCreation.enterDay("1");
		accountCreation.enterMonth("January");
		accountCreation.enterYear("1984");
		accountCreation.enterFirstName("Sanjay");
		accountCreation.enterLastName("kumar");
		accountCreation.enterCompneyName("Jaina");
		accountCreation.enterAddress("Okhla phase 1");
		accountCreation.enterCountry("India");
		accountCreation.enterState("Delhi");
		accountCreation.enterCity("Delhi");
		accountCreation.enterZipcode("110020");
		accountCreation.enterMobileNumber("8800898856");
		Thread.sleep(2000);
		accountCreation.clickSubmit();
		logger.info("submisstion button clicked: ");
		System.out.println(accountCreation.AccountTitle());
		Assert.assertEquals("Automation Exercise - Account Created", accountCreation.AccountTitle());
		logger.info("Account creation done");
		RegisteredUser registeruser= new RegisteredUser(driver);
		registeruser.clickContinue();
		String accountname=registeruser.checkAccountName();
		String actualaccountname="sanjay kumar";
		Assert.assertEquals(actualaccountname, accountname);

		/*
		 * if(actualaccountname.equals(accountname)) { Assert.assertTrue(true);
		 * 
		 * System.out.println("Account name visible" +accountname ); }
		 */
		logger.info("Singup loing *****************************TC01***************** Test Case end");


	}

	

}
