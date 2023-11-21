package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	// we have define all the objects//email
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div [@ class= 'alert alert-danger alert-dismissible']")
	private WebElement userNamePasswordNotMatchingWarningMessage;

	// we initialize the objects by creating constractor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects by creating methods
	public void userNameField(String userNameText) {
		userNameField.sendKeys(userNameText);
	}

	public void passwordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}

	public AccountPage navigateToAccoutPage(String userNameText, String passwordText) {
		userNameField.sendKeys(userNameText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}

	public String retrieveUserNamePasswordNotMatchingWarningMessageText() {
			String warningText = userNamePasswordNotMatchingWarningMessage.getText();
			return warningText;
		}
}
