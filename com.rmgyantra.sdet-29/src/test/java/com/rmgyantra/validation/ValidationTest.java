package com.rmgyantra.validation;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidationTest {
	
	@Test
	public void val() {
		
		String expHeader="Access-Control-Request-Headers";
		String expContentType="application/json";
		
		Response resp = when()
			.get("http://localhost:8084/projects/TY_PROJ_1209");
		String actualHeader = resp.getHeader("Vary");
		String actualContentType = resp.contentType();
		
		Assert.assertEquals(actualHeader, expHeader);
		Assert.assertEquals(actualContentType, expContentType);
	}

}
