package com.devcolor.qa.utils;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.devcolor.qa.base.TestBase2;

public class CommonFunctionality extends TestBase2{
	public CommonFunctionality() throws IOException {
		super();
		// Initializing page object
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "has-inline-color")
	WebElement pagenametext;
	
	public String validatePageTitle() {
		return driver.getTitle();
		
	}
	
	public String verifyTopText() {
		String topText = pagenametext.getText();
		return topText;
	}

}
