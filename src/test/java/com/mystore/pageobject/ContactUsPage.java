package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
	WebDriver ldriver;
	
	public ContactUsPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(css = "a[href='/contact_us']") WebElement contactUsPage;
	@FindBy(xpath ="//input[@name='name']") WebElement nameTextbox;
	@FindBy(xpath ="//input[@name='email']") WebElement emailTextbox;
	@FindBy(xpath="//input[@name='subject']") WebElement subjectTextbox;
	@FindBy(xpath="//textarea[@id='message']") WebElement messageTextBox;
	@FindBy(xpath="//input[@type='file']") WebElement inputFile;
	@FindBy(xpath="//input[@type='submit']") WebElement submit;
	@FindBy(xpath="//div[@class='status alert alert-success']") WebElement uploadSucess;
	
	
	//input[@name='email']
	public void clickContactUs() {
		contactUsPage.click();
		
	}
	
	public void fillDetails(String name,String email,String subject, String msg) {
		
		nameTextbox.sendKeys(name);
		emailTextbox.sendKeys(email);
		subjectTextbox.sendKeys(subject);
		messageTextBox.sendKeys(msg);
	}
	
	public void uploadfile() throws InterruptedException {
		
		String filepath="C:\\Users\\User\\eclipse\\MyStoreV2\\src\\test\\resource\\TestDatatxtfile.txt";
		inputFile.sendKeys(filepath);
		Thread.sleep(2000);
		submit.click();
		ldriver.switchTo().alert().accept();
		
		
	}
	
	public String uploadSucessMsg() {
		
		return uploadSucess.getText();
	}

}
