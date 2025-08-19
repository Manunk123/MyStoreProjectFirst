package com.mystore.baseclass;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.net.URL;
	import java.util.Properties;

	import org.apache.log4j.xml.DOMConfigurator;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.RemoteWebDriver;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;

import com.mystore.actionclass.ActionClass;
import com.mystore.utilities.ExtentReportManager;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		
		//public static WebDriver driver;
		 public static Properties prop;
		 //declare ThreadLocal Driver
		 protected static ThreadLocal<RemoteWebDriver>driver=new ThreadLocal<>();
		 
		 @BeforeSuite(groups= {"Smoke","Sanity","Regression"})
		 public void beforeSuite() {
		 
			
			ExtentReportManager extentReportManager = new ExtentReportManager();
			extentReportManager.setExtent();
		     URL configFile = getClass().getClassLoader().getResource("log4j.xml");
		     if (configFile != null) {
		    

		         DOMConfigurator.configure(configFile);
		         System.out.println("✅ log4j.xml loaded successfully");
		     } else {
		         System.out.println("❌ log4j.xml not found in classpath");
		     }
		 }
		 
		 public static WebDriver getDriver() {
			 //Get Driver from threadLocalmap
			 return driver.get();
		 }
		public static ActionClass action;
		 
		 @BeforeTest(groups= {"Smoke","Sanity","Regression"})
		 public void loadConfig() throws IOException {
			 
			
			 try {
			 prop= new Properties();
		
			 String propfile= System.getProperty("user.dir")+"src/test/resources/config.properties";
			 FileInputStream file = new FileInputStream(propfile);
			 prop.load(file);
			
			
			 }
			 catch(FileNotFoundException e)
			 {
				 e.printStackTrace();
			 }
			 catch(IOException e) {
				 
				 e.printStackTrace();
			 }
		 } 
		 
		
			 public  static void launchApp( String browserName)
			 {
				 
				 action= new ActionClass();
				//String browserName= prop.getProperty("browser");
				
				if(browserName.contains("Chrome")) {
			      WebDriverManager.chromedriver().setup();
					//driver= new ChromeDriver();
			      //set Browser to the ThreadLocal driver
			      driver.set(new ChromeDriver());
				}
				else if(browserName.contains("FireFox")) {
					
					//driver=new FirefoxDriver();
					driver.set(new FirefoxDriver());
				}
				else if(browserName.contains("Edge")) {
				     driver.set(new EdgeDriver());
				}
				 
				
				
			   getDriver().manage().window().maximize();
			  action.implicitWait(getDriver(), 10);
			  action.pageLoadTimeOut(getDriver(), 20);
			  getDriver().get(prop.getProperty("Url"));
			  getDriver().manage().deleteAllCookies();
			  
			  ExtentReportManager.endReport();
			       
			 }
			 
		

			 

			 
		
			
	}



