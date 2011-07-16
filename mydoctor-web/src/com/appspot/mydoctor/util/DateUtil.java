package com.appspot.mydoctor.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static Date getExpireDateMinutes(int addMinutes) {
		Calendar cal = Calendar.getInstance(Locale.JAPAN);
		cal.add(Calendar.MINUTE, addMinutes);

		return cal.getTime();
	}

	public static Date getExpireDateDays(int addDays) {
		Calendar cal = Calendar.getInstance(Locale.JAPAN);
		cal.add(Calendar.DAY_OF_MONTH, addDays);

		return cal.getTime();
	}
}
