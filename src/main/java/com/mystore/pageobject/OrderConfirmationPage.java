package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class OrderConfirmationPage extends Baseclass{

	Action action=new Action();
	
	@FindBy(xpath = "//p[contains(. , 'Your order on My Store is complete.')]")
	private WebElement confirmMessage;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public String validateConfirmMessage() {
		String message = confirmMessage.getText();
		return message;
	}
}
