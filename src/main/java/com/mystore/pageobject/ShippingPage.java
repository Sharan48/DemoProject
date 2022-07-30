package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class ShippingPage extends Baseclass {

	Action action=new Action();
	@FindBy(id="cgv")
	private WebElement term;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void checkTheTerm() {
	 action.click(getdriver(), term);
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		action.JSClick(getdriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}
}
