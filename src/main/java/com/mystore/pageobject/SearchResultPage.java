package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class SearchResultPage extends Baseclass {

	Action action= new Action();
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	private WebElement productSelect;
	
	public SearchResultPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean isProductAvailable() {
	return	action.isDisplayed(getdriver(), productSelect);
	}
	
	public AddToCartPage clickOnProduct() {
		action.JSClick(getdriver(), productSelect);
		return new AddToCartPage();
	}
}
