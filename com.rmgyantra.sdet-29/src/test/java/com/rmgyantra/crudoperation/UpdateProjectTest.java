package com.rmgyantra.crudoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProjectTest() {

		JSONObject obj=new JSONObject();
		obj.put("createdBy", "abhi");
		obj.put("projectName", "huwai");
		obj.put("status", "created");
		obj.put("teamSize", 10);

		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);

		Response res = req.put("http://localhost:8084/projects/TY_PROJ_1802");

		ValidatableResponse val = res.then();
		val.assertThat().statusCode(200);
		val.contentType(ContentType.JSON);

	}

	@Test
	public void patchProjectTest() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Abhishek");
		obj.put("job", "trainee");

		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);

		Response resp = req.patch("https://reqres.in/api/users/2");
		ValidatableResponse val = resp.then();
		val.assertThat().statusCode(200);

	}

}
