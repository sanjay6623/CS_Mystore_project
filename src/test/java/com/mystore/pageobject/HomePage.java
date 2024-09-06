package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	
	WebDriver ldriver;
	WebDriverWait wait;
	
	public HomePage(WebDriver rdriver) {
		
		ldriver=rdriver;
		wait=new WebDriverWait(ldriver,Duration.ofSeconds(10));
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(css="a[href='/login']") 
	WebElement Signup ;
	@FindBy(xpath="//i[@class='fa fa-angle-up']") WebElement pageScroll;
	
	@FindBy(xpath="//h2[normalize-space()='Subscription']") WebElement scuription;
	@FindBy(xpath="//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]") WebElement textVisible;
	
	
	public void clickOnLogin() {
		
		Signup.click();
	}
	
	public String pageTitle() {
		
		 String title= ldriver.getTitle();
		return title;
		
	}
	public void scrollup() {
		
		
	wait.until(ExpectedConditions.visibilityOf(pageScroll)).click();;
		
	}
	
	public String subscriptionVisble() {
		
		return scuription.getText();
	}
	public String HomePageText() {
		
		return textVisible.getText();	
		
		}
	
	
	
	
}
