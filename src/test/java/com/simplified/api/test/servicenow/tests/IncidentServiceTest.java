package com.simplified.api.test.servicenow.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.simplified.api.test.servicenow.som.IncidentService;
import com.simplified.api.test.servicenow.som.OAuthService;

import io.restassured.http.ContentType;

public class IncidentServiceTest {
	
	IncidentService incidentService = new IncidentService();
	OAuthService oAuthService = new OAuthService();
	
	String payload = """
			{
			 "description": "create a new record using POST method",
			 "short_description": "RESTAPI"
			}			
			""";
	
	String sysId;
	
	@BeforeClass
	public void beforeClass() {
		incidentService
		    .setBaseUri("https://dev214352.service-now.com")
		    .setBasePath("/api/now/table")
		    .setBasicAuth("admin", "dLS9Qgs=V!0n");
		
		oAuthService
		    .setBaseUri("https://dev214352.service-now.com")
	        .setBasePath("/oauth_token.do");
	}
	
	@Test
	public void validateHardwareCategoryFilter() {		
		incidentService
		    .setQueryParam("sysparm_query", "category=hardware")
		    .fetchRecordsByCategory()
		    .validateJsonResponse(200, "OK")
		    .validateCategories("result.category", "hardware");		
	}
	
	@Test
	public void extraNewlyCreatedSysId() {		
		sysId = incidentService
				    .setContentType(ContentType.JSON)
				    .createRecord(payload)
				    .validateJsonResponse(201, "Created")
				    .extractSysId("result.sys_id");
		
		System.out.println(sysId);		
	}	
	
	@Test
	public void extractOAuthToken() {
		String token = oAuthService
				           .generateToken()
				           .validateJsonResponse(200, "OK")
				           .extractToken("access_token");
		
		System.out.println(token);
	}

}