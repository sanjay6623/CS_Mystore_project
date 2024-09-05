package com.mystore.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	
WebDriver ldriver;
	
	public CheckoutPage (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	
	
	@FindBy(xpath="//textarea[@name='message']") WebElement textMessage;
	@FindBy(css = "a[href='/payment']") WebElement placeOrder;
	@FindBy(xpath="//ul[@id='address_delivery']//li") List<WebElement> AddressOfDelevery;
	@FindBy(xpath="(//p[@class='text-center'][1])[1]") WebElement ErrorLoginRequired;
	
	public String checkoutPageTitle() {
		
		return ldriver.getTitle();
	}
	
	
	public void messageComment(String comments) {
		textMessage.sendKeys(comments);
		
	}
	public List<String> confirmAddress() {
		
		List<WebElement> addressElements=AddressOfDelevery;
		// Create a list to store the text of each address element
		List<String> addressTexts=new ArrayList<>();
		
		
		for(WebElement addressElement :addressElements ) {
			 addressTexts.add(addressElement.getText());
			
		}
		return addressTexts;
		
		
		
	}
	
	public void placeOrder() {
		placeOrder.click();
		
	}
	public String checkOutError() {
		return ErrorLoginRequired.getText();
		
	}

}
