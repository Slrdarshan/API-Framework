package com.rmgyantra.requestchaining;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojo.classes.PojoClassForPostReq;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectAndAllocateUserTest {


	@Test
	public void endToEndTestCases() {
		
		Random randon = new Random();
		int ran = randon.nextInt(1000);
		PojoClassForPostReq pojo = new PojoClassForPostReq("Abhishek Mulage", "Oppo reno"+ran, "Completed",40);
		
		Response resp = given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
		String expectedprojectName = resp.jsonPath().get("projectName");
		System.out.println(expectedprojectName);
		resp.then()
			.assertThat().statusCode(201)
			.log().all();
		
		JSONObject obj = new JSONObject();					
		obj.put("designation", "SDET-29");
		obj.put("dob", "25/05/1997");
		obj.put("email", "abhi@gmail.com");
		obj.put("empName", "Abhishek");
		obj.put( "experience", 2);
		obj.put( "mobileNo", "9888777657");
		obj.put("project", expectedprojectName);
		obj.put("role", "ROLE_ADMIN");
		obj.put( "username", "Abhishek mulage"+ran);
		
		Response user = given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/employees");
		
		String actualProjectName = user.jsonPath().get("project");
		System.out.println(actualProjectName);
		
		user.then()
			.assertThat().statusCode(201)
			.log().all();
	//	Assert.assertEquals( actualProjectName,expectedprojectName);
	}

}
