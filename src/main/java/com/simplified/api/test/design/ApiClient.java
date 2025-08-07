package com.simplified.api.test.design;

import java.util.Map;

import io.restassured.specification.RequestSpecification;

public interface ApiClient {
	
	ResponseAPI get(RequestSpecification request, String endpoint);
	ResponseAPI post(RequestSpecification request, String endpoint, Object payload);
	ResponseAPI post(RequestSpecification request, Map<String, String> formParams);
	ResponseAPI put(RequestSpecification request, String endpoint, Object payload);
	ResponseAPI patch(RequestSpecification request, String endpoint, Object payload);
	ResponseAPI delete(RequestSpecification request, String endpoint, Object payload);

}