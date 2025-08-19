package com.mystore.pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;

	public class IndexPage extends BaseClass{
		
		ActionClass action;
		
		@FindBy(xpath="(//*[name()='svg'])[5]")
		WebElement signInBtn;
	 
		 @FindBy(xpath="//a[@id='site-logo'][1]")
		 WebElement logo;
		 
		 @FindBy(xpath="//span[text()='Search']")
		 WebElement searchMap;
		 
	     @FindBy(xpath="//input[@name='q']")
	     WebElement searchtxt;
		  
	    
	      
	      By filters= By.xpath("//button[normalize-space()='Filter']//*[name()='svg']");
	     

	     public IndexPage() {
	    	 super();
	       PageFactory.initElements(getDriver(), this);
	       action=new ActionClass();
	    }

		 public LoginPage clickOnSignIn() {
		
			 action.click(getDriver(), signInBtn);
			 return new LoginPage();
	      }
		 
		 public boolean clickOnLogo()
		 {  
			 
			 return action.isDisplayed(getDriver(), logo);
			
			
		 }
		  public String getTitle() {
			  
			String title=getDriver().getTitle();
			return title;
		  }
		  
		  
	
			

		public SearchRsltPage searchClick(String searchIteam) {
			   action.fluentWait(getDriver(), searchMap, 20);
		      action.click(getDriver(),searchMap);
		       action.type(searchtxt, searchIteam);
		      return new SearchRsltPage();
		}
	}



