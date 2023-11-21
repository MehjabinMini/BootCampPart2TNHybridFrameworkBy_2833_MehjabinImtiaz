package com.tutorialninja.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialninja.TestBase.Test_Base;
import com.qa.tutorialsninja.Pages.AccountPage;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.LoginPage;
import com.qa.tutorialsninja.Utilities.ExcelCode;
import com.qa.tutorialsninja.Utilities.Utilities;

public class Login_Test extends Test_Base {

	public Login_Test() throws Exception {
		super();

	}

	public WebDriver driver;
	public LandingPage landingpage;
	public LoginPage loginpage;
	public AccountPage accountpage;

	@BeforeMethod
	public void loginSetUp() { 
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		loginpage = landingpage.navigateToLogingPage();
	} 

	@Test(priority = 1, dataProvider = "TN", dataProviderClass = ExcelCode.class)
	public void verifyingLoginWithValidUserNameAndValidPassword(String username, String Password) {
		accountpage = loginpage.navigateToAccoutPage(username, Password);
		//loginpage.userNameField(prop.getProperty("validEmail"));
		//loginpage.passwordField(prop.getProperty("validPassword"));
		//accountpage = loginpage.clickOnLoginButton();// system re-directs to Account Page
		Assert.assertTrue(accountpage.getDisplayStatusOfMyAccount());
	}

	@Test(priority = 2)
	public void verifyLoginWithInValidUserNameAndValidPassword() {
		loginpage.navigateToAccoutPage(Utilities.genaratEmailWithDateTimeStamp(), prop.getProperty("validPassword"));
		//loginpage.userNameField(Utilities.genaratEmailWithDateTimeStamp());
		//loginpage.passwordField(prop.getProperty("validPassword"));
		//loginpage.clickOnLoginButton();
		//String actualWarningMessage = loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText();
		//String expetedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue( loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));
	}

	@Test(priority = 3)
	public void verifyLoginWithValidUserNameAndInValidPassword() {
		loginpage.navigateToAccoutPage(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
		//loginpage.userNameField(prop.getProperty("validEmail"));
		//loginpage.passwordField(dataprop.getProperty("invalidPassword"));
		//loginpage.clickOnLoginButton();
		//String actualWarningMessage = loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText();
		//String expetedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));
	}

	@Test(priority = 4)
	public void verifyLoginWithInValidUserNameAndInValidPassword() {
		loginpage.navigateToAccoutPage(Utilities.genaratEmailWithDateTimeStamp(), dataprop.getProperty("invalidPassword"));
		//loginpage.userNameField(Utilities.genaratEmailWithDateTimeStamp());
		//loginpage.passwordField(dataprop.getProperty("invalidPassword"));
		//loginpage.clickOnLoginButton();

		//String actualWarningMessage = loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText();
		//String expetedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));

	}

	@Test(priority = 5)
	public void verifyLoginWithNoUserNameAndNoPassword() {
		loginpage.clickOnLoginButton();

		//String actualWarningMessage = loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText();
		//String expetedWarningMessage = dataprop.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retrieveUserNamePasswordNotMatchingWarningMessageText().contains(dataprop.getProperty("loginWarningMessage")));
	}

	@AfterMethod
	public void closer() {
		driver.quit();
	}

}