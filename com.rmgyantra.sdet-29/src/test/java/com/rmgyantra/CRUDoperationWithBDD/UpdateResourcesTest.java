package com.rmgyantra.CRUDoperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateResourcesTest {

	@Test
	public void completeUpdateTest() {
		
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "saony");
		obj.put("status", "complted");
		obj.put("teamSize",11);
		

		given()
			.contentType(ContentType.JSON)
			.body(obj)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_2002")
		.then()
			.assertThat().statusCode(200)
			.assertThat().contentType(ContentType.JSON)
			.log().all();
		
		
	}
	
	@Test
	public void partialUpdation() {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "abhishek");
		obj.put("job", "trainee");
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.patch("https://reqres.in/api/users/2")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
	}
}
