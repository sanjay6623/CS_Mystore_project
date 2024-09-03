package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	
WebDriver ldriver;
	
	public PaymentPage (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	
	@FindBy(name = "name_on_card") WebElement CardName;
	@FindBy(name="card_number") WebElement cardNumber;
	@FindBy(name="cvc") WebElement CvcNumber;
	@FindBy(name="expiry_month") WebElement ExpMonth;
	@FindBy(name="expiry_year") WebElement ExpYear;
	@FindBy(id="submit") WebElement SubmitOrder;
	
	public void payment(String cardName,String cardNo,String cvcNumber,String expMonth,String expYear ) {
		
		CardName.click();
		CardName.sendKeys(cardName);
		cardNumber.click();
		cardNumber.sendKeys(cardNo);
		CvcNumber.click();
		CvcNumber.sendKeys(cvcNumber);
		ExpMonth.click();
		ExpMonth.sendKeys(expMonth);
		ExpYear.click();
		ExpYear.sendKeys(expYear);
		
		
		
		
	}
	
	public void payConfirmOrder() {
		SubmitOrder.click();
		
	}

}
