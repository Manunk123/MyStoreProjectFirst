	package com.mystore.pages;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;
	

	public class SearchRsltPage extends BaseClass{
		

		ActionClass action;
		
	  @FindBy(xpath="(//h1[normalize-space()='Spree Commerce DEMO'])[1]")
	   WebElement logodisplaysearch;
		
	   @FindBy(xpath="//a[contains(@id,'product-286')]")
	   WebElement clickIteam;
		
		
		public SearchRsltPage() {
			 super();
		       PageFactory.initElements(getDriver(), this);
		       action=new ActionClass();
			}
		
	     
	    public AddToCartPage clickTheIteam() {
	    	 action.fluentWait(getDriver(), clickIteam, 10);
	    	action.click(getDriver(), clickIteam);
	    	return new AddToCartPage();
	    	
	    }
		 
		 
	}
