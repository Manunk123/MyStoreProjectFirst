package com.mystore.pages;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;

	

	public class CreateAccountPage extends BaseClass {
		
	     ActionClass action;
		
	 
	     
		@FindBy(xpath="//turbo-frame[@id='login']//input[@id='user_email']")
		WebElement emailsign;
		
	     @FindBy(xpath="//turbo-frame[@id='login']//input[@id='user_password']")
	     WebElement passwordnew;
		
		@FindBy(xpath="//turbo-frame[@id='login']//input[@id='user_password_confirmation']")
		WebElement confrmpass;

		@FindBy(xpath="//div[@class='actions']//input")
		WebElement signupbtn;
		
		@FindBy(xpath="(//p[@class='text-sm lg:text-base font-medium text-center uppercase text-text flash-message'])")
		WebElement welcm;
		
		public CreateAccountPage() {
			
			super();
			PageFactory.initElements(getDriver(), this);
			action=new ActionClass();
		}

		

		public void emailclick(String email1,String pawd1,String confpawd) {
		
		action.switchToFrameByIndex(getDriver(), 1);	
		action.type(emailsign, email1);
		action.type(passwordnew, pawd1);
		action.type(confrmpass, confpawd);
		action.click(getDriver(), signupbtn);
		
		}
		
		
		public boolean welcomenote() {
			
			return action.isDisplayed(getDriver(), welcm);
		}
		
		
	}

