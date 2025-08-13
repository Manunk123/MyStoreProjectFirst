package com.mystore.testcases;

	import static org.testng.Assert.assertEquals;

	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.dataprovider.dataprovider;
import com.mystore.pages.HomePage;
	import com.mystore.pages.IndexPage;
	import com.mystore.pages.LoginPage;
	import com.mystore.utilities.Log4;

	public class LoginBaseTest extends BaseClass {
		
		IndexPage indxpage;
		LoginPage loginpage;
		 HomePage homepage;
		
		 @Parameters("browser")
		  @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		 
		public void setup(String browser) {
			launchApp(browser);
		}

		@Test(dataProvider="credentials",dataProviderClass= dataprovider.class , groups= {"Smoke","Sanity"})
		
		 public void loginvalidate(String uname,String pwd,String exp) throws Throwable{
		
			Log4.startTestCase("Login test");
			indxpage=new IndexPage();
			Log4.info("User is going to click on signin");
			 loginpage=indxpage.clickOnSignIn();
			 Thread.sleep(2000);
			 Log4.info("enter the email and the password");
			homepage=loginpage.mailId(uname,pwd);
		  boolean targetpage=homepage.signeinconfrm();
		  
		  if(exp.contains("Valid"))
			{
		         if(targetpage==true)
				{
					indxpage.clickOnSignIn();
					homepage.logoutpage();
					Assert.assertTrue(true);
					
					
				}else {
					Assert.assertTrue(false);
				}
				
			}
			
			if (exp.contains("Invalid"))
			{
				
	             if(targetpage==true)
	            	 
	             {   indxpage.clickOnSignIn();
	            	 homepage.logoutpage();
	            	 Assert.assertTrue(false);
	             }
				
	             else {
	            	 
	            	 Assert.assertTrue(true);
	             }
			}
		
			
			homepage.whislistcheck();
			Log4.info("verifying the  currenturl");
			 String currentUrl=homepage.getCurrUrl();
		
			  Log4.info("login success");
			  
			  Log4.endTestCase("Login test");
		}
			
	    @AfterMethod(groups= {"Smoke","Sanity","Regression"})
		public void teardown() {
			
			getDriver().quit();
		}
	}



