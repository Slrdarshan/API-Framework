package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParametertest {
	
	@Test
	public void queryParameter() {
		
		given()
			.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.log().all();
		
	}

}
