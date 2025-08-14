package com.simplified.api.test.servicenow.som;

import com.simplified.api.test.base.RestAssuredBaseImpl;
import com.simplified.api.test.design.ResponseAPI;

import io.restassured.builder.RequestSpecBuilder;

public class ServiceNowBase {
	
	protected ResponseAPI response;
	protected RestAssuredBaseImpl restAssured = new RestAssuredBaseImpl();	
	protected RequestSpecBuilder requestBuilder;
	
	public RequestSpecBuilder commonSpec() {
		return new RequestSpecBuilder()
				.setBaseUri("https://dev214352.service-now.com");
	}

}