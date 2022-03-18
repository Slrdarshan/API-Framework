package com.rmgyantra.genericutility;

import java.util.Random;
/**
 * Java utility class
 * @author Mulage Abhishek
 *
 */
public class JavaUtility {
	/**
	 * This method will return random number
	 * @return
	 */
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(10000);
	}

}
