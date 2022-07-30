package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.PrivateBinder;
import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class AccountCreationPage extends Baseclass{

	Action action= new Action();
	@FindBy(xpath = "//h1[.='Create an account']")
	private WebElement formTitle;

	@FindBy(id = "id_gender1")
	private WebElement mr;

	@FindBy(id = "uniform-id_gender2")
	private WebElement mrs;

	@FindBy(id = "customer_firstname")
	private WebElement firstname;

	@FindBy(id = "customer_lastname")
	private WebElement lastname;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "days")
	private WebElement days;

	@FindBy(id = "months")
	private WebElement months;

	@FindBy(id = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement firstname1;

	@FindBy(name = "lastname")
	private WebElement lastname1;

	@FindBy(name = "company")
	private WebElement company;

	@FindBy(name = "address1")
	private WebElement address1;

	@FindBy(name = "address2")
	private WebElement address2;

	@FindBy(name = "city")
	private WebElement id_city;

	@FindBy(name = "id_state")
	private WebElement id_state;

	@FindBy(name = "postcode")
	private WebElement postcode;

	@FindBy(name = "id_country")
	private WebElement id_country;

	@FindBy(name = "other")
	private WebElement additionalInformation;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement phone_mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(id = "submitAccount")
	private WebElement register;

	public AccountCreationPage() {
		PageFactory.initElements(getdriver(), this);
	}

	
	public boolean validateAccountPage() {
	  return action.isDisplayed(getdriver(), formTitle);
	}
	

	public void creatAccount(String gender, String fName, String lName, String eMail, String passwrd, String day, String month, String year,
			String Fname, String Lname, String compny, String Address1, String Address2, String city, String state, String postalcode,String country,
			String AddtionalInformation, String homephone, String mobilephone, String reference)
		 {

		if(gender.equalsIgnoreCase("Mr")) {
			action.JSClick(getdriver(), mr);
		}else {
			action.JSClick(getdriver(), mrs);
		}
		action.type(firstname, fName);
		action.type(lastname, lName);
		action.type(email, eMail);
		action.type(password, passwrd);
		action.selectByValue(days, day);
		action.selectByValue(months, month);
		action.selectByValue(years, year);
		action.type(firstname1, Fname);
		action.type(lastname1, Lname);
		action.type(company, compny);
		action.type(address1, Address1);
		action.type(address2, Address2);
		action.type(id_city, city);
		action.selectByValue(id_state, state);
		action.type(postcode, postalcode);
		action.selectByValue(id_country, country);
		action.type(additionalInformation, AddtionalInformation);
		action.type(phone, homephone);
		action.type(phone_mobile, mobilephone);
		action.type(ref, reference);     
	}
	public HomePage clickOnRegister() {
		action.JSClick(getdriver(), register);
		return new HomePage();
	}

}
