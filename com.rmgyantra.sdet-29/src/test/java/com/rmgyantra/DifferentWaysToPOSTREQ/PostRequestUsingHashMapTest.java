package com.rmgyantra.DifferentWaysToPOSTREQ;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PostRequestUsingHashMapTest {

	@Test
	public void createResourceUsingHashMapTest() {
		
		HashMap<Object, Object> map = new HashMap();
		map.put("createdBy", "Abhishek");
		map.put("projectName", "samsungg1");
		map.put("status", "ongoing");
		map.put("teamSize", 188);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
