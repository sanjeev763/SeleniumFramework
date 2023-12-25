package com.devcolor.qa.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	static Properties prop;
	
	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/krsk1/eclipse-workspace/DevColorProject/src/main/java/com/devcolor"
				+ "/qa/config/config.properties");
		prop.load(ip);
	}
	
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browsername.equals("FF")){
			driver = new FirefoxDriver();
		}
	}
	
//	driver.manage().window().maximize();
//	driver.manage().deleteAllCookies();
//	driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//	driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
	
//	driver.get(prop.getProperty("url"));

}
