package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	//searchProducts
	@FindBy(xpath = "//input[@name = 'search']")
	private WebElement searchBox;
	
	//clicking on the search bar
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	// we have define all the objects
	@FindBy(linkText="My Account")
	private WebElement MyAccountDropDown;
	
	//clicking on the login
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	//clicking on the register
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
		
	// we initialize the objects
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    // we have take action on those objects 
	public void clickOnMyAccountDropDown() {
		MyAccountDropDown.click();
	}
	
	//returning new login page by clicking on the selectLoginOption in the landing page
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	public RegisterPage selectRegisterOption() {
		RegisterOption.click();
		return new RegisterPage(driver);
	}
	
	public LoginPage navigateToLogingPage() {
		MyAccountDropDown.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	public void enterProductNameInSearchBox(String validProductText) {
		searchBox.sendKeys(validProductText);
	}
	
	
	//clicking on the search bar
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	public SearchPage navigateToSearchPage(String validProductText) {
		searchBox.sendKeys(validProductText);
		searchButton.click();
		return new SearchPage(driver);
	}

	

}


