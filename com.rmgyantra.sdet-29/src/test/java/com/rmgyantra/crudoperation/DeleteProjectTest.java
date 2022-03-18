package com.rmgyantra.crudoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {

	@Test
	public void deleteProjectTest() {
		
		Response res = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1012");
		ValidatableResponse val = res.then();
		val.assertThat().statusCode(204);		
		
	}
}
