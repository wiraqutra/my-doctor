package com.appspot.mydoctor.enumeration;

public enum SessionKeyEnum {
	LOGIN_SESSION_KEY("loginSessionKey");

	private String key;

	private SessionKeyEnum(String key) {
		this.key = key;
	}

	public static SessionKeyEnum getInstance(String key) {
		for (SessionKeyEnum sessionKeyEnum : SessionKeyEnum.values()) {
			if (sessionKeyEnum.key.equals(key)) {
				return sessionKeyEnum;
			}
		}
		return null;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
