package com.tutorialsninja.pa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	
	//Create Constructor for object of LoginPage Class--added to Login Test Cases in First Test Case
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Create Page Factory for Elements on Login Page Test Cases
	
	
	
	//Object- these WebElements are called Objects
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement emailPasswordNotMatchingWarning;
	
	
	
	
	
	//Create Actions Class Methods of the objects
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);
	}
	
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
	}

	
	public void clickOnLoginButton () {
		
		loginButton.click();
	}
	
	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		
		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;
	}
	
}
