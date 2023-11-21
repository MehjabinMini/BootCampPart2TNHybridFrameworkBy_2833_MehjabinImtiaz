package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.tutorialsninja.Utilities.Extent_Report;
import com.qa.tutorialsninja.Utilities.Utilities;

public class MyListeners implements ITestListener{
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project Execution Started");
		try {
		 extentReport = Extent_Report.generateExtentReport();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO, testName+"started executing");
		System.out.println("TestCase"+ testName+ "started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		extentTest.log(Status.PASS, testName +"got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}

		String destatinationScreenshotPath = Utilities.captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destatinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + "got failed");
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+" got skiped");
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Project Execution Ends");
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
 }
	
	
	


