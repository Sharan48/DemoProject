package com.mystore.testcases;

import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mystore.base.Baseclass;
import com.mystore.pageobject.IndexPage;
import com.mystore.utility.ExtentManager;
import com.mystore.utility.Log4J;
import com.mystore.utility.RetryListener;

public class IndexPageTest extends Baseclass
{

	IndexPage indexpage;
	//	@Test(retryAnalyzer = RetryListener.class)
	public void verifyLogoTest() {
		Log4J.startTestCase("verifyLogoTest");
		indexpage=new IndexPage();

		boolean result = indexpage.validateLogo();

		Assert.assertTrue(result);
		Log4J.endTestCase("verifyLogoTest");
	}



	@Test(groups = "Smoketest" )
	public void verifyTitle() {
		indexpage=new IndexPage();
		String actualTitle = indexpage.getMyStoreTitle();

		Assert.assertEquals(actualTitle, "Store");


	}

}
