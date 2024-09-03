package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDone {
	
WebDriver ldriver;
	
	public PaymentDone (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	
	
	@FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")WebElement ConfirmationPaymentText;
	@FindBy(xpath="//a[@class='btn btn-primary']") WebElement ContinueButton;
	
	public String paymentDoneText() {
		
		return ConfirmationPaymentText.getText();
	}
	
	public void ContinueBtn() {
		ContinueButton.click();
		
	}

}
