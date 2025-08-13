package com.mystore.pages;



	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;

	

	public class AddressPage extends BaseClass {

		public ActionClass action;
		

		
		public AddressPage() {
			
	    super();
	    PageFactory.initElements(getDriver(), this);
	    action = new ActionClass();
	    
		}
		
	  @FindBy(xpath="//input[@placeholder='Email']")
	  WebElement emailtext2;
	  
	  @FindBy(xpath="//input[@id='order_accept_marketing']")
	  WebElement checkboxemail;
	  
	  @FindBy(xpath="//input[@id='order_signup_for_an_account']")   // this one based upon which option we choose at the time of the click in the operation;
	  WebElement checkboxaccount;
	  
	  @FindBy(id="order_ship_address_attributes_country_id")
	   WebElement dropcountry;
	  
	  @FindBy(xpath="//input[@id='order_ship_address_attributes_firstname']")
	  WebElement firstname;
	  
	  @FindBy(xpath="//input[@id='order_ship_address_attributes_lastname']")
	  WebElement lastname;
	  
	  @FindBy(xpath="//input[@id='order_ship_address_attributes_address1']")
	  WebElement address1;
	  
	  @FindBy(xpath="//input[@id='order_ship_address_attributes_address2']")
	  WebElement address2;
	  
	  @FindBy(xpath="//input[@id='order_ship_address_attributes_city']")
	  WebElement  city;
	  
	  @FindBy(xpath="//select[@id='order_ship_address_attributes_state_id']")
	  WebElement stateid;
	  
	  @FindBy(xpath="//input[@id='order_ship_address_attributes_zipcode']")
	  WebElement zipcode;
	  
	  @FindBy(xpath="//input[@id='order_ship_address_attributes_phone']")
	  WebElement phnnumber;
	  
	  @FindBy(xpath="//button[text()='Save and Continue']")
	  WebElement savecon;
	  
	  
	 public DeliverPage validateaddresspage(String email, String first, String last, String add1, String add2, String cit1, String zip, String phn)
	 
	 {
		 action.type(emailtext2, email);
		 action.click(getDriver(),checkboxemail);
		 
		 action.selectByVisibleText("India",dropcountry);

		 action.type(firstname, first);
		 action.type(lastname, last);
		 action.type(address1, add1);
		 action.type(address2, add2);
		 action.type(city, cit1);
		 action.selectByIndex(stateid, 8);
		 action.type(zipcode, zip);
		 action.type(phnnumber,phn);
		 action.implicitWait(getDriver(), 10);
		 action.click(getDriver(),savecon);
		 return new DeliverPage();

		}

	 
		}
