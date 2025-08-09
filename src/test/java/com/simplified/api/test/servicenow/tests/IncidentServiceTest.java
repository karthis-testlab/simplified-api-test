package com.simplified.api.test.servicenow.tests;

import org.testng.annotations.Test;

import com.simplified.api.test.servicenow.som.IncidentService;
import com.simplified.api.test.servicenow.som.OAuthService;

public class IncidentServiceTest {
	
	String payload = """
			{
			 "description": "create a new record using POST method",
			 "short_description": "RESTAPI"
			}			
			""";
	
	String sysId;
	
	@Test
	public void validateHardwareCategoryFilter() {
		
		new IncidentService()
		    .fetchRecordsByCategory("hardware")
		    .validateJsonResponse(200, "OK")
		    .validateCategories("result.category", "hardware");
		
	}
	
	@Test
	public void extraNewlyCreatedSysId() {
		
		sysId = new IncidentService()
				    .createRecord(payload)
				    .validateJsonResponse(201, "Created")
				    .extractSysId("result.sys_id");
		
		System.out.println(sysId);
		
	}	
	
	@Test
	public void extractOAuthToken() {
		String token = new OAuthService()
				           .generateToken()
				           .validateJsonResponse(200, "OK")
				           .extractToken("access_token");
		
		System.out.println(token);
	}

}