package com.familiar.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.familiar.utils.TestProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	Properties prop = new Properties();

	public WebDriver driver = null;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	public WebDriver getDriver(String platform, String browser, String nodeUrl, String deviceName,
			String platformVersion) throws IOException, InterruptedException {
		prop = TestProperties.loadProperties();
		if (platform.equals("Android")) {
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capabilities.setCapability("automationName", "appium");
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("launchTimeout", 18000);
			if (browser.equals("App")) {
				capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));
				capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));
				driver = new AndroidDriver<WebElement>(new URL(nodeUrl), capabilities);
			} else if (browser.equals("Web")) {
				capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
				driver= new AndroidDriver<WebElement>(new URL(nodeUrl), capabilities);
				driver.get(prop.getProperty("weburl"));
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else if (platform.equals("DesktopWeb")) {
			if (browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator +"chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("weburl"));
			//driver.manage().window().maximize();
		}

		return driver;
	}

}
