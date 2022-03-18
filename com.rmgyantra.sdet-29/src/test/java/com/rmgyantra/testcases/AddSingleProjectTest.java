package com.rmgyantra.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddSingleProjectTest {

	@Test
	public void createSingleResousceWithCreatedStatusTest() {

		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantraobj");
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

	@Test
	public void createProjectWithOngoingStatusTest() {


		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra");
		obj.put("status", "ongoing");
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

	@Test
	public void createProjectWithCompletedStatusTest() {


		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra1");
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

	@Test
	public void createProjectWithInvalidStatusTest() {


		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra2");
		obj.put("status", "AABBB");
		obj.put("teamSize", 100);

		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		//.statusCode(500)
		.contentType(ContentType.JSON)
		.log().all();
	}

	@Test
	public void createDuplicateProjectTest() {
		

		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantraobj");
		obj.put("status", "created");
		obj.put("teamSize", 10);
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(409)
			.contentType(ContentType.JSON)
			.log().all();
	}
	
	
	@Test
	public void createProjectWithDuplicateIdTest() {
		
		//it will override the already existing project with new project
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra4");
		obj.put("projectId", "TY_PROJ_1209");
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
	
	@Test
	public void createProjectWithoutCreatedByTest() {
		
		JSONObject obj = new JSONObject();
		//obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra5");
	
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
	
	@Test
	public void createMutipleProjectTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantraobj");
		obj.put("status", "created");
		obj.put("teamSize", 10);
		
		JSONObject obj1 = new JSONObject();
		obj1.put("createdBy", "Abhishek");
		obj1.put("projectName", "Testyantraobj11");
		obj1.put("status", "created");
		obj1.put("teamSize", 10);
		
		given()
		.body(obj)
		.body(obj1)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject")
	.then()
		//.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();	
		
	}
	
	@Test
	public void createProjectWithoutStatus() {
		

		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra70");
		obj.put("status", "");
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
	
	@Test
	public void createProjectWithFutureDateTest() {
		

		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra9");
		obj.put("createdOn","10/10/2022");
		obj.put("status", "created");
		obj.put("teamSize", 10);
	//application will take system date by default(override the future date with system date)	
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
	
	@Test
	public void createProjectWithPastDateTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhishek");
		obj.put("projectName", "Testyantra10");
		obj.put("createdOn","10/10/2021");
		obj.put("status", "created");
		obj.put("teamSize", 10);
	//application will take system date by default(override the future date with system date)	
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
