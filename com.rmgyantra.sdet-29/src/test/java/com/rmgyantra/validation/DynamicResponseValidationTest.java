package com.rmgyantra.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pojo.classes.PojoClassForPostReq;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidationTest {

	@Test
	public void dynamicResponseValidation() {
		
		String expProName="Testyantra13";
		Response resp = when()
			.get("http://localhost:8084/projects");
		List<String> actualProName = resp.jsonPath().get("projectName");
		boolean flag=false;
		for (String pro : actualProName) {
			if(pro.equals(expProName))
			{
				System.out.println("projoectname is matching");
				flag=true;
			}
		}
		resp.then()
			.log().all();
	Assert.assertEquals(flag, true);
	}
	
	@Test
	public void validateProjectName() {
		
		String expProjName="tyssproject2";
		PojoClassForPostReq obj=new PojoClassForPostReq("Abhishek","tyssproject2", "completed", 2);
		
		Response resp = given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
		
		String actualProjName = resp.jsonPath().get("projectName");
		System.out.println(actualProjName);
		Assert.assertEquals(actualProjName, expProjName);
	}
}
