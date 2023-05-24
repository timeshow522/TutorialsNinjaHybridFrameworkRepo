package com.tutorialsninja.pa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	
	WebDriver driver;
	
	
	//Create Constructor for object of LoginPage Class--added to Login Test Cases in First Test Case
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Create Page Factory for Elements on Register Page Test Cases
	
	//Object- these WebElements are called Objects
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement  emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyConfirmField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement yesNewsletterOption;
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarning;
	
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarning;
	
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneWarning;
	
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	
	//Create Actions Class Methods of the objects
	
	
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
		
	}
	
	public void enterLastName(String lastNameText) {
	
		lastNameField.sendKeys(lastNameText);
		
	}
	
	
	public void enterEmailAddress (String emailText) {
		
		emailField.sendKeys(emailText);
		
	}
	
	
	public void enterTelephoneNumber (String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
	}
	

	public void enterPassword (String passwordText) {
		
		passwordField.sendKeys(passwordText);
	}


	public void enterConfirmPassword(String passwordText) {
		passwordConfirmField.sendKeys(passwordText);
	}

	public void selectPrivacyPolicy() {
		
		privacyConfirmField.click();
	}
	
	public void clickOnContinueButton() {
		
		continueButton.click();
	}
	
	
	public void selectYesNewsletterOption() {
		
		yesNewsletterOption.click();
	}
	
	
	public String retrievePolicyWarning() {
		
		String privacyPolicyWarningText= privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String firstNameWarning() {
	
		String firstNameWarningText= firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String lastNameWarning() {
		
		String lastNameWarningText= lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	
	public String emailWarning() {
		
		String emailWarningText= emailWarning.getText();
		return emailWarningText;
	}
	
	public String telephoneWarning() {
		
		String telephoneWarningText= telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String passwordWarning() {
		
		String passwordWarningText= passwordWarning.getText();
		return passwordWarningText;
	}
	
	
	
	
	
	
}
	

