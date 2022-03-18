package com.rmgyantra.requestchaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAndDeleteUsertest {
	
	@Test
	public void createAndDelete() {
		
		
		Random randon = new Random();
		int ran = randon.nextInt(1000);
		
		JSONObject obj = new JSONObject();					
		obj.put("designation", "SDET-29");
		obj.put("dob", "25/05/1997");
		obj.put("email", "abhi@gmail.com");
		obj.put("empName", "Abhishek");
		obj.put( "experience", 2);
		obj.put( "mobileNo", "9888777657");
		obj.put("project", "expectedprojectName");
		obj.put("role", "ROLE_ADMIN");
		obj.put( "username", "Abhishek mulage"+ran);
		
		Response user = given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees");
		
		String employeeId = user.jsonPath().get("employeeId");
		System.out.println(employeeId);
		
		user.then()
			.log().all();
		given()
			.pathParam("empId", employeeId)
		.when()
			.delete("http://localhost:8084/employees/{empId}")
		.then()
		.assertThat().statusCode(204)
			.log().all();
	}
}
