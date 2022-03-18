package com.rmgyantra.DifferentWaysToPOSTREQ;

import org.testng.annotations.Test;

import com.pojo.classes.PojoClassForPostReq;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequestUsingPojoClassTest {
	
	@Test
	public void createResourceUsingPojoTest() {
		
		PojoClassForPostReq req=new PojoClassForPostReq("Abhishek Mulage", "Samsang s10", "completed", 102);
		
		given()
			.body(req)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}

}
