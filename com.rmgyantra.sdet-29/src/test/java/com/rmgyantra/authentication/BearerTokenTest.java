package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	
	@Test
	public void authentication() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
	}

}
