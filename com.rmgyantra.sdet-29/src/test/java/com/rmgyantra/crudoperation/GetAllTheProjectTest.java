package com.rmgyantra.crudoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllTheProjectTest {

	@Test
	public void getProjectTest() {
		
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(resp.contentType());
		System.out.println(resp.statusCode());
		System.out.println(resp.body());
		System.out.println(resp.getTime());
		
	//resp.prettyPrint();
		//resp.prettyPeek();
		//resp.asString();
	}
}
