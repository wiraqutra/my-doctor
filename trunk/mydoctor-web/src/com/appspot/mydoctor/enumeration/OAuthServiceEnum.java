package com.appspot.mydoctor.enumeration;

public enum OAuthServiceEnum {
	GOOGLE("gl", "google"), TWITTER("tw", "twitter"), FACEBOOK("fb", "facebook"), EMAIL("em", "email");

	private String key;
	private String name;

	private OAuthServiceEnum(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static OAuthServiceEnum getInstance(String key) {
		for (OAuthServiceEnum service : OAuthServiceEnum.values()) {
			if (service.key.equals(key)) {
				return service;
			}
		}
		return null;
	}

	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}
}
