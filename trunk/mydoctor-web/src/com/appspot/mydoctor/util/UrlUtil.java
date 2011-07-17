package com.appspot.mydoctor.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.appspot.mydoctor.exception.InvalidArgumentException;

public class UrlUtil {

	public static String getRequestURL(HttpServletRequest request) {
		StringBuffer sb = request.getRequestURL();
		if (StringUtils.isNotEmpty(request.getQueryString())) {
			sb.append("?").append(request.getQueryString());
		}
		return sb.toString();
	}

	public static String addSessionId(String url, String sessionId) {
		if (StringUtils.isEmpty(url) || StringUtils.isEmpty(sessionId)) {
			return url;
		}
		StringBuilder sb = new StringBuilder();

		String[] split = url.split("\\?");
		if (split.length == 2) {
			Map<String, String> params = getParameterMap(split[1]);
			params.put("sid", sessionId);
			sb.append(split[0]).append("?");
			for (Map.Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
			}
			sb.deleteCharAt(sb.length() - 1);
		} else if (split.length == 1) {
			sb.append(split[0]).append("?sid=").append(sessionId);
		} else {
			throw new RuntimeException(new InvalidArgumentException());
		}
		return sb.toString();
	}

	public static Map<String, String> getParameterMap(String query) {
		if (StringUtils.isEmpty(query)) {
			return null;
		}
		String[] splitAnd = query.split("\\&");
		Map<String, String> params = new LinkedHashMap<String, String>();
		for (String param : splitAnd) {
			String[] splitEqual = param.split("=");
			params.put(splitEqual[0], splitEqual[1]);
		}
		return params;
	}
}
