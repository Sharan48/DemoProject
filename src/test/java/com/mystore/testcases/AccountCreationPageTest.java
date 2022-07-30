package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class AccountCreationPageTest extends Baseclass{

	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountcreatepage;
	HomePage homepage;
	//	@Test(dataProvider = "newAccountCreation", dataProviderClass = DataProviders.class)
	public void validateNewRegistrationForm(String newEmail) throws Exception {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		accountcreatepage=loginpage.createNewAccount(newEmail);
		boolean result = accountcreatepage.validateAccountPage();
		Assert.assertTrue(result);

	}

	//	@Test(dataProvider = "newAccountCreation" , dataProviderClass = DataProviders.class)
	public void createAccountForNewUser(String newEmail,String gender, String fName, String lName, String eMail, String passwrd, String day, String month, String year,
			String Fname, String Lname, String compny, String Address1, String Address2, String city, String state, String postalcode,String country,
			String AddtionalInformation, String homephone, String mobilephone, String reference)

					throws Exception

	{

		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		accountcreatepage=loginpage.createNewAccount(newEmail);
		accountcreatepage.creatAccount(gender, fName, lName, eMail, passwrd, day, month, year, Fname, 
				Lname, compny, Address1, Address2, city, state,postalcode,country, AddtionalInformation, homephone, mobilephone, reference);
		homepage=accountcreatepage.clickOnRegister();
		Assert.assertEquals("[http://automationpractice.com/index.php?controller=my-account", homepage.gethomePageURL());

	}
	@Test(dataProvider = "newusersCredentails" , dataProviderClass = DataProviders.class)
	public void AccountCreateforNewUsers( HashMap<String , String> hashmapValue) throws Exception {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		accountcreatepage=loginpage.createNewAccount(hashmapValue.get("newEmail"));
		accountcreatepage.creatAccount(hashmapValue.get("gender"),hashmapValue.get("fName"),hashmapValue.get("lName"),hashmapValue.get("eMail"),hashmapValue.get("passwrd"),hashmapValue.get("day") ,hashmapValue.get("month") ,
				hashmapValue.get("year"),hashmapValue.get("FName"),hashmapValue.get("LName"),hashmapValue.get("compny"),hashmapValue.get("Address1"),hashmapValue.get("Address2"),hashmapValue.get("city"),
				hashmapValue.get("state"),hashmapValue.get("postalcode"),hashmapValue.get("country"),hashmapValue.get("AddtionalInformation"),hashmapValue.get("homephone"),hashmapValue.get("mobilephone"),hashmapValue.get("reference"));
	}
}


