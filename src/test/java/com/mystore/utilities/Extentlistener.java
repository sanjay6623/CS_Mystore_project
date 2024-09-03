package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//com.mystore.utilities.Extentlistener (add into testng.xml file for listner

public class Extentlistener implements ITestListener {
	
	ExtentSparkReporter htmlReporter;
	
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureRerpot() {
		
		ReadConfig readconfig=new ReadConfig();
		String timestamp=new SimpleDateFormat("dd.mm.yyy hh.mm.ss").format(new Date());
		String reportName="AutomationExcercise" +timestamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		 reports=new ExtentReports();
		 reports.attachReporter(htmlReporter);
		 
		 reports.setSystemInfo("User", "sanjay");
		 reports.setSystemInfo("Browser", readconfig.getBrowser());
		 reports.setSystemInfo("Machine", "PC Test1");
		 
		 htmlReporter.config().setDocumentTitle("Automation ExtentListnerReport");
		 htmlReporter.config().setReportName("Automation Excercise");
		 htmlReporter.config().setTheme(Theme.STANDARD);
		
	}

	
	public void onTestStart(ITestResult result) {
		
		System.out.println("OnTestStart method started:   "+result.getName());
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Suucess Mothod started:   "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Sucess test  " + result.getName(), ExtentColor.GREEN));
	
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure Method started:   "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test  " + result.getName(), ExtentColor.RED));
		test.log(Status.FAIL, result.getThrowable());
		
	// screenshot capture
		String screenShotPath=System.getProperty("user.dir") +"\\Screenshots\\" +result.getName() + ".png" ;
		File screenShotfile= new File(screenShotPath);
		if(screenShotfile.exists()) {
			test.fail("Captured Screenshot is below" + test.addScreenCaptureFromPath(screenShotPath));
		}
		
	
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped method started:  "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test  " + result.getName(), ExtentColor.YELLOW));
	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	// execute only once on start of test
	public void onStart(ITestContext context) {
		
		configureRerpot();
		System.out.println("On Start Method started:   "+context.getName());
		
	}

	//execute only once on Finish test
	public void onFinish(ITestContext context) {
		System.out.println("On Finish Method started:  ");
		reports.flush(); // Mandatory to flush to print extent report.
		
	}

	
	
}
