package com.testassessment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class initializes ChromeDriver. ChromeDriver is used to run the UI test
 * 
 * @author Sindhu
 *
 */
public class ChromeDriverImpl {

	WebDriver chromeDriver;

	/***
	 * 
	 * @return chromedriver
	 */
	public WebDriver getWebDriver() {

		WebDriverManager.chromedriver().setup();
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		return chromeDriver;
	}

}
