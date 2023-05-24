package com.tutorialsninja.pa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	
	//Create Constructor for object of LoginPage Class--added to Login Test Cases in First Test Case
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Create Page Factory for Elements on Account Page Test Cases
	
	//Object- these WebElements are called Objects
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	

	
	//Create Actions Class Methods of the objects
	
	public boolean getDisplayStatusofEditYourAccountInformationOption() {
		
		boolean displayStatus= editYourAccountInformationOption.isDisplayed();   //adding boolean for True/False
		return displayStatus;
	}
	
	
	
}
	
	


