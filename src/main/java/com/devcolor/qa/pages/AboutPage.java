package com.devcolor.qa.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.devcolor.qa.base.TestBase2;


public class AboutPage extends TestBase2{

	public AboutPage() throws IOException {
		super();
		// Initializing page object
		PageFactory.initElements(driver, this);
		
	}
	
	//Page factory 
	@FindBy(className = "has-inline-color")
	WebElement pagenametext;
	
	@FindBy(xpath = "//h2[contains(text(),'get involved')]")
	public WebElement getInvolvedTextElement;
	
	@FindBy(xpath = "//*[@class=\"wp-block-button__link\" and contains(text(),'give now')]")
	public
	WebElement givenowBtn;
	
	@FindBy(xpath = "//*[@class=\"wp-block-button__link\" and contains(@href,'joinus')]")
	WebElement memberJoinUsBtn;
	
	@FindBy(xpath = "//*[@class=\"wp-block-button__link\" and contains(@href,'partnerships')]")
	WebElement partnershipJoinUsBtn;
	
	@FindBy(xpath = "//button[contains(@class,'slick-prev')]")
	WebElement prevslideArroW;
	
	@FindBy(xpath = "//button[contains(@class,'slick-next')]")
	WebElement nxtslideArroW;
	
	@FindBy(xpath = "//*[contains(@class,'extra slick-slide') and (@data-slick-index='1')]")
	WebElement memberStorySlide;
	
	@FindBy(xpath = "//*[@class='extra slick-slide slick-current slick-active slick-center']")
	WebElement activeMemSlide;
	
	@FindBy(xpath = "//*[@class='extra slick-slide slick-current slick-active slick-center']//a")
	WebElement activeMemSlideReadMore;
	
	@FindBy(xpath = "//a[@download='devcolor-end-of-year-report']")
	WebElement yearReportDownloadCTA;
	
	
	public String validateAboutPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyPageNameText() {
		return pagenametext.isDisplayed();
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyGiveNowBtn() {
		givenowBtn.isDisplayed();
		givenowBtn.click();
		ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsList.get(1));
		
		String givenowurl = driver.getCurrentUrl();
		System.out.println("give now redirected url : "+givenowurl);
		Assert.assertTrue(givenowurl.contains("donation/checkout"));
		String givenowtitle = driver.getTitle();
		System.out.println("give now redirected title : "+givenowtitle);
		Assert.assertEquals(givenowtitle, "DEV/COLOR");
		
	}
	
	public void verifyMemberjoinusBtn() {
		memberJoinUsBtn.isDisplayed();
		memberJoinUsBtn.click();
		ArrayList<String> tabsList = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsList.get(1));
		
		String memjoinusurl = driver.getCurrentUrl();
		System.out.println("member join us redirected url : "+memjoinusurl);
		Assert.assertTrue(memjoinusurl.contains("joinus"));
	}
	public void verifyPartnerjoinusBtn() {
		partnershipJoinUsBtn.isDisplayed();
		partnershipJoinUsBtn.click();
		String partnerjoinusurl = driver.getCurrentUrl();
		System.out.println("partner join us redirected url : "+partnerjoinusurl);
		Assert.assertTrue(partnerjoinusurl.contains("partnerships"));
		driver.navigate().back();;
		
		
	}
	
}
