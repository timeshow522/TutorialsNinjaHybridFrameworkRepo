package com.tutorialninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialsninja.pa.pageobjects.HomePage;
import com.tutorialsninja.pa.pageobjects.SearchPage;

public class SearchTest extends Base{
	
	

	public SearchTest() {
		super();
	}
	
	public WebDriver driver;  ;  //declare globally  //made Public for Extent Report on Failure Method (8:07 hr mark)
	
	
	
	
	@BeforeMethod
	public void setup () {
		
		/*
		//This will need to be Hard Codes into the Properties File.  This is before hard coding
		driver = initializeBrowserAndOpenApplicationURL("chrome");
		*/
		
		
		//The process above was after removing hard code using config.properties file.
	
		loadPropertiesFile();   //Method is in Base Class for config.properties and testdata.properties files or can create Construct for Super in Video (https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

		
	
		
	

	@Test (priority=1)
	public void verifySearchWithValidProduct () {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.enterProductNameToSearchIntoSerachBoxField(dataProp.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.displayStatusofHpValidProduct();
		
		
		
	
		
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
		/*
		 
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));				//Previously before removing hard coding in testdata.properties file		// driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());		
		*/
		
	}
	
	
	
	@Test (priority=2)
	public void verifySearchWithInvalidProduct () {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterProductNameToSearchIntoSerachBoxField(dataProp.getProperty("invalidProduct"));
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.retrieveNoProductMessageTest();

		
		
		
		
		
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
		/*
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));   	//Previously before removing hard coding in testdata.properties file   //		driver.findElement(By.name("search")).sendKeys("Honda"); 
		
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String actualSearchMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductTextInSearchResults"),"No Product message in serach results is not displayed");   //Previously before removing hard coding in testdata.properties file   //		Assert.assertEquals(actualSearchMessage,"There is no product that matches the search criteria.","No Product message in serach results is not displayed"); 	
		
		*/
		
		
	}
	
	@Test (priority=3,dependsOnMethods="verifySearchWithInvalidProduct")   //Can add dependsonMethods (7:32 hr mark- https://www.youtube.com/watch?v=5OBXZMiuYnY&t=29101s)
	public void verifySearchWithoutAnyProduct() {
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		searchPage.retrieveNoProductMessageTest();
		
		//BEFORE ADDING PAGE FACTORY FOR THE WEB ELEMENTS ABOVE CODE
		
			/*
		
		driver.findElement(By.name("search")).sendKeys("");
		
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String actualSearchMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText();
		Assert.assertEquals(actualSearchMessage,dataProp.getProperty("noProductTextInSearchResults"),"No Product message in serach results is not displayed");   //Previously before removing hard coding in testdata.properties file   //		Assert.assertEquals(actualSearchMessage,"There is no product that matches the search criteria.","No Product message in serach results is not displayed"); 	
		*/
		
	}
	
	

}
