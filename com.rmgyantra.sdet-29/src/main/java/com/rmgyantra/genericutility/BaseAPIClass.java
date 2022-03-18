package com.rmgyantra.genericutility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
public class BaseAPIClass {
	
	public DataBaseUtility dbUtil=new DataBaseUtility();
	public JavaUtility jUtil=new JavaUtility();
	
	
		@BeforeSuite
		public void bsConfig() {
			
			System.out.println("Database connetion is started");
			dbUtil.dataBaseConn();
			baseURI="http://localhost";
			port=8084;
			System.out.println("Database connection established");
			
	}
		@AfterSuite
		public void asConfi() {
			dbUtil.closeConn();
			System.out.println("Database connection closed");
		}

}
