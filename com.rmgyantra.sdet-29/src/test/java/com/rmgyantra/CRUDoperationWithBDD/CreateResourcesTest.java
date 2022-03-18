package com.rmgyantra.CRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class CreateResourcesTest {

	
	@Test
	public void createProjectTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "AB");
		obj.put("projectName","Chailover");
		obj.put("status", "created");
		obj.put("teamSize", 12);
		
		
		
		given()
			.contentType(ContentType.JSON)
			.body(obj)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
