package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParameterTest {

	@Test
	public void parameters() {
		
		given()
			.pathParam("username", "MulageAbhi")
			.queryParam("sort", "created")
			.queryParam("page", 2)
		.when()
			.get("https://api.github.com/users/{username}/repos")
		.then()
			.log().all();
	}
}
