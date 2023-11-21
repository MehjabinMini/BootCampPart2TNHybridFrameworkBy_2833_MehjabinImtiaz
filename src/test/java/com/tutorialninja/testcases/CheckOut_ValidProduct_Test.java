package com.tutorialninja.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.tutorialninja.TestBase.Test_Base;
import com.qa.tutorialsninja.Pages.AccountPage;
import com.qa.tutorialsninja.Pages.AccountSuccessPage;
import com.qa.tutorialsninja.Pages.CheckOutPage;
import com.qa.tutorialsninja.Pages.CheckoutSuccessPage;
import com.qa.tutorialsninja.Pages.LandingPage;
import com.qa.tutorialsninja.Pages.LoginPage;
import com.qa.tutorialsninja.Pages.SearchPage;
import com.qa.tutorialsninja.Pages.ShoppingCartPage;

public class CheckOut_ValidProduct_Test extends Test_Base {

	public CheckOut_ValidProduct_Test() throws Exception {
		super();

	}

	public WebDriver driver;
	public LandingPage landingpage;
	public LoginPage loginpage;
	public SearchPage searchpage;
	public AccountSuccessPage accountsuccesspage;
	public ShoppingCartPage shoppingcart;
	public CheckOutPage checkoutpage;
	public AccountPage accountpage;
	public CheckoutSuccessPage checkoutsuccesspage;
	
	

	@BeforeMethod 
	public void check_ValidProduct_setUP() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingpage = new LandingPage(driver);
		searchpage = new SearchPage(driver);
		shoppingcart = new ShoppingCartPage(driver);
		checkoutpage = new CheckOutPage(driver);
		checkoutsuccesspage = new CheckoutSuccessPage(driver);
		loginpage = landingpage.navigateToLogingPage();
		accountpage = loginpage.navigateToAccoutPage(prop.getProperty("validEmail"),prop.getProperty("validPassword"));

	}

	@Test(priority = 1)
	public void addAValidProductAndCheckOut() throws Exception {
		
		accountpage.navigateToAccountPageSearchBox(dataprop.getProperty("validCheckOutProduct"));
		accountsuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountsuccesspage.validProductdisplayMessage());
		
		searchpage.cleckOnAddToCart(); 
		Assert.assertTrue(searchpage.displayAddToShoppingSuccessMessage());
		searchpage.clickItemsAndOpenCart();
		
		checkoutpage = shoppingcart.clickOnEstimateShippinAndTaxesAndCheckOutButton();
		checkoutpage.completeCheckoutProcess();
		
		
		/*checkoutpage.clickOnIWantToUseAnExistingAddress();
		checkoutpage.clickOnContinueButton();
		checkoutpage.clickOnIWantToUseAnExistingAddressOnDelevaryDetailts();

		checkoutpage.clickOnContinueOnDelevaryButton();

		checkoutpage.clickOnDelivaryMethodContinueButton();
		
		checkoutpage.clickOnPrivacyPolicyRadioButton();
	
		checkoutpage.clickOnPaymentMethodContinueButton();
		checkoutpage.clickOnConfirmOderButton();
		
		checkoutpage.completeCheckoutProcess();
		*/
		Assert.assertTrue(checkoutsuccesspage.displayConfirmOderSuccessMessage());

	} 

	@AfterMethod
	public void closer() {
		driver.quit();

	}
}
