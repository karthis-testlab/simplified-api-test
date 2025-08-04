package com.simplified.api.test.design;

import io.restassured.specification.RequestSpecification;

public interface ApiClient {
	
	ResponseAPI get(RequestSpecification request, String endpoint);
	ResponseAPI post(RequestSpecification request, String endpoint, Object payload);
	ResponseAPI put(RequestSpecification request, String endpoint, Object payload);
	ResponseAPI patch(RequestSpecification request, String endpoint, Object payload);
	ResponseAPI delete(RequestSpecification request, String endpoint, Object payload);

}