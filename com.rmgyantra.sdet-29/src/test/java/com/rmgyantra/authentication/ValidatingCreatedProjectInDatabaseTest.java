package com.rmgyantra.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
import com.pojo.classes.PojoClassForPostReq;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class ValidatingCreatedProjectInDatabaseTest {

	
	@Test
	public void validateProjectInDB() throws Throwable {
		Random random = new Random();
		int ran = random.nextInt(1000);
		String expectedProName="testcase"+ran;
		PojoClassForPostReq pojo = new PojoClassForPostReq("Mulage", "testcase"+ran, "created", 2);
		
		Response resp = given()
			.body(pojo)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject");
		String actualProName=resp.jsonPath().get("projectName");
		
		resp.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
		
			Assert.assertEquals(actualProName, expectedProName);
			
			String expectedDBValue=null;
			Connection conn=null;
			try {
			Driver driverRef=new Driver();
			
			DriverManager.registerDriver(driverRef);

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			System.out.println("connection is done");
		
			Statement stat=conn.createStatement();
			String query="select * from project";
			
			ResultSet resultset=stat.executeQuery(query);
			
			while(resultset.next()){
				if(actualProName.equals(resultset.getString(4)))
						{
						expectedDBValue=resultset.getString(4);
						}
			}			
			}
			catch(Exception e) {			
			}
			finally {
				conn.close();
			
		}
			System.out.println("created project  "+expectedProName);
			System.out.println("value is present in Db  "+expectedDBValue);
			Assert.assertEquals(expectedDBValue, expectedProName);
	}
	@Test
	public void run() throws Throwable {
		Connection conn=null;
		try {
		Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("connection is done");
	
		Statement stat=conn.createStatement();
		String query="select * from project";
		
		ResultSet resultset=stat.executeQuery(query);
		while(resultset.next()){
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
		}			
		}
		catch(Exception e) {			
		}
		finally {
			conn.close();
		}
	}
	
}
