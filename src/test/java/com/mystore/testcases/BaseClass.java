package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	ReadConfig readConfig=new ReadConfig();
	String url=readConfig.getBaseUrl();
	String browser=readConfig.getBrowser();
	ChromeOptions options;

	public static WebDriver driver;
	public static Logger logger;
	

	@BeforeMethod(groups="SmokeTest")
	public void setup() {

		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			options = new ChromeOptions();
	        //options.addArguments("--disable-popup-blocking");
	       // options.addArguments("--disable-notifications");
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.default_content_setting_values.notifications", 2); // Disable notifications
	        prefs.put("profile.default_content_setting_values.popups", 2); // Disable pop-ups
	        options.setExperimentalOption("prefs", prefs);
	        
	       options.addArguments("--headless");
	      driver = new ChromeDriver(options);
			
		
			
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
		
			
		}
		else if(browser.equals("edge")){
			WebDriverManager.edgedriver().setup();			
			driver = new EdgeDriver();
			
			
		}
		else {
			
			driver=null;
			throw new RuntimeException("Browser not given or null:  ");
			
		}
		

		/*
		 * switch(browser.toLowerCase()) {
		 * 
		 * case "chrome": WebDriverManager.chromedriver().setup(); driver=new
		 * ChromeDriver(); break; case "firefox":
		 * 
		 * WebDriverManager.firefoxdriver().setup(); FirefoxOptions options = new
		 * FirefoxOptions(); options.setAcceptInsecureCerts(true); driver=new
		 * FirefoxDriver(options); break;
		 * 
		 * case "edge":
		 * 
		 * WebDriverManager.edgedriver().setup(); driver=new EdgeDriver(); break;
		 * default:
		 * 
		 * driver=null; break;
		 */

		
		// implicit wait for 10 seconds.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// for logging log4j2
		logger=LogManager.getLogger(BaseClass.class);
		
		//open url
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		logger.info("Url opened");
		




	}
	@AfterMethod(groups="SmokeTest")
	public void tearDown() {
		logger.info("Browser closed:  ");
		//driver.close();
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
