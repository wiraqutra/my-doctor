package com.appspot.mydoctor.util;

import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class UrlUtilTest {

	@Test
	public void sessionUrlTest() {
		String url = "http://www.google.co.jp";
		String sessionId = "XXX";
		Assert.assertEquals(url + "?sid=" + sessionId, UrlUtil.addSessionId(url, sessionId));

		url = "http://www.google.co.jp?abc=def";
		Assert.assertEquals("http://www.google.co.jp?sid=" + sessionId + "&abc=def", UrlUtil.addSessionId(url, sessionId));

		url = "http://www.google.co.jp?abc=def&sid=YYY";
		Assert.assertEquals("http://www.google.co.jp?sid=" + sessionId + "&abc=def", UrlUtil.addSessionId(url, sessionId));

		url = "http://www.google.co.jp?sid=ZZZ";
		Assert.assertEquals("http://www.google.co.jp?sid=" + sessionId, UrlUtil.addSessionId(url, sessionId));

	}

	@Test
	public void parameterTest() {
		String query = "q=abc&sid=ZZZ";
		Map<String, String> paramMap = UrlUtil.getParameterMap(query);
		Map<String, String> expected = new LinkedHashMap<String, String>();
		expected.put("q", "abc");
		expected.put("sid", "ZZZ");
		Assert.assertEquals(map2String(expected), map2String(paramMap));
	}

	private String map2String(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}
}
