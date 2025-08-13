package com.mystore.pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;


	public class DeliverPage extends BaseClass {
		
		ActionClass action;
		
		public DeliverPage() {
			
			super();
			PageFactory.initElements(getDriver(), this);
			action= new ActionClass();
			
		}

		
		
		@FindBy(xpath="//span[text()='Delivery in 2-3 business days']")
		WebElement clickpremium;
		
		By savebutton= By.xpath("//button[text()='Save and Continue']");
		
		
		 public PaymentPage clickbutton() {
			 action.implicitWait(getDriver(), 20);
			 action.click(getDriver(), clickpremium);
	         action.click2(getDriver(),savebutton);
			 return new PaymentPage();
			 
		 }
	}
