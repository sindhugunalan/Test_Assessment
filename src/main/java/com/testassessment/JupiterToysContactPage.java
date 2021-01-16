package com.testassessment;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;

public class JupiterToysContactPage {
	private HashMap<String, By> testElements = new HashMap<>();

	protected JupiterToysContactPage() {
		addTestElement();
	}

	public Map<String, By> addTestElement()

	{
		testElements.put("contact", By.xpath("//a[text() ='Contact']"));
		testElements.put("submit", By.xpath("//a[text()='Submit']"));
		testElements.put("allErrors", By.xpath("//span[contains(@id,'-err')]"));
		testElements.put("forenameError", By.xpath("//span[@id='forename-err']"));
		testElements.put("emailError", By.xpath("//span[@id='email-err']"));
		testElements.put("validEmailError",
				By.xpath("//span[@id='email-err' and text()='Please enter a valid email']"));
		testElements.put("messageError", By.xpath("//span[@id='message-err']"));
		testElements.put("forenameTextbox",
				By.xpath("//label[contains(text(),'Forename ')]/../div/input[@id='forename']"));
		testElements.put("emailTextbox", By.xpath("//label[contains(text(),'Email')]/../div/input[@id='email']"));
		testElements.put("messageTextbox",
				By.xpath("//label[contains(text(),'Message')]/../div/textarea[@id='message']"));
		testElements.put("contactDetailsSuccess", By.xpath("//div/strong[contains(text(),'Thanks')]"));
		testElements.put("startShopping", By.xpath("//a[contains(text(),'Start Shopping')]"));
		testElements.put("funnyCowBuy", By.xpath("//h4[contains(text(),'Funny Cow')]/../p/a[contains(text(),'Buy')]"));
		testElements.put("fluffyBunnyBuy",
				By.xpath("//h4[contains(text(),'Fluffy Bunny')]/../p/a[contains(text(),'Buy')]"));
		testElements.put("cart", By.xpath("//a[contains(text(),'Cart')]"));
		testElements.put("funnyCowCartItem",
				By.xpath("//td[contains(text(),'Funny Cow')]/../td/input[@name='quantity']"));
		testElements.put("fluffyBunnyCartItem",
				By.xpath("//td[contains(text(),'Fluffy Bunny')]/../td/input[@name='quantity']"));

		return testElements;
	}

	public By getLocator(String locatorString) {
		return testElements.get(locatorString);
	}

}
