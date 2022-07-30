package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class OrderSummaryPage extends Baseclass {

	Action action=new Action();
	
	@FindBy(xpath = "//span[.='I confirm my order']")
	private WebElement confirmMyOrder;
	
	public  OrderSummaryPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public OrderConfirmationPage clickOnIconfirmMyOrder() {
		action.JSClick(getdriver(), confirmMyOrder);
		return new OrderConfirmationPage();
	}
}
