package com.MusicDessert.Service.implement;

public class LogInIdentifyingCodeFactory extends IdentifyingCodeFactory {
	public LogInIdentifyingCodeFactory(){
		final String LOGIN_INDENTIFYING_CODE_KEY = "logInIdentifyingCode";
		this.setIdentifyingCodeKey(LOGIN_INDENTIFYING_CODE_KEY);
		
		final String LOGIN_INDENTIFYING_CODE_CREATE_TIME_KEY = "logInIdentifyingCodeCreateTime";
		this.setIdentifyingCodeCreateTimeKey(LOGIN_INDENTIFYING_CODE_CREATE_TIME_KEY);
	}
}
