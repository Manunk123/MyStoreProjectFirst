package com.mystore.pages;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;

	public class LoginPage extends BaseClass {
		
		ActionClass action;
		
		@FindBy(xpath="//input[@id='user_email']")
		WebElement emailid;
		
		@FindBy(xpath="//div//input[@id='user_password']")
		WebElement passwo;
		
		@FindBy(xpath="//input[@id='login-button']")
		WebElement loginbtn;
		
		@FindBy(xpath="(//a[normalize-space()='Sign Up'])[1]")
		WebElement signup;
		
		@FindBy(xpath="(//*[name()='svg'])[5]")
		WebElement clickhm;
		 	
		
		
		
		    
		      public LoginPage() {
	    		super();
	    		 PageFactory.initElements(getDriver(), this);
	      	   action=new ActionClass();
		}

			public HomePage mailId(String email,String pwd) {
	    		
	    	   action.type(emailid, email);
	    		action.type(passwo, pwd);
	    		action.click(getDriver(), loginbtn);
	    		return new HomePage();
	    		
	    	}
			
			public CreateAccountPage signupcredentials() {
				
				action.click(getDriver(),signup);
				return new CreateAccountPage();
			}
	    	
		public void clickhmp() {
			
			
			action.click(getDriver(), clickhm);

		}
				
		
			
			
	  
	        public CreateAccountPage createAccount()
	    	{
	    		
	            action.click(getDriver(), signup);
	            return new CreateAccountPage();
	    	}
	    	

	   
	 }

