package com.simplified.api.test.servicenow.som;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class OAuthService extends ServiceNowBase {
	
	public OAuthService() {
		requestBuilder = commonSpec().setBasePath("/oauth_token.do");
	}
	
	public OAuthService generateToken() {
		Map<String, String> forms = new HashMap<String, String>();
		forms.put("grant_type", "password");
		forms.put("client_id", "970096e343c3221040322689d033ce18");
		forms.put("client_secret", "$!hXpkhMfb");
		forms.put("username", "admin");
		forms.put("password", "ay*lPG$Va97D");
		response = restAssured.post(requestBuilder.setContentType(ContentType.URLENC).build(), forms);
		return this;
	}
	
	public OAuthService validateJsonResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}
	
	public String extractToken(String jsonPath) {
		JsonPath json = new JsonPath(response.getBody());
		return json.getString(jsonPath);
	}

}