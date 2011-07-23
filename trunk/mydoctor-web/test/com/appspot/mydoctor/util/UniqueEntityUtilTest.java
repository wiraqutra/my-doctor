package com.appspot.mydoctor.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.appspot.mydoctor.exception.RandomKeyCreateTimeoutException;
import com.appspot.mydoctor.model.LoginSessionModel;

public class UniqueEntityUtilTest extends AppEngineTestCase {

	@Test
	public void test() {

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < 50; i++) {
			try {
				String uniqueKey = UniqueEntityUtil.getSessionKey(LoginSessionModel.class.getSimpleName(), 1);
				if (map.get(uniqueKey) != null) {
					throw new RuntimeException("fatality duplicate key");
				} else {
					map.put(uniqueKey, true);
				}
			} catch (RandomKeyCreateTimeoutException e) {
				throw new RuntimeException(Integer.toString(i) + " times duplicate key");
			}
		}
	}
}
