package com.rmgyantra.requestchaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChaininWithGetReqTest {

	@Test
	public void requestChaining() {
		
		Response resp = when()
				.get("http://localhost:8084/projects");
			String proId = resp.jsonPath().get("[0].projectId");
			
			given()
				.pathParam("projectId",proId)
			.when()
				.delete("http://localhost:8084/projects/{projectId}")
			.then()
				.assertThat().statusCode(204)
				.log().all();
	}
}
