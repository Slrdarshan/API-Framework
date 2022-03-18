package com.rmgyantra.CRUDoperationWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DleteResourcesTest {

	
	@Test
	public void deleteProjectTest() {
		
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_1013")
		.then()
			.assertThat().statusCode(204)
			.log().all();
	}
}
