package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class OrderPage extends Baseclass {

	Action action=new Action();
	
	@FindBy(xpath = "//span[@id='product_price_1_1_706116']")
	private WebElement unitPrize;
	
	@FindBy(xpath = "//td[@id='total_price_container']")
	private WebElement totalPrize;
	
	@FindBy(xpath = "//span[.='Proceed to checkout']")
	private WebElement proceedtoCheckoutBtn;
	
	public OrderPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public double getUnitPrize() {
		String unitPrize1 = unitPrize.getText();
		String unit = unitPrize1.replaceAll("[^a-zA-Z0-9]", " ");
		double finalunitprize = Double.parseDouble(unit);
		return finalunitprize/100;
	}
	
	public double getFinalUnitPrize() {
		String prize = totalPrize.getText();
		String finalprize = prize.replaceAll("[^a-zA-Z0-9]", " ");
		double finalunitPrize = Double.parseDouble(finalprize);
		return finalunitPrize/100;
	}
	
	public LoginPage clickOnProceedToCheckOut() {
		action.JSClick(getdriver(), proceedtoCheckoutBtn);
		return new LoginPage();
	}
}
