package com.simplified.api.test.base;

import java.io.File;

import com.simplified.api.test.design.ApiClient;
import com.simplified.api.test.design.ResponseAPI;

import io.restassured.RestAssured;

import io.restassured.specification.RequestSpecification;

public class RestAssuredBaseImpl implements ApiClient {

	private RequestSpecification given(RequestSpecification request) {
		return RestAssured.given().spec(request);
	}

	public ResponseAPI get(RequestSpecification request, String endpoint) {
		return new RestAssuredResponseImpl(given(request).get(endpoint));
	}

	public ResponseAPI post(RequestSpecification request, String endpoint, Object payload) {
		if (payload instanceof String) {
			return new RestAssuredResponseImpl(given(request).body((String) payload).post(endpoint));
		} else if (payload instanceof File) {
			return new RestAssuredResponseImpl(given(request).body((File) payload).post(endpoint));
		} else {
			return new RestAssuredResponseImpl(given(request).body(payload).post(endpoint));
		}
	}

	public ResponseAPI put(RequestSpecification request, String endpoint, Object payload) {
		if (payload instanceof String) {
			return new RestAssuredResponseImpl(given(request).body((String) payload).put(endpoint));
		} else if (payload instanceof File) {
			return new RestAssuredResponseImpl(given(request).body((File) payload).put(endpoint));
		} else {
			return new RestAssuredResponseImpl(given(request).body(payload).put(endpoint));
		}
	}

	public ResponseAPI patch(RequestSpecification request, String endpoint, Object payload) {
		if (payload instanceof String) {
			return new RestAssuredResponseImpl(given(request).body((String) payload).patch(endpoint));
		} else if (payload instanceof File) {
			return new RestAssuredResponseImpl(given(request).body((File) payload).patch(endpoint));
		} else {
			return new RestAssuredResponseImpl(given(request).body(payload).patch(endpoint));
		}
	}

	public ResponseAPI delete(RequestSpecification request, String endpoint, Object payload) {
		return new RestAssuredResponseImpl(given(request).delete(endpoint));
	}

}