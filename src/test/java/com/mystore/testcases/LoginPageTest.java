package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

@Test(dataProvider = "credentail", dataProviderClass = DataProviders.class)
public class LoginPageTest extends Baseclass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	public void loginTest(String usernm, String paswrd) {
		
		IndexPage  indexPage=new IndexPage();
	    
	    loginPage=indexPage.clickOnSignIn();
	    
	    homePage=loginPage.HomepageLogin(usernm, paswrd);
	    		
	}

}
