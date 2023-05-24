package com.tutorialsninja.pa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

	
	
	WebDriver driver;
	
	
	//Create Constructor for object of LoginPage Class--added to Login Test Cases in First Test Case
	
	public AccountSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Create Page Factory for Elements on Register Page Test Cases
	
	//Object- these WebElements are called Objects
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement accountSuccessPageHeading;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailAddressWarning;
	
	
	
	
	//Create Actions Class Methods of the objects
	
	
	public String retrieveAccountSuccessPageHeading() {
		
		String accountSuccessPageHeadingText = accountSuccessPageHeading.getText();
		return accountSuccessPageHeadingText;
	}
	
		
		public String retrieveDuplicateEmailAddressWarning() {
			
			String duplicateEmailWarningText= duplicateEmailAddressWarning.getText();
			return duplicateEmailWarningText;
		
		}
	
}

	
	