package com.simplified.api.test.servicenow.som;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class IncidentService extends ServiceNowBase {

	private static final String TABLE_NAME = "/incident";
	
	public IncidentService() {
		requestBuilder = commonSpec().setBasePath("/api/now/table");
	}

	public IncidentService fetchIncidentRecords() {
		response = restAssured.get(requestBuilder.build(), TABLE_NAME);
		return this;
	}
	
	public IncidentService fetchIncidentRecord(String sys_id) {
		response = restAssured.get(requestBuilder.build(), TABLE_NAME+"/"+sys_id);
		return this;
	}
	
	public IncidentService fetchRecordsByCategory(String category) {		
		response = restAssured.get(requestBuilder
				                   .addQueryParam("sysparm_query", "category="+category)
				                   .build()
				                   , TABLE_NAME);
		return this;
	}
	
	public IncidentService createRecord(String payload) {
		response = restAssured.post(requestBuilder
				                     .setContentType(ContentType.JSON)
				                     .build(), 
				                     TABLE_NAME, 
				                     payload);
		return this;
	}

	public IncidentService validateJsonResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}

	public IncidentService validateXmlResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}
	
	public String extractSysId(String jsonPath) {
		JsonPath json = new JsonPath(response.getBody());
		return json.getString(jsonPath);
	}
	
	public void validateCategories(String jsonPath, String expected) {
		JsonPath json = new JsonPath(response.getBody());
		List<String> categories = json.getList(jsonPath);
		for (String category : categories) {
			MatcherAssert.assertThat(category, Matchers.equalToIgnoringCase(expected));
		}
	}

}