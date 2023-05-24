//Page Factory Design Pattern used:  https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s (4:48 hr mark)

package com.tutorialsninja.pa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Create Constructor for object of HomePage Class--added to Login Test Cases in the @BeforeMethod
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);   //"this" can also be "HomePage.class", we are initalizing the elements
	}


	//Create Page Factory for Elements on Login Page Test Cases
	
	
	
	//Object- these WebElements are called Objects
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private	WebElement myAccountDropMenu;  // for clicking on Account 
	
	@FindBy(linkText="Login")
	private WebElement loginOption;   //for clicking on Login
	
	@FindBy(linkText="Register")      //for clicking on Register
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	private WebElement searchButton;
	
	
	
	//Create Actions Class Methods of the Objects
	
	
	public void clickOnMyAccount() {
		
		myAccountDropMenu.click();
		
	}
	
	
	public void selectLoginOption() {
		
		loginOption.click();
	}
	
	
	public void selectRegisterOption() {
		
		registerOption.click();
	}
	
	public void enterProductNameToSearchIntoSerachBoxField (String productText) {
		
		searchBoxField.sendKeys(productText);
	}
	
	
	public void clickOnSearchButton() {
		
		searchButton.click();
	}
	
}

