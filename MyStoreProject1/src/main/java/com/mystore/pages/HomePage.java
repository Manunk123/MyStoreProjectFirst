package com.mystore.pages;

import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;

	public class HomePage extends BaseClass {
		
		ActionClass action;
		

		@FindBy(xpath="//a[text()='Wishlist']")
		WebElement whislist;
		
		@FindBy(xpath="//a[text()='Orders & Returns']")
		WebElement orderNdPrice;
		
		@FindBy(xpath="//div//h1")
		WebElement logopresent;
		
		@FindBy(xpath="(//*[name()='svg'])[5]")
		WebElement clicksign;
		
		@FindBy(xpath="//button[text()=\"Log out\"]")
		WebElement logout1;
		
		@FindBy(xpath="//p[contains(text(),'Signed in successfully.')]")
		WebElement signedtext;

		

		public HomePage() {
			super();
			PageFactory.initElements(getDriver(), this);
			action=new ActionClass();
		}

		
		public void logopresent()
		{
			action.isDisplayed(getDriver(), logopresent);
		}

		public boolean whislistcheck() {
			 return action.isDisplayed(getDriver(),whislist);
		}
		
		public boolean orderhistory() {
			action.fluentWait(getDriver(), clicksign, 10);
			return action.isDisplayed(getDriver(), orderNdPrice);
		}


		public String getCurrUrl() {
			  String homePageUrl=getDriver().getCurrentUrl();
			  return homePageUrl;
		
		}
		
		public boolean signeinconfrm()
		{
			
		return action.isDisplayed(getDriver(), signedtext);	
		}
		

		public void logoutpage()
		{
			
			action.click(getDriver(), logout1);
			
		}


		
		
	}


