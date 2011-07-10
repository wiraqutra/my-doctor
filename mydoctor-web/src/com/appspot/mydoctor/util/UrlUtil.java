package com.appspot.mydoctor.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class UrlUtil {

	public static String getRequestURL(HttpServletRequest request) {
		StringBuffer sb = request.getRequestURL();
		if (StringUtils.isNotEmpty(request.getQueryString())) {
			sb.append("?").append(request.getQueryString());
		}
		return sb.toString();
	}
}
