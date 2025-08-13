package com.mystore.pages;



	import org.openqa.selenium.By;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;



	public class PaymentPage extends BaseClass{
		
		ActionClass action;
		
		public PaymentPage() {
			
		   super();
		   PageFactory.initElements(getDriver(),this);
		   action= new ActionClass();
		   
			
		}
		
		By checkpayment = By.xpath("//input[@id='order_payments_attributes__payment_method_id_24']");
		
		By clickpayment = By.xpath("//button[@id='checkout-payment-submit']");
		
		 
		 public ConfirmationPage paymentMode() {
			 
		    action.click2(getDriver(), checkpayment);
			action.click2(getDriver(), clickpayment);
			 return new ConfirmationPage();
		 }
		 
		
		

	}