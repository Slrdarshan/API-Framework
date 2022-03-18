package com.rmgyantra.testcases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class UserTestCasesTest {

	@Test
	public void createUserTest() {
		JSONObject obj = new JSONObject();


		obj.put("designation", "SDET");
		obj.put("dob","25/05/1999");
		obj.put( "email", "nithesh@gmail.com");
		obj.put( "empName","nithesh");
		obj.put("experience", 15);
		obj.put( "mobileNo", "9888777657");
		obj.put("project", "hdfc");
		obj.put("role", "ROLE_ADMIN");
		obj.put( "username","nithesh");


	}

}
