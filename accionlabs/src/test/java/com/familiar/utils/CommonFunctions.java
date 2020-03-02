package com.familiar.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class CommonFunctions {
	// Constructor
	public AndroidDriver<?> driver;

	public CommonFunctions(AndroidDriver<?> driver) {
		this.driver = (AndroidDriver<?>) driver;
	}

	public void reset_app() {
		driver.resetApp();
	}

	// SwipeUp
	public void swipeUp() {
		Dimension size = driver.manage().window().getSize();
		int widthAnchor = (int) (size.width * 0.3);
		int startheight = (int) (size.height * 0.2);
		int endHeight = (int) (size.height * 0.8);

		new TouchAction(driver).press(widthAnchor, startheight).waitAction(5).moveTo(widthAnchor, endHeight).release()
				.perform();

	}

	// Screenshots
	public boolean takeScreenshot(final String name) {
		// AWS Screenshot
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}
}
