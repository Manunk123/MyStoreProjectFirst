package com.mystore.testcases;



	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.dataprovider.dataprovider;
import com.mystore.pages.AddToCartPage;
	import com.mystore.pages.AddressPage;
	import com.mystore.pages.IndexPage;
	import com.mystore.pages.PricePage;
	import com.mystore.pages.SearchRsltPage;

	public class PricePageTest extends BaseClass{
	     
		IndexPage indxpage;
	     SearchRsltPage searchpage;
	     AddToCartPage addtocart;
	     PricePage pricetst;
		AddressPage addresspage;
		
		 @Parameters("browser")
		@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
		 
		public void setup(String browser) {
			
			launchApp(browser);
		}
		
	     @Test(dataProvider="getProduct",dataProviderClass= dataprovider.class, groups="regression")
	     public void validatePriceTag( String product, String qty, String size) throws InterruptedException {
	    	 
	    	 indxpage=new IndexPage();
	 		searchpage=indxpage.searchClick(product);
	 	    addtocart=searchpage.clickTheIteam();
	 	    Thread.sleep(2000);
	 		addtocart.clickdropdown(size);
	 	    //addtocart.clickcounts("4");
	 		addtocart.plusicrement();
	 	    pricetst=addtocart.addtocartone();
	    	Double unitprice= pricetst.validateUnitPrice();
	    	Double totalprice= pricetst.validateUnitPrice2();
	 	    Double totalexpectedprice=(unitprice*(Double.parseDouble(qty)));
	 	    		
	 	    		
	     }
	    @AfterMethod(groups= {"Smoke","Sanity","Regression"})
	    public void teardown() {
	    	getDriver().quit();
	    }
		
	}

