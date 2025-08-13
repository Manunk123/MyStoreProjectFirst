package com.mystore.testcases;


	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.pages.AddToCartPage;
	import com.mystore.pages.IndexPage;
	import com.mystore.pages.SearchRsltPage;

	public class SearchRsltTest extends BaseClass {
		 IndexPage indxpage;
		 SearchRsltPage searchpage;
		 AddToCartPage addtocart;
		 
		 @Parameters("browser")
		  @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		
			public void setup(String browser) {
				launchApp(browser);
			}

		  @Test(groups="Sanity")
		  public void validationsearcht() {
			  indxpage=new IndexPage();
			 searchpage=indxpage.searchClick("tops");
	         addtocart=searchpage.clickTheIteam();
		  }
		  
		  @AfterMethod(groups= {"Smoke","Regression"})
		    public void teardown() {
		    	getDriver().quit();
		    }
		
		  
	}

