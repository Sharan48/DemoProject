package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class AddressPage extends Baseclass{

	Action action= new Action();
	
	@FindBy(xpath = "//button[@name= 'processAddress']")
	 private WebElement procssAddressBtn;
	
	public AddressPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public ShippingPage clickOnProcessAddressBtn() {
		action.JSClick(getdriver(), procssAddressBtn);
		return new ShippingPage();
	}
	
}
