package com.appspot.mydoctor.util;

public class RequestUtil {

	public static Integer getInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
}
