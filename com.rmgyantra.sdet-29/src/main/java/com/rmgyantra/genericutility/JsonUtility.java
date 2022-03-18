package com.rmgyantra.genericutility;

import io.restassured.response.Response;

/**JSON utility class
 * 
 * @author Mulage Abhishek
 *
 */
public class JsonUtility {

	
	
	public Object getResponseData(Response response,String jsonPath) {
		return response.jsonPath().getBoolean(jsonPath);
		
	}
}
