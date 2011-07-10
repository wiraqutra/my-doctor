package com.appspot.mydoctor.enumeration;

public enum OutFileTypeEnum {
    XML("xml"), JSON("json"), JSONP("jsonp");

    private String key;

    private OutFileTypeEnum(String key) {
        this.key = key;
    }

    public static OutFileTypeEnum getInstance(String key) {
        for (OutFileTypeEnum outType : OutFileTypeEnum.values()) {
            if (outType.key.equals(key)) {
                return outType;
            }
        }
        return null;
    }
}
