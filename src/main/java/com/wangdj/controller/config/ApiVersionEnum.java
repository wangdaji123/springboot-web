package com.wangdj.controller.config;

public enum ApiVersionEnum {
	VERSION_10(10), VERSION_11(11);
	
	private int code;
	
	private ApiVersionEnum(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
