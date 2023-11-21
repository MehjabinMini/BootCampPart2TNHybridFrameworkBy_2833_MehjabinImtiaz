package com.qa.tutorialsninja.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static String genaratEmailWithDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");

		return "seleniumpanda" + timeStamp + "@gmail.com";
	}

	public static final int IMPLICIT_WAIT = 20;
	public static final int PAGE_LOAD_TIME = 100;
	public static final int SCRIPT_TIME = 1000;

	public static String captureScreenshot(WebDriver driver, String testName) {

		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destatinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";

		try {
			FileHandler.copy(srcScreenshot, new File(destatinationScreenshotPath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return destatinationScreenshotPath;
	}
}