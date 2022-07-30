package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;

public class EndToEndTest extends Baseclass{
	IndexPage indexpage;
	LoginPage loginpage;
	AddressPage addressPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Test(dataProvider = "ProductDetail", dataProviderClass = DataProviders.class)
	public void endToendTest(String productName, String qty, String size) {
		indexpage=new IndexPage();
		searchResultPage=indexpage.serachProductName(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuntity(qty);
		addToCartPage.enterSize(size);
		addToCartPage.clickAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginpage=orderPage.clickOnProceedToCheckOut();
		addressPage=loginpage.Login(property.getProperty("username"), property.getProperty("password"));
		shippingPage=addressPage.clickOnProcessAddressBtn();
		shippingPage.checkTheTerm();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummaryPage=paymentPage.clickOnPayByBankWire();
		orderConfirmationPage=orderSummaryPage.clickOnIconfirmMyOrder();
		String actualMessage = orderConfirmationPage.validateConfirmMessage();
		String expectedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage,expectedMessage );
		
	}
	

}
