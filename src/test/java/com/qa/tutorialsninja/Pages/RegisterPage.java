package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	
	// we have define all the objects//email
	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;
	
	@FindBy (xpath="//input[@name='newsletter' and @value='1']")
	private WebElement newsletterRadiobutton;
	
	
	@FindBy (xpath="//input[@name='agree']")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy (xpath="//input[@class='btn btn-primary']")
	private WebElement continueButton;
	
	//warning message
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement policyWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailWarningMessage;
	
	//------------------------------------------------------------------------------------
	// we initialize the objects by creating constractor
	public  RegisterPage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}
	//------------------------------------------------------------------------------------

	// we have take action on those objects by creating methods
	public void enterFirstName(String firstNameText) {
		firstNameTextBox.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameTextBox.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneText) {
		telephoneTextBox.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
	}
	
	public void clickNewsletterRadioButton() {
		newsletterRadiobutton.click();
	}
	
	public void checkPrivacyPolicy() {
		privacyPolicyCheckbox.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
		
	}
	//warning message methods

	
	public String retrieveTextofPrivacyPolicyWarningMessage() {
		String privacyPolicyWarning = policyWarningMessage.getText();
		return privacyPolicyWarning;
	}
	
	public String retrievefirstNameWarningMessage() {
		String firstnameWarning = firstNameWarningMessage.getText();
		return firstnameWarning;
	}
	
	public String retrievelastNameWarningMessage() {
		String lastnameWarning = lastNameWarningMessage.getText();
		return lastnameWarning;
	}
	
	public String retrieveEmailWarningMessage() {
		String emailWarning = emailWarningMessage.getText();
		return emailWarning;
	}
	
	public String retrieveTelephoneWarningMessage() {
		String telephoneWarning = telephoneWarningMessage.getText();
		return telephoneWarning;
	}
	
	public String retrievePasswordWarningMessage() {
		String passwordWarning = passwordWarningMessage.getText();
		return passwordWarning;
	}

	public String retrieveTextofDuplicateEmail() {
		String duplicateEmail = duplicateEmailWarningMessage.getText();
		return duplicateEmail;
	}
	
	public AccountSuccessPage registerPageMendatoryFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText,String confirmPasswordText) {
		firstNameTextBox.sendKeys(firstNameText);
		lastNameTextBox.sendKeys(lastNameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
		privacyPolicyCheckbox.click();
		continueButton.click();
	
		return new AccountSuccessPage(driver);
	}	
	public AccountSuccessPage registerPageAllFileds(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText,String confirmPasswordText) {
		firstNameTextBox.sendKeys(firstNameText);
		lastNameTextBox.sendKeys(lastNameText);
		emailTextBox.sendKeys(emailText);
		telephoneTextBox.sendKeys(telephoneText);
		passwordTextBox.sendKeys(passwordText);
		confirmPasswordTextBox.sendKeys(confirmPasswordText);
		newsletterRadiobutton.click();
		privacyPolicyCheckbox.click();
		continueButton.click();
	
		return new AccountSuccessPage(driver);
	}
public boolean retrieveAllWarningMessagesStatus(String expectedPrivacyPolicyWarning, String expectedFirstNameWarning, String expectedLastnameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning) {
		
		boolean privacyPolicyWarningStatus = policyWarningMessage.getText().contains(expectedPrivacyPolicyWarning);
		boolean firstNameWarningStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarning);
		boolean lastNameWarningStatus = lastNameWarningMessage.getText().contains(expectedLastnameWarning);
		boolean emailWarningStatus = emailWarningMessage.getText().contains(expectedEmailWarning);
		boolean telephoneWarningStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarning);
		boolean passwordWarningStatus = passwordWarningMessage.getText().contains(expectedPasswordWarning);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus &&
				passwordWarningStatus;
	}
	
}
