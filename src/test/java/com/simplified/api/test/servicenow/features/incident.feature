Feature: Servicenow API incident feature scenarios validation

Scenario: Validate user should able fetch the all incident table records
Given user should set the base uri as "https://dev214352.service-now.com" in the api client
And user should set the base path "/api/now/table" of the service now table api
And user should set the basic authentication user name as "admin" and password as "dLS9Qgs=V!0n"
When user should hit the get request of the "incident" table
Then user should able to see the success response and with relevant status code and message

Scenario: Validate user should able fetch the all incident table records using OAuth access token
Given user should set the base uri as "https://dev214352.service-now.com" in the api client
And user should set the base path "/api/now/table" of the service now table api
And user should set the OAuth token to access the service now table apis
When user should hit the get request of the "incident" table
Then user should able to see the success response and with relevant status code and message