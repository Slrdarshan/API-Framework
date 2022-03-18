package com.rmgyantra.datadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pojo.classes.PojoClassForPostReq;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenTest {

	@Test(dataProvider = "dataForCreatingProjects")
	public void dataProvoiderTest(String createdBy,String projectName,String status,int teamSize) {
		PojoClassForPostReq pojo = new PojoClassForPostReq(createdBy,projectName,status, teamSize);
		given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
	}
	
	@DataProvider
	public Object[][] dataForCreatingProjects(){
		Object[][] obj = new Object[4][4];
		obj[0][0]="Abhishek";
		obj[0][1]="Abhishek_Project_01";
		obj[0][2]="ongoing";
		obj[0][3]=100;
		
		obj[1][0]="Sibu";
		obj[1][1]="Abhishek_Project_02";
		obj[1][2]="ongoing";
		obj[1][3]=200;
		
		obj[2][0]="Mahadev";
		obj[2][1]="Abhishek_Project_03";
		obj[2][2]="completed";
		obj[2][3]=300;
				
		obj[3][0]="Param";
		obj[3][1]="Abhishek_Project_04";
		obj[3][2]="created";
		obj[3][3]=400;
		
		return obj;
	}
}
