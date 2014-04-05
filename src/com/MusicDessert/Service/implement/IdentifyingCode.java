package com.MusicDessert.Service.implement;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

abstract class IdentifyingCode {	
	private HttpSession session;
	private String IDENTIFYING_CODE_KEY;
	private String IDENTIFYING_CODE_CREATE_TIME_KEY;
	
	
	public IdentifyingCode(){
		session = ServletActionContext.getRequest().getSession();
	}
	
	protected void setIdentifyingCodeKey(String identifyCodeKey){
		this.IDENTIFYING_CODE_KEY = identifyCodeKey;
	}
	
	protected String getIdentifyingCodeKey(){
		return this.IDENTIFYING_CODE_KEY;
	}
	
	protected void setIdentifyingCodeCreateTimeKey(String identifyCodeCreateTimeKey){
		this.IDENTIFYING_CODE_CREATE_TIME_KEY = identifyCodeCreateTimeKey;
	}
	
	protected String getIdentifyingCodeCreateTimeKey(){
		return this.IDENTIFYING_CODE_CREATE_TIME_KEY;
	}
	
	protected HttpSession getSession(){
		return this.session;
	}
	
	//下面的函数使用来创建验证码的（包括注册和登陆的验证码）
	private String createIdentifyingCode(){
		String identifyingCode = "";
		final int NUMBER_DIGIT = 6;
		for(int i = 0; i < NUMBER_DIGIT; ++i){
			identifyingCode += String.valueOf((int)(Math.random() * 10));
		}
		return identifyingCode;
	}
	
	private void saveIdentifyingCodeToSession(String identifyingCode, Date identifyingCodeCreateTime){
		try{
			this.session.setAttribute(IDENTIFYING_CODE_KEY, identifyingCode);	
			this.session.setAttribute(IDENTIFYING_CODE_CREATE_TIME_KEY, identifyingCodeCreateTime);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean sendAndSaveIdentifyingCode(String phoneNumber){
		boolean isIdentifyingCodeSendSuccess = false;
		try{
			String identifyingCode = createIdentifyingCode();
			Date identifyingCodeCreateTime = new Date();
			saveIdentifyingCodeToSession(identifyingCode, identifyingCodeCreateTime);
			SMS.sendMessageToPhone(phoneNumber, identifyingCode);
			isIdentifyingCodeSendSuccess = true;
		}catch(Exception e){
			e.printStackTrace();
			isIdentifyingCodeSendSuccess  = false;
		}
		return isIdentifyingCodeSendSuccess;
		
	}
	
	public String getIdentifyingCode(){
		String identifyingCode = null;
		if(this.getSession().getAttribute(this.getIdentifyingCodeKey()) != null){
			identifyingCode = (String)this.getSession().getAttribute(this.getIdentifyingCodeKey());
		}
		return identifyingCode;
	}
	
	public Date getIdentifyingCodeCreateTime(){
		Date identifyingCodeCreateTime = null;
		if(this.getSession().getAttribute(this.getIdentifyingCodeCreateTimeKey()) != null){
			identifyingCodeCreateTime = (Date)this.getSession().getAttribute(this.getIdentifyingCodeCreateTimeKey());
		}
		return identifyingCodeCreateTime;
	}
	
}
