package com.testassessment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class provides the Selenium actions that is required for the test
 * 
 * @author Sindhu
 *
 */
public class SeleniumAction {

	private SeleniumAction() {

	}

	/**
	 * This method enter the text in the browser
	 * 
	 * @author Sindhu
	 *
	 */
	public static void enterText(WebDriver driver, By locatorString, String data) {
		wait(driver, locatorString);
		WebElement element = driver.findElement(locatorString);
		element.sendKeys(data + Keys.ENTER);
	}

	/**
	 * This method provides click functionality
	 * 
	 * @author Sindhu
	 *
	 */

	public static void click(WebDriver driver, By locatorString) {
		wait(driver, locatorString);
		driver.findElement(locatorString).click();
	}

	/**
	 * This method captures the text from browser
	 * 
	 * @author Sindhu
	 *
	 */

	public static String getLabel(WebDriver driver, By locatorString) {
		wait(driver, locatorString);
		return driver.findElement(locatorString).getText();
	}

	/**
	 * This method captures the required attributes from browser
	 * 
	 * @author Sindhu
	 *
	 */

	public static String getAttribute(WebDriver driver, By locatorString, String attribute) {
		wait(driver, locatorString);
		return driver.findElement(locatorString).getAttribute(attribute);
	}

	/**
	 * This method captures the size of elements matching the string
	 * 
	 * @author Sindhu
	 *
	 */
	public static int getCount(WebDriver driver, By locatorString) {
		wait(driver, locatorString);
		return driver.findElements(locatorString).size();

	}

	private static void wait(WebDriver driver, By locatorString) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, 30).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorString));
		wait.until(ExpectedConditions.elementToBeClickable(locatorString));
	}

	/**
	 * This method selects the option from dropdown
	 * 
	 * @author Sindhu
	 *
	 */
	public static void dropdown(WebDriver driver, By locatorString, String data) {
		wait(driver, locatorString);
		Select dropdown = new Select(driver.findElement(locatorString));
		dropdown.selectByVisibleText(data);

	}

	/**
	 * This method check if the element is present
	 * 
	 * @author Sindhu
	 *
	 */
	public static boolean elementExistance(WebDriver driver, By locatorString) {
		boolean count = false;
		try {
			FluentWait<WebDriver> wait = new WebDriverWait(driver, 30).pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locatorString));
			if (driver.findElements(locatorString).size() == 1) {
				count = true;
			}

		} catch (TimeoutException | NoSuchElementException e) {
			Thread.currentThread().interrupt();
		}
		return count;
	}

	/**
	 * This method check if element is not present
	 * 
	 * @author Sindhu
	 *
	 */
	public static boolean elementNotPresent(WebDriver driver, By locatorString) {
		boolean count = false;
		try {
			FluentWait<WebDriver> wait = new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locatorString));
			count = true;

		} catch (TimeoutException | NoSuchElementException e) {
			Thread.currentThread().interrupt();
		}
		return count;
	}

	/**
	 * This method returns the value of the element
	 * 
	 * @author Sindhu
	 *
	 */
	public static String getElementValue(WebDriver driver, By locatorString) {
		wait(driver, locatorString);
		return driver.findElement(locatorString).getAttribute("value");

	}

}
