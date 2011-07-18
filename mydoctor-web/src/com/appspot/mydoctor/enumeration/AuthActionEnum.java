package com.appspot.mydoctor.enumeration;

public enum AuthActionEnum {

	SUCCESS("success"), FAILED("failed"), REDIRECT("redirect");

	private String key;

	private AuthActionEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
