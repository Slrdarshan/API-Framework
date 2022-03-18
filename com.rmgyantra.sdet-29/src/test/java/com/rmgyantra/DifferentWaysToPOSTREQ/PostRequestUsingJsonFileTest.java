package com.rmgyantra.DifferentWaysToPOSTREQ;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PostRequestUsingJsonFileTest {

	
	@Test
	public void createResourceUsingJsonFileTest() {
		
		
		File file = new File("./src/test/resources/Data.json");
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
	}
}
