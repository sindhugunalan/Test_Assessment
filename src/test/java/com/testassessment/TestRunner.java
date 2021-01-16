package com.testassessment;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*TO Run the Junit with Specific Feature File*/

@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report.html", "json:target/cucumber-json/cucumber.json",
		"junit:target/cucumber.xml" }, monochrome = true, features = "src/test/resources", glue = {
				"com.testassessment" }, tags = "@GUI")

public class TestRunner {

}
