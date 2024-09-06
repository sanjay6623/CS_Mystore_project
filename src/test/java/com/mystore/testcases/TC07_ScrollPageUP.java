package com.mystore.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;

import junit.framework.Assert;

public class TC07_ScrollPageUP extends BaseClass {
	JavascriptExecutor js;

	@Test
	public void ScrollHomePageUP() throws InterruptedException, IOException {
		HomePage homepage=new HomePage(driver);

		String expectedTitle=homepage.pageTitle();

		String actualTitle="Automation Exercise";
		if(expectedTitle.equals(actualTitle)) {

			logger.info("Title of home page : " +expectedTitle );
			Assert.assertTrue(true);
		}
		else {
			logger.info("Title of home page wrong");
			Assert.assertTrue(false);
		}

		 js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

		logger.info("Scrolling page to down and visble");

		String subscriptionText=homepage.subscriptionVisble();
		System.out.println(subscriptionText);
		String actualSubscriptionText="SUBSCRIPTION";
		if(subscriptionText.equals(actualSubscriptionText)) {
			logger.info("subscription text matched:    " + subscriptionText);
			Assert.assertTrue(true);
		}
		else {

			logger.info("subcripition text not matched test case failed:  " + subscriptionText);
			captureScreenShot(driver,"Subscripition Text");
			Assert.assertTrue(true);
		}
		Thread.sleep(4000);
		
		
		js.executeScript("window.scrollTo(0,0);");
		String	homepageText=homepage.HomePageText();
		System.out.println(homepageText);
		String homepageActualText="Full-Fledged practice website for Automation Engineers";
		
		if(homepageText.equals(homepageActualText)) {
			
			logger.info("homepage text visble and text case pass: " +homepageText );
			Assert.assertTrue(true);
		}
		else {
			logger.info("homepage text not visble and text case failed: " +homepageText );
			captureScreenShot(driver,"HomePage Text");
			Assert.assertTrue(false);
		}

		Thread.sleep(4000);

	}

}
