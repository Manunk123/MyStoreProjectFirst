package com.mystore.pages;


		import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.mystore.actionclass.ActionClass;
import com.mystore.baseclass.BaseClass;


	public class AddToCartPage extends BaseClass {
		
		ActionClass action;
	   
	   
	    @FindBy(xpath="//button[contains(@class,'text-sm uppercase')]")
	    WebElement dropdown;
	   
	    @FindBy(xpath="//div//label//p")
	    List<WebElement> size1;
	    
	 
	   @FindBy(xpath="//input[@class='quantity-input']")
	  WebElement quantity;
	    

	     By plusbutton = By.xpath("//button[@class='increase-quantity']");
	    
	    @FindBy(xpath="//span[text()='Add To Cart'][1]")
	    WebElement clickadd;
	    
	    public AddToCartPage() {
	 	   super();
	 	PageFactory.initElements(getDriver(), this);
	 	action=new ActionClass();
	 	}
	    
	    
	        
	    public void clickdropdown(String size) {
	    	
	    	action.implicitWait(getDriver(), 10);
	    	action.selectOptionByText(dropdown, size1, size);
	    	
	    }
	    
	    
	  public void plusicrement() {
	   
	    action.increaseQuantity(getDriver(), plusbutton, 2);
	    
	    
	    }
	   
	    
	   /* public void  clickcounts(String getnum) {
	    	
	    	action.setQuantity(getDriver(), entercred, 4);
	    	
	    }
	    
	    */
	    
	    

	    public PricePage addtocartone() {
	    	
	    	action.click(getDriver(), clickadd);
	    	return new PricePage();
	    }






	}
		
	    
	  