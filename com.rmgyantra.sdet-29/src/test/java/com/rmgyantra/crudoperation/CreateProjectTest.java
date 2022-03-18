package com.rmgyantra.crudoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

	
	@Test
	public void createProjectTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Abhi");
		obj.put("projectName", "samsung109");
		obj.put("status", "created");
		obj.put("teamSize", 9);
		
		RequestSpecification reqspe =RestAssured.given();
		reqspe.body(obj);
		reqspe.contentType(ContentType.JSON);
		
		
		Response resp = reqspe.post("http://localhost:8084/addProject");
		ValidatableResponse val = resp.then();
		
		val.assertThat().statusCode(201);
		val.assertThat().contentType(ContentType.JSON);
		val.log().all();
	}
}
