package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.actiondriver.Action;

public class ExtentManager {

	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extentreports;
    public static ExtentTest extestTest;
    
   
	public static void setExtent() {
		Action action=new Action();
		
		//initialize the HtmlReporter
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport3.html");

		//initialize the XmlReporter
//		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"test-output/extent-config.xml");

		//Configuration items to change the look and feel
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("Test Report");
		htmlreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')' ");
		htmlreporter.config().setTheme(Theme.DARK);

		//initialize ExtentReport and attach the HtmlReport
		extentreports= new ExtentReports();
		extentreports.attachReporter(htmlreporter);
		
		extentreports.setSystemInfo("hostName", "MyHost");
		extentreports.setSystemInfo("ProjectName", "MyProjectName");
		extentreports.setSystemInfo("Tester", "Sharan");
    }
	
  
	
	public static void endReport() {
		extentreports.flush();
	}

}
