package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	
	
	WebDriver ldriver;
	
	public SignupPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	// for Registring user
	@FindBy(xpath ="//input[@placeholder='Name']" ) WebElement nameTextBox;
	@FindBy(xpath="//input[@data-qa='signup-email']") WebElement EmailAddress;
	@FindBy(css = "button[data-qa='signup-button']") WebElement Signup ;
	
	// Login visible or not
	@FindBy(xpath="//h2[normalize-space()='Login to your account']") WebElement loginAccVisible;
	
	// for incorrect email and password message visible
	@FindBy(xpath="//p[normalize-space()='Your email or password is incorrect!']") WebElement incorrectEmail;
	// Registered user login
	@FindBy(xpath="//input[@data-qa='login-email']") WebElement registredEmail;
	@FindBy(xpath="//input[@data-qa='login-password']") WebElement registredPass;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement login;
	public void enterName(String name) {
		
		nameTextBox.sendKeys(name);
	}
	public void enterEmail(String emailid) {
		
		EmailAddress.sendKeys(emailid);
	}
	public void clickSingupButton() {
		
		Signup.click();
	}
	
	// Check login visible or not
	public String loginVisible() {
		
		return loginAccVisible.getText();
		
	}
	
	
	public void enterRegistredEmail(String email) {
		registredEmail.sendKeys(email);
		
	}

	public void enterRegistredPass(String pass) {
		registredPass.sendKeys(pass);
		
	}
	public void clickLogin() {
		login.click();
		
	}
	public String incorrectEmailMessage() {
		 return incorrectEmail.getText();
		
	}
	
	
}
