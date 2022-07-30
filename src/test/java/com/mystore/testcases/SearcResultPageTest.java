package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchResultPage;

public class SearcResultPageTest extends Baseclass {
	
	IndexPage indexpage;
	SearchResultPage seacrhpage;
@Test(dataProvider = "Productname", dataProviderClass = DataProviders.class, groups = "Integrstiontest")
public void searchProductAvailabilityTest(String productName) {
	indexpage=new IndexPage();
	seacrhpage=indexpage.serachProductName(productName);
	boolean result = seacrhpage.isProductAvailable();
	Assert.assertTrue(result);
}
}
