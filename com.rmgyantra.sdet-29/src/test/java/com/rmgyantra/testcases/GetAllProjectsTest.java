package com.rmgyantra.testcases;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllProjectsTest {

	@Test
	public void getAllProjectsTest() {
		
		when()
			.get("http://localhost:8084/projects")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
	}
	
	@Test
	public void getAllTheProjectIds() {
		
		when()
		.get("http://localhost:8084/projects")
	.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.rootPath("projectId")
		.log().all();
	}
}
