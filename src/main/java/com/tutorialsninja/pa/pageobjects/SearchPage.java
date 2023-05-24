package com.tutorialsninja.pa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	
WebDriver driver;
	
	//Create Constructor for object of HomePage Class--added to Login Test Cases in the @BeforeMethod
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);   //"this" can also be "HomePage.class", we are initalizing the elements
	}


	//Create Page Factory for Elements on Login Page Test Cases
	
	
	
	//Object- these WebElements are called Objects
	
	@FindBy(linkText="HP LP3065")
	private	WebElement validHPProduct;  
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noProductMessage;
	
	
	//Create Actions Class Methods of the Objects
	
	public boolean displayStatusofHpValidProduct() {
		boolean displayStatus=validHPProduct.isDisplayed();
		return displayStatus;
	}
	
	public String retrieveNoProductMessageTest() {
		String noProductMessageText= noProductMessage.getText();
		return noProductMessageText;
	}
		
}


