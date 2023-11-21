package com.qa.tutorialsninja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	public WebDriver driver;

	// we have define all the objects//email
	
	@FindBy(xpath = "//a[contains(text(),'iPhone')]")
	private WebElement validProduct;
	
	
	//searchProduct warning messagee
	@FindBy(xpath = "//p[text() = 'There is no product that matches the search criteria.']")
	private WebElement noOrInvalidProductMessage;
	
	//cleak on add to cart.
	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement addToCart;
	
	// verify Success: You have added MacBook Pro to your shopping cart!
	@FindBy(xpath = "//div[contains(@class, 'alert alert-success alert-dismissible')]")
	private WebElement verifyAddToShoppingMessage;
	
	//clicking on iteams
	@FindBy (xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement addTotalNumberOfItem;
	
	@FindBy(xpath = "//strong[normalize-space()='View Cart']")
	private WebElement viewCart;
	
	
	  

	// ------------------------------------------------------------------------------------
	// we initialize the objects by creating constractor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		// we need this for creating page object model.
		PageFactory.initElements(driver, this);
	}

	// we have take action on those objects by creating methods
	public boolean displayStatusValidProduct() {
		boolean displayStatus = validProduct.isDisplayed();
		return displayStatus;
	}
	
	public boolean displayStatusInvalidOrNoProduct() {
		boolean displayStatus = noOrInvalidProductMessage.isDisplayed();
		return displayStatus;
	}
	public void cleckOnAddToCart() {
		addToCart.click();
	}
	public boolean displayAddToShoppingSuccessMessage() {
			boolean displayAddToCartMessage = verifyAddToShoppingMessage.isDisplayed();
			return displayAddToCartMessage;	
	}
	
	public void clickOnItems() {
		addTotalNumberOfItem.click();
	}
	public void clickOnViewCart() {
		viewCart.click();
	}
	public void clickItemsAndOpenCart() {
		addTotalNumberOfItem.click();
	    viewCart.click();
	}
	
}
