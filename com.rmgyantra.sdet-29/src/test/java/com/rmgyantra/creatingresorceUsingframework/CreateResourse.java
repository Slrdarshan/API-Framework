package com.rmgyantra.creatingresorceUsingframework;

import com.pojo.classes.PojoClassForPostReq;
import com.rmgyantra.genericutility.BaseAPIClass;
import com.rmgyantra.genericutility.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateResourse extends BaseAPIClass {
	
	@Test
	public void create() throws Throwable {
	int random=jUtil.getRandomNumber();
	String expectedData="Samsung"+random;
	PojoClassForPostReq pojo=new PojoClassForPostReq("Mulage", expectedData, "created", 20);
	
	Response response = given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post(EndPoints.ADDPROJECT);
	
	String respProjname = response.jsonPath().get("projectName");
	
	response.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	
	String querry="select * from project";
	String dbProjName = dbUtil.getDataAndVerify(querry, 4, expectedData);
	Assert.assertEquals(expectedData, dbProjName);
	}
	
	@Test
	public void getesource() {
		String expectedProjId="TY_PROJ_2621";
		when()
			.get(EndPoints.GETALLPROJECTS)
		//.get("https://localhost:8084/projects/TY_PROJ_2621");
			
		.then()
			.assertThat().statusCode(200).log().all();
	}
}
