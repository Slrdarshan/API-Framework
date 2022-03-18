package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BasicAuthtest {

	@Test
	public void  auth() {
		given()
			.auth().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("http://localhost:8084/login")
		.then()
			.assertThat().statusCode(202)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
