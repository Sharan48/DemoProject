package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Baseclass {
	public	Properties property;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();

	public static WebDriver getdriver() {
		return driver.get();
	}


	@BeforeTest(groups = { "Smoketest", "Integrstiontest"} )
	public void ExtendReportGenerate() {
		ExtentManager.setExtent();
	}

	//	@Parameters("browser")
	@BeforeMethod(groups = { "Smoketest", "Integrstiontest"} )
	public void launchWebPage() throws IOException {


		FileInputStream file=new FileInputStream( "C:\\Users\\Asus\\eclipse-workspace2\\DemoProject\\Configuration\\Config.properties");

		property=new Properties(); property.load(file); 
		String browser = property.getProperty("browser"); 
		String url = property.getProperty("url");

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		getdriver().get(url);
		getdriver().manage().window().maximize();
		getdriver().navigate().refresh();
		getdriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		getdriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	} 


	@AfterMethod(groups = { "Smoketest", "Integrstiontest"} )
	public void logOutToApp() {
		getdriver().quit();
	}

	@AfterTest(groups = { "Smoketest", "Integrstiontest"} )
	public void ExtendeReportFlush() {
		//TO write or update test information to reporter
		ExtentManager.endReport();
	}

}
