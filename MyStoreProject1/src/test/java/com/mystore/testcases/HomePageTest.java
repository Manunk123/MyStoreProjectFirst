package com.mystore.testcases;


	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.pages.HomePage;
	import com.mystore.pages.IndexPage;
	import com.mystore.pages.LoginPage;

	public class HomePageTest extends BaseClass {
		
		IndexPage indxpage;
		LoginPage loginpage;
		 HomePage homepage;
		 
		 @Parameters("browser")
		  @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		 
		public void setup(String browser) {
			launchApp(browser);
		}
		  
		  
		  @Test(groups="Smoke")
		  public void validateWhishlist() throws InterruptedException {
		  indxpage=  new IndexPage();
			 loginpage=indxpage.clickOnSignIn();
			 Thread.sleep(2000);
			homepage=loginpage.mailId(prop.getProperty("email"),prop.getProperty("password"));
			loginpage.clickhmp();
			 boolean rslt=homepage.whislistcheck();
		     
		  }
		  
		  
		  
		  @Test( groups= "Smoke")
		  public void validateOrderhistory() throws InterruptedException {
		  indxpage=  new IndexPage();
			 loginpage=indxpage.clickOnSignIn();
			 Thread.sleep(2000);
			homepage=loginpage.mailId(prop.getProperty("email"),prop.getProperty("password"));
			 loginpage.clickhmp();
			
			 boolean rslt=homepage.orderhistory();
			 Assert.assertTrue(rslt);
		  }
		  
		  
		  
		  
		  @AfterMethod(groups= {"Smoke","Sanity","Regression"})
		  public void teardown() {
			  
			  getDriver().quit();
		  }

	}

	
