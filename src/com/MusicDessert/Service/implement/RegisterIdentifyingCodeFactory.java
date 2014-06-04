package com.MusicDessert.Service.implement;

public class RegisterIdentifyingCodeFactory extends IdentifyingCodeFactory {
	public RegisterIdentifyingCodeFactory(){
		final String REGISTER_INDENTIFYING_CODE_KEY = "registerIdentifyingCode";
		this.setIdentifyingCodeKey(REGISTER_INDENTIFYING_CODE_KEY);
		
		final String REGISTER_INDENTIFYING_CODE_CREATE_TIME_KEY = "registerIdentifyingCodeCreateTime";
		this.setIdentifyingCodeCreateTimeKey(REGISTER_INDENTIFYING_CODE_CREATE_TIME_KEY);
	}
}
