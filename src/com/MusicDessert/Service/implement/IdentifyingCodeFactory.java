package com.MusicDessert.Service.implement;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public abstract class IdentifyingCodeFactory implements
		com.MusicDessert.Service.IdentifyingCodeFactory {
	
	
	private String IDENTIFYING_CODE_KEY;
	private String IDENTIFYING_CODE_CREATE_TIME_KEY;
	
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
		return  ServletActionContext.getRequest().getSession();
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
			this.getSession().setAttribute(IDENTIFYING_CODE_KEY, identifyingCode);	
			this.getSession().setAttribute(IDENTIFYING_CODE_CREATE_TIME_KEY, identifyingCodeCreateTime);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean sendAndSaveIdentifyingCode(String phoneNumber) {
		boolean isIdentifyingCodeSendSuccess = false;
		try{
			String identifyingCode = createIdentifyingCode();
			Date identifyingCodeCreateTime = new Date();
			saveIdentifyingCodeToSession(identifyingCode, identifyingCodeCreateTime);
			SMS sms = new SMS();
			sms.sendMessageToPhone(phoneNumber, identifyingCode);
			isIdentifyingCodeSendSuccess = true;
		}catch(Exception e){
			e.printStackTrace();
			isIdentifyingCodeSendSuccess  = false;
		}
		return isIdentifyingCodeSendSuccess;
	}
	
	@Override
	//下面的函数是用来检测验证码是否有效
	public IdentifyingCodeState getIdentifyingCodeState(String identifyingCode){
		IdentifyingCodeState identifyingCodeState;
		if(!this.isIdentifyingCodeBeenSended()){//检测是否产生了验证码
			identifyingCodeState = IdentifyingCodeState.UnCreated;	
		}else if(this.isIdentifyingCodeLoseEfficacy()){//判断验证码是否失效
			identifyingCodeState = IdentifyingCodeState.LoseEfficacy;
		}else if(!this.isIdentifyingCodeCorrect(identifyingCode)){//检查验证码是否正确
			identifyingCodeState = IdentifyingCodeState.Wrong;
		}else{
			identifyingCodeState = IdentifyingCodeState.Correct;
		}
		return identifyingCodeState;
	}

	@Override
	public boolean isIdentifyingCodeBeenSended() {
		boolean isIdentifyingCodeBeenSended = false;
		String identifyingCode = this.getIdentifyingCode();
		if(identifyingCode != null){
			isIdentifyingCodeBeenSended = true;
		}
		return isIdentifyingCodeBeenSended;
	}

	@Override
	public boolean isIdentifyingCodeLoseEfficacy() {
		boolean isLoseEfficacy = true;
		Date currentTime = new Date();
		Date identifyingCodeCreateTime = this.getIdentifyingCodeCreateTime();
		long interval = (currentTime.getTime() - identifyingCodeCreateTime.getTime()) / 1000;
		if(interval < IDENTIFYING_CODE_LEFT_CYCLE){
			isLoseEfficacy = false;
		}
		return isLoseEfficacy;
	}

	@Override
	public boolean isIdentifyingCodeCorrect(String identifyingCode) {
		boolean isIdentifyingCodeCorrect = this.getIdentifyingCode().equals(identifyingCode);
		return isIdentifyingCodeCorrect;
	}

	@Override
	public String getIdentifyingCode() {
		String identifyingCode = null;
		if(this.getSession().getAttribute(this.getIdentifyingCodeKey()) != null){
			identifyingCode = (String)this.getSession().getAttribute(this.getIdentifyingCodeKey());
		}
		return identifyingCode;
	}

	@Override
	public Date getIdentifyingCodeCreateTime() {
		Date identifyingCodeCreateTime = null;
		if(this.getSession().getAttribute(this.getIdentifyingCodeCreateTimeKey()) != null){
			identifyingCodeCreateTime = (Date)this.getSession().getAttribute(this.getIdentifyingCodeCreateTimeKey());
		}
		return identifyingCodeCreateTime;
	}

}
