package utils.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

import java.lang.Math;

public class Utilities {
	private final static String ALPHA_NUMERIC_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	/**
	 * Gets the project path.
	 *
	 * @author tuan.le
	 * @return the project path
	 */
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	/**
	 * Random string.
	 *
	 * @author tuan.le
	 * @param len: length of string
	 * @return the string
	 */

	public static String getRandomString(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int index = (int) (ALPHA_NUMERIC_STRING.length() * Math.random());
			sb.append(ALPHA_NUMERIC_STRING.charAt(index));
		}
		return sb.toString();
	}

	/**
	 * Get current time in milliseconds
	 *
	 * @author tuan.le
	 * @return current time in milliseconds
	 */

	public static String getDateWithTimeMils() {
		String parse = String.valueOf(System.currentTimeMillis());
		return parse;
	}

	/**
	 * Get string date with format
	 *
	 * @author tuan.le
	 * @param format: the format of string
	 * @return date with specific format
	 */

	public static String getDateNow(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Get string current date with plus day and format format
	 *
	 * @author tuan.le
	 * @param format:  the format of string
	 * @param dayPlus: the number of day want to plus
	 * @return date with specific format
	 */

	public static String getDateNowWithDayPlus(String format, int dayPlus) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.DATE, dayPlus);
		Date currentDateAfterPlus = c.getTime();
		return dateFormat.format(currentDateAfterPlus);
	}
	
	/**
	 * Get random number in given range
	 *
	 * @author tuan.le
	 * @param: range: range is number
	 */
	
	public static int getRandomNumber(int range) {
		Random random = new Random();
		int index = random.nextInt(range);
		return index;
	}
}
