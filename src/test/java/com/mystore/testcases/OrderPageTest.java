package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;

public class OrderPageTest extends Baseclass{

	IndexPage indexpage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Test(dataProvider = "ProductDetail", dataProviderClass = DataProviders.class)
	public void VerifyTotlaPrize(String productName, String Qunatity, String size ) {
		indexpage=new IndexPage();
		searchResultPage=indexpage.serachProductName(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuntity(Qunatity);
		addToCartPage.enterSize(size);
		addToCartPage.clickAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		double unitPrize = orderPage.getUnitPrize();
		double finalPrize = orderPage.getFinalUnitPrize();
		double totalExpectedfinalPrize = (unitPrize*(Double.parseDouble(Qunatity))+2);
		Assert.assertEquals(finalPrize, totalExpectedfinalPrize);
		
	}
}
