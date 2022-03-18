package com.rmgyantra.validation;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {

	@Test
	public void validateStaticResponseTest() {
		String expectedProId="TY_PROJ_1209";
		
		Response resp = when()
			.get("http://localhost:8084/projects");
		resp.then().log().all();
			String actualProId = resp.jsonPath().get("[0].projectId");
			System.out.println(actualProId);
			
		Assert.assertEquals(actualProId, expectedProId);
	}
}
