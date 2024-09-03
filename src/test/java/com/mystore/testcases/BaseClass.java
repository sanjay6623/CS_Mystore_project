package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	ReadConfig readConfig=new ReadConfig();
	String url=readConfig.getBaseUrl();
	String browser=readConfig.getBrowser();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() {



		switch(browser.toLowerCase()) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
	        options.setAcceptInsecureCerts(true);
			driver=new FirefoxDriver(options);
			break;
			
		case "edge":

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		default:

			driver=null;
			break;


		}
		// implicit wait for 10 seconds.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// for logging log4j2
		logger=LogManager.getLogger(BaseClass.class);
		
		//open url
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		logger.info("Url opened");




	}
	@AfterClass(enabled=true)
	public void tearDown() {

		driver.close();
		driver.quit();
	}
	// Screenshot Capture method created in baseClass
	public void captureScreenShot(WebDriver driver, String testName) throws IOException 
	{
		TakesScreenshot sc=((TakesScreenshot)driver);
		File srcfile=sc.getScreenshotAs(OutputType.FILE);
		File destfile=new File(System.getProperty("user.dir") +"//Screenshots//"  +testName + ".png");
		
			FileUtils.copyFile(srcfile, destfile);
		


	}
	
	



}
