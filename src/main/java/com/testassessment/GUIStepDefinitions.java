package com.testassessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GUIStepDefinitions {

	WebDriver driver;
	private Scenario scenario;
	JupiterToysContactPage JTContact = new JupiterToysContactPage();

	/**
	 * This method is initiated before running any test to fetch the WebDriver.
	 */
	@Before("@GUI")

	public void init(Scenario scenario) {
		this.scenario = scenario;
		driver = new ChromeDriverImpl().getWebDriver();

	}

	@Given("^I navigate to \"([^\"]*)\"$")
	public void openCalculator(String url) {
		driver.get(url);
	}

	@Then("^I navigate to page \"([^\"]*)\"$")
	public void navigatePage(String pageName) {
		SeleniumAction.click(driver, JTContact.getLocator(pageName));
	}

	@Then("I submit the contact details")
	public void contactDetailsSubmit() {
		SeleniumAction.click(driver, JTContact.getLocator("submit"));
	}

	@Then("I verify the below details")
	public void errorValidation(DataTable dataSet) throws FrameworkException {
		List<Map<String, String>> testData = dataSet.asMaps(String.class, String.class);
		for (int i = 0; i < testData.size(); i++) {
			String errorElement = testData.get(i).get("Element");
			if (testData.get(i).get("Visibility").equalsIgnoreCase("present")) {
				assertTrue("The " + errorElement + " is  present",
						SeleniumAction.elementExistance(driver, JTContact.getLocator(errorElement)));
				scenario.log("The " + errorElement + " is present ");

			} else if (testData.get(i).get("Visibility").equalsIgnoreCase("not present")) {
				assertTrue("The " + errorElement + " is not  present",
						SeleniumAction.elementNotPresent(driver, JTContact.getLocator(errorElement)));
				scenario.log("The " + errorElement + " is not present");
			} else {
				scenario.log("Invalid visibility type");
				throw new FrameworkException("Invalid visibility type", null);

			}

		}

	}

	@Then("I enter contact details")
	public void contactDetails(DataTable dataSet) {
		List<Map<String, String>> testData = dataSet.asMaps(String.class, String.class);
		SeleniumAction.enterText(driver, JTContact.getLocator("forenameTextbox"), testData.get(0).get("Forename"));
		SeleniumAction.enterText(driver, JTContact.getLocator("emailTextbox"), testData.get(0).get("Email"));
		SeleniumAction.enterText(driver, JTContact.getLocator("messageTextbox"), testData.get(0).get("message"));
	}

	@Then("I add the below items to cart")
	public void addItem(DataTable dataSet) {
		List<Map<String, String>> testData = dataSet.asMaps(String.class, String.class);
		for (int i = 0; i < testData.size(); i++) {
			SeleniumAction.click(driver, JTContact.getLocator(testData.get(i).get("Item")));
		}
	}

	@Then("I validate the below items in the cart")
	public void validateCart(DataTable dataSet) {
		SeleniumAction.click(driver, JTContact.getLocator("cart"));
		List<Map<String, String>> testData = dataSet.asMaps(String.class, String.class);
		for (int i = 0; i < testData.size(); i++) {
			String itemName = testData.get(i).get("Item");
			String quantity = testData.get(i).get("Quantity");
			assertTrue("The " + itemName + " is present",
					SeleniumAction.elementExistance(driver, JTContact.getLocator(itemName)));
			assertEquals(quantity, SeleniumAction.getElementValue(driver, JTContact.getLocator(itemName)));
			scenario.log(quantity + " " + itemName + " is present");
		}
	}

	@After("@GUI")
	public void cleanUp() {
		driver.close();
		driver.quit();
	}
}
