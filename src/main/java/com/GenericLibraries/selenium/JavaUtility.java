package com.GenericLibraries.selenium;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable methods to perform java related operations
 * @author prash
 *
 */
public class JavaUtility {
	
/**
 * This method is used to fetch date and time
 * @return
 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_mm_yy_mm_ss");
		return sdf.format(date);
		
	}
	/**
	 * This method is used to wait for specified amount of time
	 * @param
	 */
	public void pause(long time) {
		try {
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method generate random number within the specified limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
		
	}
}
