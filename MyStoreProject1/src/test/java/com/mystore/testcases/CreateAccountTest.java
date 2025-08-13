package com.mystore.testcases;



	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.dataprovider.dataprovider;
import com.mystore.pages.CreateAccountPage;
import com.mystore.pages.IndexPage;
	import com.mystore.pages.LoginPage;

	public class CreateAccountTest extends BaseClass {
		
	      IndexPage indxpage;
	      LoginPage loginpage;
		  CreateAccountPage createacc;
		  
		  @Parameters("browser")
		  @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		  

		public void setup(String browser) {
			launchApp(browser);
		}
		  
		  
		  @Test(dataProvider="email",dataProviderClass= dataprovider.class,groups="Sanity")
		  public void signupcredentials(String email, String password, String confrmpass) throws InterruptedException {
			   indxpage= new IndexPage();
			    loginpage=indxpage.clickOnSignIn();
			    createacc=loginpage.signupcredentials();
			  createacc.emailclick(email, password, confrmpass);
			   boolean rslt=createacc.welcomenote();
			    Assert.assertTrue(rslt);
			    
			   
		  }
		  
		  
		  @AfterMethod(groups= {"Smoke","Sanity","Regression"})
		  public void teardown() {
			  
			  getDriver().quit();
	      }
		
		
		
		
	

}
