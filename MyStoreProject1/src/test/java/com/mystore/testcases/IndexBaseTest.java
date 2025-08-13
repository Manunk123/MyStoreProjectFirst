package com.mystore.testcases;


	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.pages.IndexPage;
	import com.mystore.utilities.Log4;

	public class IndexBaseTest extends BaseClass {

		IndexPage indxpage;
		
		 @Parameters("browser")
		@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		 
		public void setup(String browser) {
			
			launchApp(browser);
		}
		@Test(groups="Smoke")
		public void verifylogo() {
			
			Log4.startTestCase("Start test");
			indxpage=new IndexPage();
			Log4.info(" verifying after the click on the page is shown logo display");
		    boolean result=	indxpage.clickOnLogo();
			Assert.assertTrue(result);
		}
		
		@Test(groups="Smoke")
		public void verifytitile() {
			
			Log4.info("verfying the title of the page is valid ");
			 String titilerslt=indxpage.getTitle();
			Assert.assertEquals(titilerslt, "Spree Commerce DEMO");
		    Log4.endTestCase("End test");
		}
		
		
		
		@AfterMethod(groups= {"Smoke","Sanity","Regression"})
		public void teardown() {
			
			getDriver().quit();
		}
		
	}


