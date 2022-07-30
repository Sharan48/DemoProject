package com.mystore.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	int count=0;
	int retrylimi=3;
	@Override
	public boolean retry(ITestResult result) {
		
		
		if(count<retrylimi) {
			count++;
			return true;
		}
		return false;
	}

}
