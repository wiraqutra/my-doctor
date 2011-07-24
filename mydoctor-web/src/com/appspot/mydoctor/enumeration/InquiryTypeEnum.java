package com.appspot.mydoctor.enumeration;

public enum InquiryTypeEnum {
	SELECT("select", "select"), CHECKBOX("checkbox", "checkbox");

	private String code;
	private String name;

	private InquiryTypeEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public static InquiryTypeEnum getInstanceByKey(String code) {
		for (InquiryTypeEnum inquiryType : InquiryTypeEnum.values()) {
			if (inquiryType.code.equals(code)) {
				return inquiryType;
			}
		}
		return null;
	}
}
