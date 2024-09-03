package com.mystore.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductDetails {


	
	
	
	
	
	WebDriver ldriver;

	public ProductDetails (WebDriver rdriver) {

		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);

	} 

	@FindBy(css="button[type='button']") WebElement addcart;
	@FindBy(id="quantity") WebElement Quantity;
	@FindBy(xpath="//button[@class='btn btn-success close-modal btn-block']") WebElement continueShop;
	@FindBy(id="name") WebElement textBoxName;
	@FindBy(id="email") WebElement textBoxEmail;
	@FindBy(name="review") WebElement reviewEnter;
	@FindBy(linkText = "Cart") WebElement cardEnter;
	@FindBy(xpath="//a[@class='btn btn-default check_out']") WebElement checkout;
	

	public String productDetailTitle() {

		return ldriver.getTitle();
	}
	
	public void AddtoCart() {
		
		addcart.click();
	}
	
	public void productQuantity(String qty) {
		Quantity.click();
		Quantity.clear();
		Quantity.sendKeys(qty);
		/*
		 * Actions action=new Actions(ldriver); WebElement
		 * element=ldriver.findElement(By.id("product_id"));
		 * action.moveToElement(element).perform();
		 */
		
		
	}
	public void ContniueShoping() {
		
		continueShop.click();
	}
	public void enterNameEmailReview() {
		
		textBoxName.sendKeys("sanjayKumar");
		textBoxEmail.sendKeys("sanjay6623@gmail.com");
		reviewEnter.sendKeys("This is my Tshirt order quantity two:  ");
	}
	public void enterIntoCart() {
		cardEnter.click();
		
	}
	public void cheeckoutProduct() {
		
		checkout.click();
	}

}
