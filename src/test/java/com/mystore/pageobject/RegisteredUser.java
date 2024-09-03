package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUser {
	
	

	WebDriver ldriver;
	
	public RegisteredUser (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	
	@FindBy(linkText = "Continue") WebElement ContinueButton;
	@FindBy(xpath="//b[normalize-space()='sanjay kumar']") WebElement accountName;
	@FindBy(css = "a[href='/logout']") WebElement logOut;
	@FindBy(xpath="//a[@href='/products']") WebElement product;
	
	public void clickContinue() {
		ContinueButton.click();
		
	}
	
	public String checkAccountName() {
		return accountName.getText();
		
	}
	
	public void clickOnProduct() {
		
		product.click();
	}
	
	public void logoutuser() {
		
		logOut.click();
	}

}
