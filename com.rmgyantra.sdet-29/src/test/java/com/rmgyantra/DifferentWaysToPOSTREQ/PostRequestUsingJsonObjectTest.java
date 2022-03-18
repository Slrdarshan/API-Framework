package com.rmgyantra.DifferentWaysToPOSTREQ;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingJsonObjectTest {
	
	@Test
	public void createResourceUsingJsonObjectTes() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "huwai11");
		obj.put("status", "created");
		obj.put("teamSize", 100);
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
	}

}
