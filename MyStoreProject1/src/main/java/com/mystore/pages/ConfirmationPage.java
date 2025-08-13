package com.mystore.pages;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;



	public class ConfirmationPage extends BaseClass {
		
		ActionClass action;
		
		public ConfirmationPage() {
	 
			 super();
			 PageFactory.initElements(getDriver(), this);
			 action= new ActionClass();
			
		}

		@FindBy(xpath="//h4[@class='mb-4 text-green-600 font-semibold text-lg font-body']")
		WebElement confrmmsg;
		
		
		public boolean confrtmmsgtext() {
			
		return action.isDisplayed(getDriver(), confrmmsg);
		
		}
		
	}


