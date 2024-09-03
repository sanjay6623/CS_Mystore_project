package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginAccountCreation {
	
	
	

	WebDriver ldriver;
	
	public LoginAccountCreation (WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	} 
	
	@FindBy(id="id_gender1") WebElement titleMr;
	@FindBy(id="id_gender2") WebElement titileMs;
	@FindBy(id="password") WebElement passWord;
	@FindBy(id="first_name") WebElement firstName;
	@FindBy(xpath="//input[@id='last_name']") WebElement lastName;
	@FindBy(id="company") WebElement Compney;
	@FindBy(id="address1") WebElement address;
	@FindBy(id="country") WebElement Country;
	@FindBy(id="state")WebElement state;
	@FindBy(id="city")WebElement city;
	@FindBy(id="zipcode")WebElement zipCode;
	@FindBy(id="mobile_number")WebElement Mnumber;
	@FindBy(id="days") WebElement day;
	@FindBy(id="months") WebElement month;
	@FindBy(id="years") WebElement year;
	@FindBy(xpath="//button[normalize-space()='Create Account']") WebElement creatAccount;
	
	public void selectTitleMr() {
		
		titleMr.click();
		
	}
	public void enterPassword(String pass) {
		passWord.sendKeys(pass);
		
	}
	public void enterDay(String value) {
		
		Select select=new Select(day);
		select.selectByVisibleText(value);
	}
public void enterMonth(String Month) {
		
		Select select=new Select(month);
		select.selectByVisibleText(Month);
	}
public void enterYear(String Year) {
	
	Select select=new Select(year);
	select.selectByVisibleText(Year);
}
	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
		
	}
	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
		
	}
	public void enterCompneyName(String CName) {
		Compney.sendKeys(CName);
		
	}
	public void enterAddress(String address1) {
		address.sendKeys(address1);
		
	}
	public void enterCountry(String country) {
		
		Select select=new Select(Country);
		select.selectByVisibleText(country);
		
		
	}
	public void enterState(String State) {
		state.sendKeys(State);
		
	}
	public void enterCity(String City) {
		city.sendKeys(City);
		
	}
	public void enterZipcode(String zip) {
		zipCode.sendKeys(zip);
		
	}
	public void enterMobileNumber(String Mobilenumber) {
		Mnumber.sendKeys(Mobilenumber);
		
	}
	public void clickSubmit() {
		creatAccount.click();
		
	}
	public String AccountTitle() {
		
		 
			return	ldriver.getTitle();
				
	}
	
	
}
