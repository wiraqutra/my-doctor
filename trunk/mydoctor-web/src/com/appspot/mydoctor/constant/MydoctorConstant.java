package com.appspot.mydoctor.constant;

public class MydoctorConstant {

	private static final int SESSION_EXPIRE_MINUTES = 30;

	private static final String SYSTEM_FROM_MAIL_ADDRESS = "mydoctor.info@gmail.com";

	public static int getSessionExpireMinutes() {
		return SESSION_EXPIRE_MINUTES;
	}

	public static String getSystemFromMailAddress() {
		return SYSTEM_FROM_MAIL_ADDRESS;
	}
}
