package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutSuccessPage {
	public WebDriver driver;

	// we have define all the objects

	@FindBy(xpath = "//p[contains(text(),'Your order has been successfully processed!')]")
	private WebElement confirmOderSuccessMessage;

	// we initialize the objects by creating constractor

	public CheckoutSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean displayConfirmOderSuccessMessage() {
		boolean displaystatus = confirmOderSuccessMessage.isDisplayed();
		return displaystatus;
	}

}
 