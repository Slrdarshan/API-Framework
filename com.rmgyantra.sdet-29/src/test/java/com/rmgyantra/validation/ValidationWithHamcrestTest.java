package com.rmgyantra.validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

public class ValidationWithHamcrestTest {

	@Test
	public void validationWithHamcrest() {
		
		when()
			.get("http://localhost:8084/projects/TY_PROJ_2402")
		.then()
			.assertThat().time(Matchers.lessThan(1500L),TimeUnit.MILLISECONDS)
			.assertThat().body("projectName", Matchers.equalToIgnoringCase("Testyantraobj"))
			.assertThat().body("projectId", Matchers.equalTo("TY_PROJ_2402"))
			.body("createdBy", Matchers.equalTo("Abhishek"))
			.statusCode(200)
			.log().all();
	}
}
