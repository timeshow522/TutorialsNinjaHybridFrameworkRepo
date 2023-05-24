package com.tutorialninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.tutorialninja.qa.base.Base;
import com.tutorialsninja.pa.pageobjects.AccountSuccessPage;
import com.tutorialsninja.pa.pageobjects.HomePage;
import com.tutorialsninja.pa.pageobjects.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base  {
	
	
	
	public WebDriver driver;  ;  //declare globally  //made Public for Extent Report on Failure Method (8:07 hr mark)
	
	
	
	
	@BeforeMethod
	public void setup() {
	
		
		//Moved the below code to Base Class
	/*  
		String browserName = "chrome";
		
		
		if(browserName.equals("chrome")) {
	
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(opt);
	
			
		} else if(browserName.equals("firefox")) {
			
				driver = new FirefoxDriver();
			
				
		} else if(browserName.equals("edge")) {
			
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver= new EdgeDriver(opt);
	
			
	
		} else if(browserName.equals("safari")) {
	 
				driver = new SafariDriver();
		}

		
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	
		driver.get("http://tutorialsninja.com/demo/");
		
		
		*/
		
		
		/*
		
		//This will need to be Hard Codes into the Properties File.  This is before hard coding
		driver = initializeBrowserAndOpenApplicationURL("chrome");
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		*/
		
		
		
		//BEFORE ADDING PAGE FACTORY ABOVE CODE
		
		/*
		//The process above was after removing hard code using config.properties file.
		loadPropertiesFile();  //Method is in Base Class for config.properties and testdata.properties files or can create Construct for Super in Video (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s)
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		*/
		
		
		//Using Page Factory Model (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=29101s     4:48 hr mark)
		
		loadPropertiesFile();    //Method is in Base Class for config.properties and testdata.properties files or can create Construct for Super in Video (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s)
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
				
		HomePage homePage = new HomePage(driver);   //Created object of Home Page Constructor in HomePage class to allow to call Methods in HomePage class
		homePage.clickOnMyAccount();    	//We removed the hard coding.  This was before we create Page Objects on the HomePage Class 	//driver.findElement(By.xpath("")).click();
		homePage.selectRegisterOption();		//We removed the hard coding.  This was before we create Page Objects on the HomePage Class	//driver.findElement(By.linkText("Login")).click();
				
				
		
		
		
		
		
	}
	
	
	
	
	@AfterMethod
	public void teardown () {
		
		driver.quit();
		
		
	}
	
	
	
	@Test (priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
		

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicy();
		registerPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);   //Create Object for Account Success Page
		String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();  //This will get the Heading
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Sucess page is not displayed");               //Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!","Account Sucess page is not displayed");

		
		
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
				/*
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));  			//Previously before removing hard coding in testdata.properties file		 //driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));       		 //Previously before removing hard coding in testdata.properties file         //driver.findElement(By.id("input-lastname")).sendKeys("Matoori");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());   		//Previously before removing hard coding in testdata.properties file			//Created Static Method in Utilities Class so it can automatically create new emails
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));		//Previously before removing hard coding in testdata.properties file	//driver.findElement(By.id("input-telephone")).sendKeys("123456789");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String actualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Sucess page is not displayed");               //Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!","Account Sucess page is not displayed");
		
		*/
		
		
	}
	
	@Test (priority=2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicy();
		registerPage.selectYesNewsletterOption();
		registerPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);   //Create Object for Account Success Page
		String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();  //This will get the Heading
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Sucess page is not displayed");               //Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!","Account Sucess page is not displayed");

		
		
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
		/*
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));  			//Previously before removing hard coding in testdata.properties file		 //driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));       		 //Previously before removing hard coding in testdata.properties file         //driver.findElement(By.id("input-lastname")).sendKeys("Matoori");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());   //Created Static Method in Utilities Class so it can automatically create new emails
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));		//Previously before removing hard coding in testdata.properties file	//driver.findElement(By.id("input-telephone")).sendKeys("123456789");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		
		String actualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		
		Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"),"Account Sucess page is not displayed");               //Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!","Account Sucess page is not displayed");
		
		*/
	
		
		
	}
	
	
	
		@Test (priority=3)
		public void verifyRegisteringAccountWithExistingEmailAddress() {
			
			
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.enterFirstName(dataProp.getProperty("firstName"));
			registerPage.enterLastName(dataProp.getProperty("lastName"));
			registerPage.enterEmailAddress(prop.getProperty("validEmail"));    //Enter Valid Email Address
			registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
			registerPage.enterPassword(prop.getProperty("validPassword"));
			registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
			registerPage.selectPrivacyPolicy();
			registerPage.selectYesNewsletterOption();
			registerPage.clickOnContinueButton();
			
			AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);   //Create Object for Account Success Page
		
			String actualWarning = accountSuccessPage.retrieveDuplicateEmailAddressWarning();
			Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message regarding duplicate email address is not displayed");			//Previously before removing hard coding in testdata.properties file  //Assert.assertTrue(actualWarning.contains("Warning: E-Mail Address is already registered!"),"Warning message regarding duplicate email address is not displayed");
			
			
	
			
			
			//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
			
			/*
			driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));  			//Previously before removing hard coding in testdata.properties file		 //driver.findElement(By.id("input-firstname")).sendKeys("Arun");
			driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));       		 //Previously before removing hard coding in testdata.properties file         //driver.findElement(By.id("input-lastname")).sendKeys("Matoori");
			driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail")); 
			driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));		//Previously before removing hard coding in testdata.properties file	//driver.findElement(By.id("input-telephone")).sendKeys("123456789");
			driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
			driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			String actualWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
			Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")),"Warning message regarding duplicate email address is not displayed");			//Previously before removing hard coding in testdata.properties file  //Assert.assertTrue(actualWarning.contains("Warning: E-Mail Address is already registered!"),"Warning message regarding duplicate email address is not displayed");
			*/
		
			
			
		}

		@Test(priority=4)
		public void verifyRegisteringAccountWithoutFillingAnyDetails() {
			
			
			
			
			
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.clickOnContinueButton();
			registerPage.retrievePolicyWarning();
			registerPage.firstNameWarning();
			registerPage.lastNameWarning();
			registerPage.emailWarning();
			registerPage.telephoneWarning();
			registerPage.passwordWarning();
			
			
			
			
			
			
			
			//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
			
			/*
	
			
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
			Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")),"Privacy Policy Warning message is not displayed");					//Previously before removing hard coding in testdata.properties file  //Assert.assertTrue(actualPrivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"Privacy Polciy Warning message is not displayed");
			
			String actualFirstNameWarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
			Assert.assertEquals(actualFirstNameWarning, dataProp.getProperty("firstNameWarning"),"First Name Warning Message is not displayed");					//Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualFirstNameWarning, "First Name must be between 1 and 32 characters!","First Name Warning Message is not displayed");
			
			String actualLastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
			Assert.assertEquals(actualLastNameWarning, dataProp.getProperty("lastNameWarning"),"Last Name Warning Message is not displayed");					//Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualLastNameWarning, "Las Name must be between 1 and 32 characters!","Last Name Warning Message is not displayed");
			
			String actualEmailNameWarning = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
			Assert.assertEquals(actualEmailNameWarning, dataProp.getProperty("emailWarning"),"Email Warning Message is not displayed");							//Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualEmailNameWarning, "E-Mail Address does not appear to be valid!","Email Warning Message is not displayed");
			
			String actualTelephoneNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
			Assert.assertEquals(actualTelephoneNameWarning, dataProp.getProperty("telephoneWarning"),"Telephone Warning Message is not displayed");					//Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualTelephoneNameWarning, "Telephone must be between 3 and 32 characters!","Telephone Warning Message is not displayed");
			
			String actualPasswordWarning = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
			Assert.assertEquals(actualPasswordWarning, dataProp.getProperty("passwordWarning"),"Password Warning Message is not displayed");						//Previously before removing hard coding in testdata.properties file //Assert.assertEquals(actualPasswordWarning, "Password must be between 4 and 20 characters!","Password Warning Message is not displayed");
			
			*/
		
			
			
		}
		

}
