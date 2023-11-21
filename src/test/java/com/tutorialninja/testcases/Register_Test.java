package com.tutorialninja.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialninja.TestBase.Test_Base;
import com.qa.tutorialsninja.Pages.AccountSuccessPage;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.RegisterPage;
import com.qa.tutorialsninja.Utilities.Utilities;

public class Register_Test extends Test_Base {
	public Register_Test() throws Exception {
		super();

	}

	public WebDriver driver;
	public LandingPage landingpage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;

	@BeforeMethod
	public void registerSetUp() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		landingpage.clickOnMyAccountDropDown();
		registerpage = landingpage.selectRegisterOption();

	}

	@Test(priority = 1)
	public void registerAccountWithRequiredFields() {
		accountsuccesspage = registerpage.registerPageMendatoryFields(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), Utilities.genaratEmailWithDateTimeStamp(),
				dataprop.getProperty("telephone"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));

		Assert.assertTrue(accountsuccesspage.displayStatusOfYourAccountHasBeenCreatedMessage());
	}

	@Test(priority = 2)
	public void registerAccountWithAllFields() {

		accountsuccesspage = registerpage.registerPageAllFileds(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), Utilities.genaratEmailWithDateTimeStamp(),
				dataprop.getProperty("telephone"), prop.getProperty("validPassword"),
				prop.getProperty("validPassword"));

		Assert.assertTrue(accountsuccesspage.displayStatusOfYourAccountHasBeenCreatedMessage());

	}

	@Test(priority = 3)
	public void registerAccountWithNoFields() {

		registerpage.clickOnContinueButton();

		Assert.assertTrue(registerpage.retrieveAllWarningMessagesStatus(dataprop.getProperty("policyWarningMessage"),
				dataprop.getProperty("firstNameWarningMessage"), dataprop.getProperty("lastNameWarningMessage"),
				dataprop.getProperty("emailWarningMessage"), dataprop.getProperty("telephoneWarningMessage"),
				dataprop.getProperty("passwordWarningMessage")));

	}

	@Test(priority = 4)
	public void verifyRegisterWithDuplicateUserName() {

		accountsuccesspage = registerpage.registerPageAllFileds(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), prop.getProperty("validEmail"), dataprop.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		Assert.assertTrue(
				registerpage.retrieveTextofDuplicateEmail().contains(dataprop.getProperty("emailExistWarningMessage")));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
