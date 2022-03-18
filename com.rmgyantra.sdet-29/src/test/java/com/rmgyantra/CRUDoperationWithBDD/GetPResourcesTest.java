package com.rmgyantra.CRUDoperationWithBDD;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class GetPResourcesTest {

	
	@Test
	public void getProjectTest() {
		
		when()
			.get("http://localhost:8084/projects")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}
