package com.rmgyantra.parameter;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PathParametrTest {

	@Test
	public void pathPaaram() {
		
		
		String proId="TY_PROJ_1621";
		given()
			.pathParam("projectId",proId)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
			.log().all();
		
	}
}
