package com.mystore.pages;

import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;



	public class PricePage extends BaseClass {
		
		ActionClass action;
		
		@FindBy(xpath="//div[@class='mb-2 text-sm']")
		WebElement unitprice;

		@FindBy(xpath="//span[@class='shopping-cart-total-amount']")
		WebElement totalprice;
		
		@FindBy(xpath="//div//a[text()='Checkout']")
	     WebElement Checkout;
		
		
		public PricePage() {
			
			super();
			PageFactory.initElements(getDriver(), this);
			action= new ActionClass();
		}
			
			public double validateUnitPrice() {
			     action.explicitWait(getDriver(), unitprice, 10);
				String unitPrice1=unitprice.getText();
				 String unit=unitPrice1.replaceAll("[^0-9.]","").trim();
				 double totalunit=Double.parseDouble(unit);
				 System.out.println("Price test:'"+totalunit+"'");
				 return totalunit/100;

			}
			public double validateUnitPrice2() {
				
				String totalPrice1=totalprice.getText();
				 String totunit=totalPrice1.replaceAll("[^0-9.]","").trim();
			      double totalunitprice=Double.parseDouble(totunit);
				 System.out.println("Price test: '"+totalunitprice+"'");
				 return totalunitprice/100;

			}

			
			public AddressPage clickcheckout() {
				
			action.click(getDriver(), Checkout);
			return new AddressPage();
			
			}
			
			
			
			
		}