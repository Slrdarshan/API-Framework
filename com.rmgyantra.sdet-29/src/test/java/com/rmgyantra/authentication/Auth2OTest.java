package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2OTest {

	
	@Test
	public void authentication() {
		Response resp = given()
			.formParam("client_id", "AbhiMulageSDET-29")
			.formParam("client_secret", "3f78b7b0fe13b24b4bb5a8bb419519f1")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token=resp.jsonPath().get("access_token");
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 2949)
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()
			.log().all();			
		
	}
	
	@Test
	public void authentication1() {
		Response resp = given()
			.formParam("client_id", "AbhiMulageSDET-29")
			.formParam("client_secret", "3f78b7b0fe13b24b4bb5a8bb419519f1")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token=resp.jsonPath().get("access_token");
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 2949)
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
			.log().all();					
	}
	
	@Test
	public void authentication3() {
		Response resp = given()
			.formParam("client_id", "AbhiMulageSDET-29")
			.formParam("client_secret", "3f78b7b0fe13b24b4bb5a8bb419519f1")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token=resp.jsonPath().get("access_token");
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 2949)
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
			.log().all();					
	}
	
	@Test
	public void authentication4() {
		Response resp = given()
			.formParam("client_id", "AbhiMulageSDET-29")
			.formParam("client_secret", "3f78b7b0fe13b24b4bb5a8bb419519f1")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		String token=resp.jsonPath().get("access_token");
		given()
			.auth().oauth2(token)
			.pathParam("USER_ID", 2949)
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/toiletseat-down")
		.then()
			.log().all();					
	}
}
