package com.mystore.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.LoginAccountCreation;
import com.mystore.pageobject.RegisteredUser;
import com.mystore.pageobject.SignupPage;
import com.mystore.utilities.ReadExcelFile;



public class TC02_LoginPage_DataDriven extends BaseClass {

	@Test (enabled=false)
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
		signuppage.enterEmail("sanjay664@gmail.com");
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
		logger.info("Singnup Loging *****************************TC02***************** Test Case end");

	}

	@Test(dataProvider = "LoginDataProvider")
	public void verifyCorrectLogin(String userEmail, String userPassword, String expectedUserName) throws IOException {
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
		signuppage.enterRegistredEmail(userEmail);
		logger.info("Entring email id done:  ");
		signuppage.enterRegistredPass(userPassword);
		signuppage.clickLogin();
		logger.info("click on login for registed user:  ");
		RegisteredUser registeruser= new RegisteredUser(driver);
		System.out.println(registeruser.checkAccountName());
		logger.info("User Registration name     " + registeruser.checkAccountName());
		String accountname=registeruser.checkAccountName();
		String actualAccountname=expectedUserName;

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
		
		registeruser.logoutuser();
		logger.info("User has been logout:   ");
		signuppage.loginVisible();
		System.out.println("Loging visible for user to enter email and password:  "+loginvisibleText);
		
		logger.info("Correct credintial login data driver *****************************TC02***************** Test Case end");


	}
	
	@DataProvider(name = "LoginDataProvider")
	public String [][] LoginDataProvider(){
		//System.out.println(System.getProperty("user.dir"));
		String fineName=System.getProperty("user.dir")+"\\TestData\\automationexcercise.xlsx";
		int ttlRows=ReadExcelFile.getRowCount(fineName, "logindata");
		int ttColumns=ReadExcelFile.getColCount(fineName, "logindata");
		//String type 2 dimensional object created
		String data[][] =new String[ttlRows-1][ttColumns];
		
		for(int i=1;i<ttlRows;i++) { // rows =1,2
			
			for(int j=0;j<ttColumns;j++) { //col=0,1,2
				
				data[i-1][j]=ReadExcelFile.getCellValue(fineName, "logindata", i, j);
				
			}
			
		}return data;
	}
	


}
