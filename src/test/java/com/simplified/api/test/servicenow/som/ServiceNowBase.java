package com.simplified.api.test.servicenow.som;

import com.simplified.api.test.base.RestAssuredBaseImpl;
import com.simplified.api.test.design.ResponseAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class ServiceNowBase {
	
	protected ResponseAPI response;
	protected RestAssuredBaseImpl restAssured = new RestAssuredBaseImpl();	
	protected RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
	
	public RequestSpecBuilder baseUri(String baseUri) {
		return requestBuilder
				.setBaseUri(baseUri);
	}
	
	public RequestSpecBuilder basePath(String basePath) {
		return requestBuilder
				.setBasePath(basePath);
	}
	
	public RequestSpecBuilder basicAuth(String username, String password) {
		return requestBuilder
				.setAuth(RestAssured.basic(username, password));
	}
	
	public RequestSpecBuilder contentType(ContentType contentType) {
		return requestBuilder
				.setContentType(contentType);
	}
	
	public RequestSpecBuilder queryParam(String key, String value) {
		return requestBuilder
				.addQueryParam(key, value);
	}

}