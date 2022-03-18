package com.rmgyantra.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ModifyProjectTest {

	@Test
	public void modifyResourcesTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra13");
		obj.put("status", "created");
		obj.put("teamSize", 10);
	
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1209")
		.then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
		
	}
}
