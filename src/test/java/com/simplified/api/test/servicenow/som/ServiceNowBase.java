package com.simplified.api.test.servicenow.som;

import com.simplified.api.test.base.RestAssuredBaseImpl;
import com.simplified.api.test.design.ResponseAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class ServiceNowBase {
	
	protected ResponseAPI response;
	protected RestAssuredBaseImpl restAssured = new RestAssuredBaseImpl();	
	protected RequestSpecBuilder requestBuilder;
	
	public RequestSpecBuilder commonSpec() {
		return new RequestSpecBuilder()
				.setBaseUri("https://dev271917.service-now.com")				
				.setAuth(RestAssured.basic("admin", "ay*lPG$Va97D"));
	}

}