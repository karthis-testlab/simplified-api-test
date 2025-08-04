package com.simplified.api.test.servicenow.som;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ServiceNowBase {
	
	public RequestSpecification commonSpec() {
		return new RequestSpecBuilder()
				.setBaseUri("https://dev271917.service-now.com")
				.setBasePath("/api/now/table")
				.setAuth(RestAssured.basic("admin", "ay*lPG$Va97D"))
				.build();
	}

}