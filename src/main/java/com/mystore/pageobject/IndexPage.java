package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class IndexPage extends Baseclass{
	
	Action action=new Action();
 
	@FindBy(xpath = "//a[@class='login']")
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement mystoreLogo;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		action.fluentWait(getdriver(), signInBtn, 10);
		action.click(getdriver(), signInBtn); 
		return new LoginPage();
	}
	
	public boolean validateLogo() {
	return	action.isDisplayed(getdriver(), mystoreLogo);
		
	}
	
	public String getMyStoreTitle() {
		String MystoreTitle = getdriver().getTitle();
		return MystoreTitle;
	}

	public SearchResultPage serachProductName(String productName) {
		action.type(searchProductBox, productName);
		action.JSClick(getdriver(), searchButton);
		return new SearchResultPage();
	}
	
    
}
