package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	public WebDriver driver;
	
	
	// we have define all the objects//email
	@FindBy(name = "payment_address")
	private WebElement billingDetails;
	
	//clicking on 
	@FindBy(id = "button-payment-address")
	private WebElement continueOnBillingDetails;
	 
	@FindBy(name= "shipping_address")
	private WebElement delivaryDetails;
	
	@FindBy(xpath = "//input[@id='button-shipping-address']")
	private WebElement continueOnDelivaryDetails;
	
	@FindBy(xpath = "//input[@id='button-shipping-method']")
	private WebElement delivaryMethodContinueButton;
	
	
	@FindBy(name="agree")
	private WebElement privacyPolicyRadioButton;
	
	@FindBy(xpath ="//input[@id='button-payment-method']")
	private WebElement paymentMethodContinueButton;
	
	@FindBy(id="button-confirm")
	private WebElement confirmOderButton;
	
	
	//we initialize the objects by creating constructor 
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	
	//we have take action on those objects by creating methods
	public void clickOnIWantToUseAnExistingAddress() {
		billingDetails.click();
	}
	public void clickOnContinueButton() {
		continueOnBillingDetails.click();
	}
	
	public void clickOnIWantToUseAnExistingAddressOnDelivaryDetails() {
		delivaryDetails.click();
	}
	
	public void clickOnContinueOnDelivaryButton() {
		continueOnDelivaryDetails.click();
	}
	public void clickOnDelivaryMethodContinueButton() {
		delivaryMethodContinueButton.click();
	}
	public void clickOnPrivacyPolicyRadioButton() {
		privacyPolicyRadioButton.click();
	}
	public void clickOnPaymentMethodContinueButton() {
		paymentMethodContinueButton.click();
	}
	public void clickOnConfirmOderButton() {
		confirmOderButton.click();
	}
	public void completeCheckoutProcess() {
		billingDetails.click();
		continueOnBillingDetails.click();
		delivaryDetails.click();	
		continueOnDelivaryDetails.click();
		delivaryMethodContinueButton.click();
		privacyPolicyRadioButton.click();
		paymentMethodContinueButton.click();
		confirmOderButton.click();
	}
	

} 
