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
import com.mystore.pages.ConfirmationPage;
import com.mystore.pages.DeliverPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.PaymentPage;
import com.mystore.pages.PricePage;
import com.mystore.pages.SearchRsltPage;


public class EndToEndtest extends BaseClass {

	IndexPage indxpage;
	SearchRsltPage searchpage;
	AddToCartPage addtocart;
	PricePage pricetst;
	AddressPage addresspage;
	DeliverPage deliverpage;
	PaymentPage paymentpage;
	ConfirmationPage confrpage;
	
	 @Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	 
	public void setup(String browser) {
		
	    launchApp(browser);
	}
	
	
	
	
	@Test(dataProvider="getProduct",dataProviderClass= dataprovider.class,groups="Regression")
	public void EndToEndTestNow(String product, String qty, String size1) throws InterruptedException {
		
			 indxpage=new IndexPage();
			 Thread.sleep(2000);
		 		searchpage=indxpage.searchClick(product);
		 	    addtocart=searchpage.clickTheIteam();
		 	     Thread.sleep(2000);
		 		addtocart.clickdropdown(size1);
		 	   // addtocart.clickcounts("4");
		 		addtocart.plusicrement();
		 	    pricetst=addtocart.addtocartone();
		    	Double unitprice= pricetst.validateUnitPrice();
		    	Double totalprice= pricetst.validateUnitPrice2();
		 	    Double totalexpectedprice=(unitprice*(Double.parseDouble(qty)));
		    	 Assert.assertEquals(totalprice, totalexpectedprice);
		     	 addresspage= pricetst.clickcheckout();
               deliverpage= addresspage.validateaddresspage("manunagarkoti123@gmail.com","mannu","nagar", "A-135, moti bagh 1,block F, Motibagh, new delhi","atal adarsh schl", "Delhi", "110021", "8489875678");
		    	  action.implicitWait(getDriver(),10);
		           paymentpage= deliverpage.clickbutton();
		    	    Thread.sleep(3000);
		    	 confrpage= paymentpage.paymentMode();
		         boolean rslt=confrpage.confrtmmsgtext();
		    	 Assert.assertTrue(rslt);
		     
		
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		
		getDriver().quit();
	}
	
	
	
	
		
	
}
