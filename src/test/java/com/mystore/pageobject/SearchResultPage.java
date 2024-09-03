package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
WebDriver ldriver;
	
	public SearchResultPage (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	
	@FindBy(xpath="//span[normalize-space()='Tshirt']") WebElement tShirtText;
	@FindBy(css="a[href='/product_details/2']") WebElement viewProduct;
	@FindBy(xpath="(//a[@class='btn btn-default add-to-cart'])[1]") WebElement mouseHAddCart;
	
	public String SearchResult() {
		
	return	tShirtText.getText();
		
		
	}
	
	public void viewProductDetails() {
		
		viewProduct.click();
		
	}
	
	public void mouseHoverAddCart() {
		Actions action=new Actions(ldriver);
		action.moveToElement(mouseHAddCart).build().perform();
		mouseHAddCart.click();
		
		
	}
	
	

}
