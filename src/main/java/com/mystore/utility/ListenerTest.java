package com.mystore.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class ListenerTest extends ExtentManager implements ITestListener {
	
	Action action=new Action();

	public void onTestStart(ITestResult result) {
		extestTest=extentreports.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extestTest.log(Status.PASS,MarkupHelper.createLabel(result.getName()+ "Pass Test Case Is ", ExtentColor.GREEN));
		}
		
	}

	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			extestTest.log(Status.FAIL, "Fail Test Case Is"+" "+ result.getName());//to Add Method name in extent report
			extestTest.log(Status.FAIL, "Fail Test Case Is"+" "+ result.getThrowable());// to Add error/exception in extent report
			
			String screenShotPath = action.screenShot(Baseclass.getdriver(), result.getName());
			
			try {
				extestTest.log(Status.FAIL, "ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}    
	}

	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP) {
			extestTest.log(Status.SKIP, "Skip Test Case Is"+ result.getName());
		}
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

