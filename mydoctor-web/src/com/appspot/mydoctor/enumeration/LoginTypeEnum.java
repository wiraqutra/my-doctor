package com.appspot.mydoctor.enumeration;

public enum LoginTypeEnum {
    OAUTH("oauth"), SITE("site");

    private String key;

    private LoginTypeEnum(String key) {
        this.key = key;
    }

    public static LoginTypeEnum getInstance(String key) {
        for (LoginTypeEnum loginType : LoginTypeEnum.values()) {
            if (loginType.key.equals(key)) {
                return loginType;
            }
        }
        return null;
    }
}
