package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class PaymentPage extends Baseclass {

	Action action=new Action();
	
	@FindBy(xpath = "//a[contains(. , 'Pay by bank wire ')]")
	private WebElement paymentBank;
	
	public PaymentPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public OrderSummaryPage clickOnPayByBankWire() {
		action.JSClick(getdriver(), paymentBank);
		return new OrderSummaryPage();
	}
}
