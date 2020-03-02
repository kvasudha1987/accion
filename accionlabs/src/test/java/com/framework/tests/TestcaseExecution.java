package com.framework.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import com.familiar.pages.HomePageMobile;
import com.familiar.pages.HomePageWeb;
import com.familiar.utils.TestBase;
import com.familiar.utils.TestProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestcaseExecution {
	public WebDriver driver;
	public AndroidDriver driver1 = null;
	String testName;

	Properties prop = new Properties();
	com.familiar.utils.TestBase testbase = new TestBase();
	public HomePageWeb hp;
	public HomePageMobile hpm;

	@BeforeSuite(alwaysRun = true)
	public void setup() throws Exception {
		prop = TestProperties.loadProperties();
	}

	@BeforeMethod(alwaysRun = true)
	public void startTest(Method method) throws Exception {
		driver = testbase.getDriver(prop.getProperty("platform"), prop.getProperty("browser"),
				prop.getProperty("nodeUrl"), prop.getProperty("deviceName"), prop.getProperty("platformVersion"));
		testName = method.getName();
	}

	/*
	 * works for web
	 * 
	 * @Test(groups="Sanity", description="Click library tab") public void
	 * ClickLibTab() throws InterruptedException, IOException {
	 * System.out.println("test"); hp = new HomePage( (AppiumDriver<?>)
	 * driver,dataArray); hp.homepagetitle(driver,testName);
	 * 
	 * }
	 */
	/*
	 * @Test(groups="Sanity", description="Click library tab") public void
	 * ClickLibTab() throws InterruptedException, IOException {
	 * System.out.println("test"); hp = new HomePage( (AndroidDriver<?>)driver1); hp
	 * = new HomePage(driver); hp.homepagetitle(driver,testName);
	 * System.out.println("pass");
	 * 
	 * }
	 */ // Passes for web
	@Test(groups = "Sanity", description = "Click library tab")
	public void flow() throws InterruptedException, IOException {
		hp = new HomePageWeb(driver);
		//hpm = new HomePageMobile((AndroidDriver<?>) driver1);
		
		ClickLibTab("DesktopWeb");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public void ClickLibTab(String platform) throws InterruptedException, IOException {
		if (platform.equals("DesktopWeb")) {
			hp.homepagetitle(driver, testName);
			hp.startTest1();
			System.out.println("pass");
		} else if (platform.equals("Android")) {
			hpm.homepagetitle(driver1, testName);
			System.out.println("pass");
		}
	}
	

}
