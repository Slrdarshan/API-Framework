package com.rmgyantra.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * Database utility class
 * @author Mulage Abhishek
 *
 */
public class DataBaseUtility {
	
	Connection connection=null;
	/**
	 * This method will connect mysql database to java
	 * @param querry
	 */
		public void dataBaseConn() {
			try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * This method will close the connection of mysql database
		 */
		public void closeConn() {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/**
		 * This method will return all the data from database
		 * @param querry
		 * @return
		 */
		public ResultSet getAllData(String querry) {
			 ResultSet result=null;
			
			  try {
				result = connection.createStatement().executeQuery(querry);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return result;
		}
		/**
		 * This method will verify the data from database and it will return the data
		 * @param querry
		 * @param colNumber
		 * @param expectedData
		 * @return 
		 * @throws Throwable
		 */
		
		public String getDataAndVerify(String querry,int colNumber,String expectedData) throws Throwable  {
			ResultSet result = connection.createStatement().executeQuery(querry);
			boolean flag=false;
			String actualData1=null;
			while(result.next()) {
				try {
					if(result.getString(colNumber).equals(expectedData)) {
						System.out.println(result.getString(colNumber));
						flag=true;
						actualData1=result.getString(colNumber);
						break;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(flag==true) {
				System.out.println("Data is verified in database");
				return actualData1;
			}else {
				System.out.println("Data is not present");
				return null;
			}
			
			
		}
}
