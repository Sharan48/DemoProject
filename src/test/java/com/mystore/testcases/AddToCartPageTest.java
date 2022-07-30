package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchResultPage;

public class AddToCartPageTest extends Baseclass {
	
	IndexPage indexpage;
	SearchResultPage searchpage;
	AddToCartPage addtocart;

	@Test(dataProvider = "ProductDetail", dataProviderClass = DataProviders.class)
	public void verifyingTotalPrize(String productName, String Qunatity, String size) {
		indexpage=new IndexPage();
		searchpage=indexpage.serachProductName(productName);
		addtocart=searchpage.clickOnProduct();
		addtocart.enterQuntity(Qunatity);
		addtocart.enterSize(size);
		addtocart.clickAddToCart();
		boolean result = addtocart.validateAddtoCart();
		Assert.assertTrue(result);
		addtocart.clickOnCheckOut();
	}
}
