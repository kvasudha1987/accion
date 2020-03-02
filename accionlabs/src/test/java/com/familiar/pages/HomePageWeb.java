package com.familiar.pages;

import java.io.IOException;
import java.util.Hashtable;

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

public class HomePageWeb extends TestBase {
	public WebDriver driver;

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@FindBy(id = "practiceLink")
	public WebElement tabLibrary;

	@FindBy(xpath = "//a[@id='practiceTestLink' and text()='The Official LSAT PrepTest 71']")
	public WebElement firstLink;

	@FindBy(id = "masterPage.The Official LSAT PrepTest 71")
	public WebElement firstTestTitle;

	@FindBy(id = "questionButton")
	public WebElement btnGoToQuestions;

	@FindBy(xpath = "//span[text()='Begin']")
	public WebElement txtBegin;

	@FindBy(xpath = "//div[@class=\"AnswerLetter\" and text()='A']")
	public WebElement q1Ansa;

	@FindBy(xpath = "//button[text()='Show Answer']")
	public WebElement btnShowAns;

	@FindBy(xpath = "//button[text()='Hide Answer']")
	public WebElement btnHideAns;

	@FindBy(xpath = "//div[@class='optionGridCorrectAnswer']")
	public WebElement gridCrtAns;

	@FindBy(xpath = "//img[@aria-controls='onNextChangeSuffix']")
	public WebElement btnNext;

	@FindBy(xpath = "//button[text()='Complete Section']")
	public WebElement btnCompleteSection;

	@FindBy(xpath = "//div[@class='text-center col-3']")
	public WebElement score;

	@FindBy(id = "tutorialsLink")
	public WebElement tabTutorials;

	@FindBy(xpath = "//a[contains(text(),'Answering Test Questions (with Narration) - 9:17m')]")
	public WebElement videolink;

	@FindBy(xpath = "//span[contains(text(),'Transcript')]")
	public WebElement transcript;

	public HomePageWeb(WebDriver driver) {
		this.driver = driver;
		setDriver(driver);
		PageFactory.initElements(driver, this);
	}

	public void homepagetitle(WebDriver driver, String testName) throws InterruptedException, IOException {
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
}
