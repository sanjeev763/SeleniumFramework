package com.devcolor.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.devcolor.qa.base.TestBase2;
import com.devcolor.qa.pages.AboutPage;
import com.devcolor.qa.pages.HomePage;
import com.devcolor.qa.utils.CommonFunctionality;

public class AboutPageTest extends TestBase2{
	AboutPage aboutPage;
	HomePage homePage;
	CommonFunctionality commonFunctions;
	
	public AboutPageTest() {
		super();
	} 
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		aboutPage = new AboutPage();
		homePage = new HomePage();
		commonFunctions = new CommonFunctionality();
	}

	@Test(priority = 1)
	public void aboutPageTitleTest() {
		homePage.clickAboutOnHomePage();
		String pageTitleString = aboutPage.validateAboutPageTitle();
		Assert.assertEquals(pageTitleString, "About - DevColor");
	}
	
	@Test(priority = 2)
	public void topTextTest() {
		homePage.clickAboutOnHomePage();
		Assert.assertEquals("/about", commonFunctions.verifyTopText());	
	}
	
	@Test(priority = 3)
	public void giveNowBtnTest() {
		homePage.clickAboutOnHomePage();
		aboutPage.scrollToElement(aboutPage.getInvolvedTextElement);
		aboutPage.verifyGiveNowBtn();
		aboutPage.verifyMemberjoinusBtn();
		aboutPage.verifyPartnerjoinusBtn();
	}
	
	@Test(priority = 4)
	public void memberjoinusBtnTest() {
		homePage.clickAboutOnHomePage();
		aboutPage.scrollToElement(aboutPage.getInvolvedTextElement);
		aboutPage.verifyMemberjoinusBtn();
	}
	@Test(priority = 5)
	public void partnerjoinusBtnTest() {
		homePage.clickAboutOnHomePage();
		aboutPage.scrollToElement(aboutPage.getInvolvedTextElement);
		aboutPage.verifyPartnerjoinusBtn();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
