package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class AddToCartPage extends Baseclass{

	Action action=new Action();

	@FindBy(name = "qty")
	private WebElement quantity;

	@FindBy(id = "group_1")
	private WebElement size;

	@FindBy(id = "color_13")
	private WebElement color;

	@FindBy(id = "add_to_cart")
	private WebElement addTocartBtn;

	@FindBy(xpath = "//h2[contains(. , 'Product successfully added to your shopping cart 				')]")
	private WebElement addTocartMessage;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement proceedTocheckout;

	public void AddToCartPage() {
		PageFactory.initElements(getdriver(), this);
	}

	public void enterQuntity(String Quantity) {
		action.fluentWait(getdriver(), quantity, 10);
		action.type(quantity, Quantity);
	}

	public void enterSize(String Size) {
		action.selectByVisibleText(Size, size);
	}

	public void clickOnColor() {
		action.JSClick(getdriver(), color);
	}

	public void clickAddToCart() {
		action.JSClick(getdriver(), addTocartBtn);
	}
	public boolean validateAddtoCart() {
		action.fluentWait(getdriver(), addTocartBtn, 10);
		return action.isDisplayed(getdriver(), addTocartMessage);
	}

	public OrderPage clickOnCheckOut() {
		action.fluentWait(getdriver(), proceedTocheckout, 10);
		action.JSClick(getdriver(), proceedTocheckout);
		return new OrderPage();
	}
}
