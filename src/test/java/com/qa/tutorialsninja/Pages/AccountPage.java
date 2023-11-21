package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	public WebDriver driver;

	// we have define all the objects//email
	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	private WebElement myAccount;

	// searchProducts
	@FindBy(xpath = "//input[@name = 'search']")
	private WebElement searchBox;

	// clicking on the search bar
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	// we initialize the objects by creating constractor
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);

	}

	// we have take action on those objects by creating methods
	public boolean getDisplayStatusOfMyAccount() {
		boolean getDisplayStatus = myAccount.isDisplayed();
		return getDisplayStatus;
	}

	public SearchPage navigateToAccountPageSearchBox(String validProductText) {
		searchBox.sendKeys(validProductText);
		searchButton.click();
		return new SearchPage(driver);
	}

}