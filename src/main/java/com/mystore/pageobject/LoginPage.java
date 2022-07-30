package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class LoginPage extends Baseclass {
	
	Action action= new Action();

	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(id = "email_create")
	private WebElement enterNeweMailId;
	
	@FindBy(id="SubmitCreate")
	private WebElement CreateAnAccount;
	
	public LoginPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public HomePage HomepageLogin(String usernm, String paswrd) {
		action.type(username, usernm);
		action.type(password, paswrd);
		action.JSClick(getdriver(), signInBtn);
		HomePage home=new HomePage();
		return home;
	}
	
	public AddressPage Login(String usernm, String paswrd) {
		action.type(username, usernm);
		action.type(password, paswrd);
		action.JSClick(getdriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Exception {
		action.type(enterNeweMailId, newEmail);
		action.JSClick(getdriver(), CreateAnAccount);
		return new AccountCreationPage(); 
	}
}
