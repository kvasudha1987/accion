package com.familiar.pages;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.familiar.utils.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageMobile extends TestBase{
	AppiumDriver driver;
	public void setDriver(AppiumDriver driver) {
		this.driver =  driver;
	}
	public  WebDriver getDriver() {
		return driver;
	}
	
	@AndroidFindBy(id ="practiceLink")
	// @iOSFindBy(accessibility="")
	public WebElement tabLibrary;
	
	@AndroidFindBy(id ="tutorialsLink" )
	// @iOSFindBy(accessibility="")
	public WebElement tabTutorials;
	
	@AndroidFindBy(xpath="//a[contains(text(),'Answering Test Questions (with Narration) - 9:17m')]")
	// @iOSFindBy(accessibility="")
	public WebElement videolink;
	
	@AndroidFindBy(xpath="//span[contains(text(),'Transcript')]")
	// @iOSFindBy(accessibility="")
	public WebElement transcript;
	
	
	public HomePageMobile(AppiumDriver driver) throws IOException {
		this.driver = driver;
		setDriver(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void homepagetitle(AppiumDriver driver, String testName) throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		Reporter.log("User entered into Homepage", true);
		Thread.sleep(2000);
		Assert.assertEquals("LSAC Test Preparation", driver.getTitle());
	}


}
