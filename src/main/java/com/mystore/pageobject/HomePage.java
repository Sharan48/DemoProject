package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class HomePage extends Baseclass {

	Action action=new Action();
	
   @FindBy(xpath = "//span[.='My wishlists']")
   private WebElement myWishlists;
   
   @FindBy(xpath = "//span[.='Order history and details']")
   private WebElement orderHistorydetails;
   
   public HomePage() {
	   PageFactory.initElements(getdriver(), this);
   }
   
   public boolean validateMywislists() {
	 return  action.isDisplayed(getdriver(), myWishlists);
   }
   
   public boolean validateoderHistoryDetails() {
	  return action.isDisplayed(getdriver(), orderHistorydetails);
   }
   
   public String gethomePageURL() {
	   String homePageURL = action.getCurrentURL(getdriver());
	   return homePageURL;
   }
}
