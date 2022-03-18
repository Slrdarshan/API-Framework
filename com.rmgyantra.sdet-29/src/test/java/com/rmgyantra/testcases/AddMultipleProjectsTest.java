package com.rmgyantra.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AddMultipleProjectsTest {
	
	@Test(invocationCount=10)
	public void addMultipleProjectsTest() {
		
		 Random ran = new Random();
		 int random = ran.nextInt(1000);
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantraobj"+random);
		obj.put("status", "created");
		obj.put("teamSize", 10);
		
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
