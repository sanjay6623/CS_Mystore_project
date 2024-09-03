package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	
WebDriver ldriver;
	
	public ProductPage (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	
	@FindBy(id="search_product") WebElement searchProduct;
	@FindBy(id="submit_search") WebElement submitsearch;
	
	
	
	
	public void clickOnSearchProduct(String searchKeyword) {
		
		searchProduct.click();
		searchProduct.sendKeys(searchKeyword);
		
		
		
	}

	
	public void clickOnSearchButton() {
		
		submitsearch.click();
	}
	
	
}
