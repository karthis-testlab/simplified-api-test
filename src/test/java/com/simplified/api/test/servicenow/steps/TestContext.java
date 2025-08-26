package com.simplified.api.test.servicenow.steps;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

	Map<String, String> context;

	public TestContext() {
		context = new HashMap<>();
	}

	public String getContext(String key) {
		return context.get(key);
	}

	public void setContext(String key, String value) {
		context.put(key, value);
	}

}