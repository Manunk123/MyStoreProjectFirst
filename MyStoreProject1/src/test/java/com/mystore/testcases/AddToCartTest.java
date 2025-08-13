package com.mystore.testcases;



	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.dataprovider.dataprovider;
import com.mystore.pages.AddToCartPage;
	import com.mystore.pages.IndexPage;
	import com.mystore.pages.PricePage;
	import com.mystore.pages.SearchRsltPage;

	public class AddToCartTest extends BaseClass {
		
		IndexPage indxpage;
		SearchRsltPage searchpage;
		AddToCartPage addtocart;
		PricePage pricepage;
	   
		 @Parameters("browser")
		@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		 
		public void setup(String browser) {
			
			launchApp(browser);
		}

		@Test(dataProvider="getProduct",dataProviderClass= dataprovider.class,groups= {"Regression","Sanity"})
		public void testresl(String product, String qty, String size1) throws InterruptedException {
			
			indxpage=new IndexPage();
			searchpage=indxpage.searchClick(product);
		    addtocart=searchpage.clickTheIteam();
		    Thread.sleep(2000);
		    addtocart.clickdropdown(size1);
			addtocart.plusicrement();
		      //addtocart.clickcounts(qnty);
		    
		   pricepage= addtocart.addtocartone();
		    
		}
		
		@AfterMethod(groups= {"Smoke","Sanity","Regression"})
		public void teardown() {
			
		    getDriver().quit();
			
			}
		
	}
