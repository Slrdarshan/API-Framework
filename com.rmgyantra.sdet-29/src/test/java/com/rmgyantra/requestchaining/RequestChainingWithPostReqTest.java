package com.rmgyantra.requestchaining;

import org.testng.annotations.Test;

import com.pojo.classes.PojoClassForPostReq;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChainingWithPostReqTest {

	@Test
	public void requestChaining() {
		
		Random randon = new Random();
		int ran = randon.nextInt(1000);
		PojoClassForPostReq obj=new PojoClassForPostReq("abhi", "vikas kumar1"+ran, "created", 10);
		
		Response resp = given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
		String projectId = resp.jsonPath().get("projectId");
		
		given()
			.pathParam("proId", projectId)
		.when()
			.delete("http://localhost:8084/projects/{proId}")
		.then()
			.assertThat().statusCode(204)
			.log().all();
	}
}
