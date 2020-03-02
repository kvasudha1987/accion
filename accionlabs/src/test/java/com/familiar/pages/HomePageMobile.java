package com.familiar.pages;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	@AndroidFindBy(id = "practiceLink")
	//@iOSFindBy(accessibility="")
	public WebElement tabLibrary;

	@AndroidFindBy(xpath = "//a[@id='practiceTestLink' and text()='The Official LSAT PrepTest 71']")
	//@iOSFindBy(accessibility="")
	public WebElement firstLink;

	@AndroidFindBy(id = "masterPage.The Official LSAT PrepTest 71")
	//@iOSFindBy(accessibility="")
	public WebElement firstTestTitle;

	@AndroidFindBy(id = "questionButton")
	//@iOSFindBy(accessibility="")
	public WebElement btnGoToQuestions;

	@AndroidFindBy(xpath = "//span[text()='Begin']")
	//@iOSFindBy(accessibility="")
	public WebElement txtBegin;

	@AndroidFindBy(xpath = "//div[@class=\"AnswerLetter\" and text()='A']")
	//@iOSFindBy(accessibility="")
	public WebElement q1Ansa;

	@AndroidFindBy(xpath = "//button[text()='Show Answer']")
	//@iOSFindBy(accessibility="")
	public WebElement btnShowAns;

	@AndroidFindBy(xpath = "//button[text()='Hide Answer']")
	//@iOSFindBy(accessibility="")
	public WebElement btnHideAns;

	@AndroidFindBy(xpath = "//div[@class='optionGridCorrectAnswer']")
	//@iOSFindBy(accessibility="")
	public WebElement gridCrtAns;

	@AndroidFindBy(xpath = "//img[@aria-controls='onNextChangeSuffix']")
	//@iOSFindBy(accessibility="")
	public WebElement btnNext;

	@AndroidFindBy(xpath = "//button[text()='Complete Section']")
	//@iOSFindBy(accessibility="")
	public WebElement btnCompleteSection;

	@AndroidFindBy(xpath = "//div[@class='text-center col-3']")
	//@iOSFindBy(accessibility="")
	public WebElement score;

	@AndroidFindBy(id = "tutorialsLink")
	//@iOSFindBy(accessibility="")
	public WebElement tabTutorials;

	@AndroidFindBy(xpath = "//a[contains(text(),'Answering Test Questions (with Narration) - 9:17m')]")
	//@iOSFindBy(accessibility="")
	public WebElement videolink;

	@AndroidFindBy(xpath = "//span[contains(text(),'Transcript')]")
	//@iOSFindBy(accessibility="")
	public WebElement transcript;
	
	@AndroidFindBy(xpath="//i[@class='fa fa-play']")
	//@iOSFindBy(accessibility="")
	public WebElement btnPlay;
	
	@AndroidFindBy(id="playControls")
	//@iOSFindBy(accessibility="")
	public WebElement playCtrls;
	
	
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
	
	public void startTest1() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		firstLink.click();
		wait.until(ExpectedConditions.visibilityOf(firstTestTitle));
		txtBegin.click();
		btnGoToQuestions.click();
		int qno = driver
				.findElements(By.xpath(
						"//nav[@class='itemNavigationBar navbar navbar-expand-md navbar-light bg-light']//div[2]"))
				.size();
		System.out.println(qno);
		for (int i = 1; i < qno - 2; i++) {
			q1Ansa.click();
			btnShowAns.click();
			wait.until(ExpectedConditions.visibilityOf(btnHideAns));
			wait.until(ExpectedConditions.visibilityOf(gridCrtAns));
			btnNext.click();
		}
		btnCompleteSection.click();
		wait.until(ExpectedConditions.visibilityOf(score));
		String acqscore = score.getText();
		System.out.println(acqscore);
	}
	public void startTutorial1() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		tabTutorials.click();
		videolink.click();
		wait.until(ExpectedConditions.visibilityOf(transcript)); 
		btnPlay.click();
		wait.until(ExpectedConditions.visibilityOf(playCtrls));
	}


}

