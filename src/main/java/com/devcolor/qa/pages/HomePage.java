package com.devcolor.qa.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.devcolor.qa.base.TestBase2;

public class HomePage extends TestBase2{

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"primary-menu-list\"]/li/a[contains(text(),'about')]")
	WebElement aboutLink;     
	
	public void clickAboutOnHomePage() {
		aboutLink.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'/about') and @class='has-inline-color']")));
	}

}
