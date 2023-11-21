package com.tutorialninja.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialninja.TestBase.Test_Base;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.SearchPage;

public class SearchTest extends Test_Base {
	
	public SearchTest() throws Exception {
		super(); 
		
	}

	public WebDriver driver;
	public LandingPage landingpage;
	public SearchPage searchpage;
	@BeforeMethod
	public void Search_Product_setUP() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
	}

	@Test(priority = 1) 
	public void searchProductWithValidProduct() {
		
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("validProduct"));
		Assert.assertTrue(searchpage.displayStatusValidProduct());
	}
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("invalidProduct"));
		Assert.assertTrue(searchpage.displayStatusInvalidOrNoProduct());
	}
	@Test(priority = 3)
	public void verifySearchWithNoProduct() {
		searchpage = landingpage.clickOnSearchButton();
		Assert.assertTrue(searchpage.displayStatusInvalidOrNoProduct());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
