
//Override:  click on Source-->Override/Implement Methods... and selct the overrides
//Need to change the POM.XML file for the TestNG dependecy from <scope>test</scope> to <scope>compile</scope>

//THE EXTENT REPORT LISTENER IS NOT WORKING along with ExtentReporter class


package com.tutorialsninja.qa.listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;

public class MyListeners implements ITestListener {

	
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	public void onStart(ITestResult result) {

		extentReport = ExtentReporter.generateExtentReport();
	}
	
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+" started executing");
		
	}
		
	
		
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extentTest.log(Status.PASS,testName+" got successfully executed");
	
			
		}
	
		
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
			
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\" + testName+".png";  
		
		try {
		FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e ) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,testName+" got failed");
	}


	public void onTestSkipped(ITestResult result) {
		String testName = result.getName();
		
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, testName+" got skipped");
	
		
	}


	public void onFinish(ITestContext context) {
	
			extentReport.flush();
			
			/*
			String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
			File extentReport = new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
*/
	}

	
}
