package com.appspot.mydoctor.enumeration;

public enum OAuthServiceEnum {
    GOOGLE("google"), TWITTER("twitter");

    private String key;

    private OAuthServiceEnum(String key) {
        this.key = key;
    }

    public static OAuthServiceEnum getInstance(String key) {
        for (OAuthServiceEnum service : OAuthServiceEnum.values()) {
            if (service.key.equals(key)) {
                return service;
            }
        }
        return null;
    }
}
