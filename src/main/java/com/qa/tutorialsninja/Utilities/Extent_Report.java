package com.qa.tutorialsninja.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report {

	public static ExtentReports generateExtentReport() throws IOException {

		ExtentReports extentReport = new ExtentReports();

		File extentReportFile = new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results Reports");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp =  new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\qa\\tutorialsninja\\config\\config.properties");
		
		FileInputStream filsConfigProp = new FileInputStream(configPropFile);
		configProp.load(filsConfigProp);
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("User Name", configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("operating system", System.getProperty("os.name"));
		extentReport.setSystemInfo("ops version detail", System.getProperty("os.version"));
		extentReport.setSystemInfo("SDET Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("java version", System.getProperty("java.version"));
		extentReport.setSystemInfo("java vendor", System.getProperty("java.vendor"));
		
	
		return extentReport;
		}


}
