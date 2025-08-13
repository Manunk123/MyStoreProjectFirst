package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.baseclass.BaseClass;
import com.mystore.dataprovider.dataprovider;
import com.mystore.pages.AddToCartPage;
import com.mystore.pages.AddressPage;
import com.mystore.pages.DeliverPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.PricePage;
import com.mystore.pages.SearchRsltPage;

public class AddressPageTest extends BaseClass {
	 
	IndexPage indxpage;
	SearchRsltPage searchpage;
	AddToCartPage addtocart;
	PricePage pricetst;
	AddressPage addresspage;
     DeliverPage deliverpage;
     
     @Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
     
     
	public void setup(String browser) {
		
		launchApp(browser);
	}
	
	
   @Test(dataProvider="getProduct",dataProviderClass= dataprovider.class,groups="Regression")
   
   public void validatiOfaddress( String product, String qnty, String size1) throws InterruptedException {
		    indxpage=new IndexPage();
		    
	 		searchpage=indxpage.searchClick(product);
	 	    addtocart=searchpage.clickTheIteam();
	 	    Thread.sleep(2000);
	 	     addtocart.clickdropdown(size1);
	 		addtocart.plusicrement();
	 	    //addtocart.clickcounts("4");  this one is for to remove the defaultvalue of the count and the enter what we want 
	 	    pricetst=addtocart.addtocartone();
	    	Double unitprice= pricetst.validateUnitPrice();
	    	Double totalprice= pricetst.validateUnitPrice2();
	 	    Double totalexpectedprice=(unitprice*(Double.parseDouble(qnty)));
	    	 Assert.assertEquals(totalprice, totalexpectedprice);
	    	 addresspage= pricetst.clickcheckout();
	        deliverpage=addresspage.validateaddresspage("manunagarkoti123@gail.com","mannu","nagar", "A-135 moti bagh north new delhi","atal adarsh schl", "Delhi", "110021", "8489875678");
	    	 
	    	 
	 
   }
	
   @AfterMethod (groups= {"Smoke","Sanity","Regression"})
   public void teardown() {
	   getDriver().quit();
   }
	
	

	
}