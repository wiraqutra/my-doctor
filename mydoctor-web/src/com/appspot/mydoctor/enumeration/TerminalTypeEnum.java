package com.appspot.mydoctor.enumeration;

public enum TerminalTypeEnum {
	PC("pc", "Pc"), MOBILE("m", "Mobile"), SMARTPHONE("sp", "SmartPhone"), DS("ds", "Nintendo DS");

	private String key;
	private String name;

	private TerminalTypeEnum(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static TerminalTypeEnum getInstanceByKey(String key) {
		for (TerminalTypeEnum terminalType : TerminalTypeEnum.values()) {
			if (terminalType.key.equals(key)) {
				return terminalType;
			}
		}
		return null;
	}
}
