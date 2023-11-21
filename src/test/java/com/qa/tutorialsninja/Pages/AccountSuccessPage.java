package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	public WebDriver driver;

	// we have define all the objects//email
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement yourAccountHasBeenCreatedMessage;
	
	@FindBy(linkText = "MacBook Pro")
	private WebElement validProductMessage;
		
	// we initialize the objects by creating constractor
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects by creating methods
	public boolean displayStatusOfYourAccountHasBeenCreatedMessage() {
		boolean displayStatus1 = yourAccountHasBeenCreatedMessage.isDisplayed();
		return displayStatus1;
	}
		
	public boolean validProductdisplayMessage() {
		boolean displayStatus2 = validProductMessage.isDisplayed();
		return displayStatus2;
	}
 
}
