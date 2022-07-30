package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;

public class HomePageTest extends Baseclass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
@Test(dataProvider = "credentail", dataProviderClass =  DataProviders.class)
  public void validateMyWishlistTest(String usernm, String paswrd) {
	indexPage=new IndexPage();
    
    loginPage=indexPage.clickOnSignIn();
    
    homePage=loginPage.HomepageLogin(usernm, paswrd);
    
    boolean result = homePage.validateMywislists();
    
    Assert.assertTrue(result);
	
}

@Test(dataProvider = "credentail", dataProviderClass = DataProviders.class )
public void validateOrderHistoryTest(String usernm, String paswrd) {
	indexPage=new IndexPage();
	loginPage=indexPage.clickOnSignIn();
	homePage=loginPage.HomepageLogin(usernm, paswrd);
	boolean result = homePage.validateoderHistoryDetails();
	Assert.assertTrue(result);
}
}
