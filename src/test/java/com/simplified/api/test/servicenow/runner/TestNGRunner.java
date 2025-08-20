package com.simplified.api.test.servicenow.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/com/simplified/api/test/servicenow/features/incident.feature"},
		          glue = {"com.simplified.api.test.servicenow.steps"},
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-reports/result.html"
		          }
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}