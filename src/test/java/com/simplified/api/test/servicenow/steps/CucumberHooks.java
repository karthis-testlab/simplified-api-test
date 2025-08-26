package com.simplified.api.test.servicenow.steps;

import com.simplified.api.test.servicenow.som.OAuthService;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class CucumberHooks {

	private TestContext context;
	private static String token;

	public CucumberHooks(TestContext context) {
		this.context = context;
	}

	@BeforeAll
	public static void createOAuthToken() {
		token = new OAuthService()
				      .setBaseUri("https://dev214352.service-now.com")
				      .generateToken().validateJsonResponse(200, "OK").extractToken();				
	}
	
	@Before
	public void beforeScenario() {
		context.setContext("access_token", token);
	}

}