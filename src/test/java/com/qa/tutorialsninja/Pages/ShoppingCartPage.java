package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class ShoppingCartPage {
	
	public WebDriver driver;
	
	// we have define all the objects//email
	//clicking estimateShippinAndTaxes
	@FindBy(xpath = "//a[normalize-space()='Estimate Shipping & Taxes']")
	private WebElement estimateShippinAndTaxes;
	
	//click on the chcekout
	@FindBy (linkText = "Checkout")
	private WebElement CheckoutButton;
	
	
	
	
	
	
	
	// we initialize the objects by creating constractor
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver ;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}
	
	
	// we have take action on those objects by creating methods
	public CheckOutPage clickOnEstimateShippinAndTaxesAndCheckOutButton() {
		estimateShippinAndTaxes.click();
		CheckoutButton.click();
		return new CheckOutPage(driver);
	}
	public void clickOnCheckOutButton(){
		CheckoutButton.click(); 
		
	
	}
 
	
}
