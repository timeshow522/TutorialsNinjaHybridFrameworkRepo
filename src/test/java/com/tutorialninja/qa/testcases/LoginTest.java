// FULL Tutorial :  https://www.youtube.com/watch?v=5OBXZMiuYnY&t=29101s


package com.tutorialninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialsninja.pa.pageobjects.AccountPage;
import com.tutorialsninja.pa.pageobjects.HomePage;
import com.tutorialsninja.pa.pageobjects.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;





public class LoginTest extends Base {
	
	

	
	public WebDriver driver;  //declare globally  //made Public for Extent Report on Failure Method (8:07 hr mark)
	
	
	
	@BeforeMethod
	public void setup()   {
		
	
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
		driver = initializeBrowserAndOpenApplicationURL("chrome");   //located in Base Class
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		
		*/
		
		
					//BEFORE ADDING PAGE FACTORY ABOVE CODE
		
		/*
		//The process above was after removing hard code using config.properties file. 
		loadPropertiesFile();    //Method is in Base Class for config.properties and testdata.properties files or can create Construct for Super in Video (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s)
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		*/
		
		
		
		//Using Page Factory Model (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=29101s     4:48 hr mark)
		
		loadPropertiesFile();    //Method is in Base Class for config.properties and testdata.properties files or can create Construct for Super in Video (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s)
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homePage = new HomePage(driver);   //Created object of Home Page Constructor in HomePage class to allow to call Methods in HomePage class
		homePage.clickOnMyAccount();    	//We removed the hard coding.  This was before we create Page Objects on the HomePage Class 	//driver.findElement(By.xpath("")).click();
		homePage.selectLoginOption();		//We removed the hard coding.  This was before we create Page Objects on the HomePage Class	//driver.findElement(By.linkText("Login")).click();
		
		
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
	}


	
/*
	
		//DATA PROVIDER EXAMPLE
		//Create Data Provider with Hard Coding
	
	
			@DataProvider (name="validCredentialsSupplier")
			public Object[][] supplyTestData() {
				
				//Create Two Dimensional Array for Email and Password Field
				
				Object [][] data = {
						{"amotooricap1@gmail.com","12345"}, 
						{"amotooricap3@gmail.com","12345"},
						{"amotooricap9@gmail.com","12345"}
						
						};
				
				return data;
			}
		
		
		
		//EXCEL Sheet?
	@DataProvider (name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		//Create Two Dimensional Array for Email and Password Field
		
		Object [][] data = Utilities.getTestDataFromExcel("Login");
		return data;
		
	}

	
		
		
		
		

	//Test One with DataProvider
	
		@Test (priority=1, dataProvider="validCredentialsSupplier")  //can also use the method name "supplyTestData" but you need to removed the "(name="validCredentialsSupplier")" 
		public void verifyLoginWithValidCredentialsWithDataProvider(String email, String password) {  //need to parameterize with email and password
		
	
		driver.findElement(By.id("input-email")).sendKeys(email);    	//need to parameterize with email
		driver.findElement(By.id("input-password")).sendKeys(password);  //need to parameterize with password
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit Your Account Information option is not displayed");
		
		
		
	}
	
	
*/
	

	
	
	
	
	//REGULAR TEST CASE START HERE///////////

	
	@Test (priority=1, 	dataProvider="validCredentialsSupplier")
	
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		//With Selenium Java 4.6.0 you don't need write Webdriver manager to specify Chromedriver  (32:00 min mark of video: https://www.youtube.com/watch?v=5OBXZMiuYnY&t=29101s)
		

		//used for Fix Chrome Driver issue for version 4.6.0
		
		
		LoginPage loginPage = new LoginPage(driver);   	//Create object for the LoginPage.class to call Methods in LoginPage class
		
		loginPage.enterEmailAddress(email);            
		loginPage.enterPassword(password);				
		loginPage.clickOnLoginButton();					
		
		AccountPage accountPage = new AccountPage(driver);   				 //Create object for the Page.class to call Methods in LoginPage class
		Assert.assertTrue(accountPage.getDisplayStatusofEditYourAccountInformationOption(),"Edit Your Account Information option is not displayed");   
		

		
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
		/*
		 
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit Your Account Information option is not displayed");
		

		*/
		
	}
	
	@DataProvider (name="validCredentialsSupplier")
	public Object[][] supplyTestData() {
		
		//Create Two Dimensional Array for Email and Password Field
		
		Object [][] data = {
				{"amotooricap1@gmail.com","12345"}, 
				{"amotooricap3@gmail.com","12345"},
				{"amotooricap9@gmail.com","12345"}
				
				};
		
		return data;
	}
	
	

	
	
	
	
	@Test (priority=2)
	public void verifyLoginWithInvalidCredentials()  {
		
		
		LoginPage loginPage = new LoginPage(driver);   	//Create object for the LoginPage.class to call Methods in LoginPage class
		
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());           
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));				 
		loginPage.clickOnLoginButton();                                                 
		
		
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();     		 
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");					
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		
		
		
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
		/* 
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());   		//added generateTimeStamp so that the test case doesn't fail after 5 failed attempts  //Created Static Method in Utilities Class
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));     //Previously was before removing hard coding		//driver.findElement(By.id("input-password")).sendKeys("123457890");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String actualWarningMessage = (driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText());
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");					//String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		*/
		
		
		
	}
	
	
	
	
	
	
		@Test (priority=3)
		public void verifyLoginWithInvalidEmailAndValidPassword() throws InterruptedException {
		
			
		LoginPage loginPage = new LoginPage(driver);     //Create object for the LoginPage.class to call Methods in LoginPage class
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());   
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();     		 
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");					
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		
		
		
			/*
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());   //added generateTimeStamp so that the test case doesn't fail after 5 failed attempts  //Created Static Method in Utilities Class
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword")); //12345
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		
		
		String actualWarningMessage = (driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText());
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");		
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
			 */
		
		
		
	}
	
	
		
		
		
		@Test (priority=4)
		public void verifyLoginWithValidEmailAndInvalidPassword() {
		
			
			
			
		LoginPage loginPage = new LoginPage(driver);     //Create object for the LoginPage.class to call Methods in LoginPage class
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
			
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();     		 
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");					
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		
		
			
			
	
		/*
			
			//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));   //added generateTimeStamp so that the test case doesn't fail after 5 failed attempts
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	
		
		
		String actualWarningMessage = (driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText());
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");	
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		

		*/
	
	
}
	
		
		
		
		@Test(priority=5)
		public void verifyLoginWithoutProvidingCredentials () {
			
		
			
			
			LoginPage loginPage = new LoginPage(driver);     //Create object for the LoginPage.class to call Methods in LoginPage class
			loginPage.clickOnLoginButton();
			

			String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();     		 
			String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");					
			Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
			
			
			
				
			
			
			
			
			/*
			
				//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
			
			driver.findElement(By.id("input-email")).sendKeys("");   //added generateTimeStamp so that the test case doesn't fail after 5 failed attempts  //can also remove these steps
			driver.findElement(By.id("input-password")).sendKeys("");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		
			
			
			String actualWarningMessage = (driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText());
			String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");	
			Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
			
			*/
			
		}
		
		
		
		
		
		//Created Static Method in Utilities Class- Moved below code to Utilites class and made Static
		
/*
	
		//Created Method to add timestamp to the incorrect test cases so it doesn't fail after 5 attempts
		public String generateEmailWithTimeStamp() {
		
		Date date = new Date();
		String timestamp = date.toString().replace(" ","-").replace(":","-");
		return "amotoori"+timestamp+"@gmail.com";
	}
	
	
*/

}
