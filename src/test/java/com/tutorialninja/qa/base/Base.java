package com.tutorialninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	
	
	//Load the config.properties
		public void loadPropertiesFile () {
		
		
			
		//config.properties file setup
			
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
			
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
			
		} catch(Throwable e) {
			e.printStackTrace();
			
			}
		
		
		
		//testdata.properties file setup  --  https://www.youtube.com/watch?v=5OBXZMiuYnY&t=4243s    (3:50 hr mark)
		
		dataProp = new Properties();   //object for data properties
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
	
		try {
			
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
	
		} catch(Throwable e) {
			e.printStackTrace();
			
			}
		
	}
		
		
		
		
	//Setup Browser Method
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			//used for Fix Chrome Driver issue for version 4.6.0
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(opt);
	
			
		} else if(browserName.equalsIgnoreCase("firefox")) {
			
				driver = new FirefoxDriver();
			
				
		} else if(browserName.equalsIgnoreCase("edge")) {
			
			EdgeOptions opt=new EdgeOptions();
			opt.addArguments("--remote-allow-origins=*");
			driver= new EdgeDriver(opt);
	
			
	
		} else if(browserName.equalsIgnoreCase("safari")) {
	 
				driver = new SafariDriver();
}


		
		
		
		
		
		//Maximize, Delete Cookies, ImplicitlyWait and Page Load time steps in Base class


			driver.manage().window().maximize();	
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));      --Tried to used Utilties method to remvoe hard code but didn't work 
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 		    //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));	      		 --Tried to used Utilties method to remvoe hard code but didn't work

			driver.get(prop.getProperty("url"));   //Specify "url" from Config.properties file
		
			return driver;
		
		
	}

}
