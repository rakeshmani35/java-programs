package com.enumconstant;

enum EnumCode {
	ASSOCIATE(10001), SENIOR_ASSOCIATE(10002);

	private int code;

	private EnumCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
	
	public static EnumCode valueOfCode(int code) {
		EnumCode[] values = EnumCode.values();
		for (EnumCode enumCode : values) {
			if (enumCode.code==code) {
				return enumCode;
			}
		}
		return null;
	}
}

public class EnumWithValue {

	public static void main(String[] args) {
		
		EnumCode valueOfCode = EnumCode.valueOfCode(10001);
		System.out.println("print enum = "+valueOfCode);
		System.out.println("print enum by name() method = "+valueOfCode.name());
	}

}
