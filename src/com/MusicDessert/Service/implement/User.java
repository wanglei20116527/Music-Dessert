package com.MusicDessert.Service.implement;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class User implements com.MusicDessert.Service.User {
	private final String USERNAME_KEY = "userName";
	private final String USERID_KEY = "userID";
	private final String LOGIN_STATE_KEY = "loginState";

	@Override
	public String getLoginedUserName() {
		HttpSession session = this.getSession();
		String userName = (String)session.getAttribute(USERNAME_KEY);
		return userName;
	}
	
	@Override
	public Integer getLoginedUserID(){
		HttpSession session = this.getSession();
		Integer userID = (Integer)session.getAttribute(USERID_KEY);
		return userID;
	}
	
	@Override
	public boolean isUserLogin(){
		boolean isUserLogin = false;
		HttpSession session = this.getSession();
		Boolean loginStateBooleanObject = (Boolean)session.getAttribute(this.LOGIN_STATE_KEY);
		if(loginStateBooleanObject != null && 
				loginStateBooleanObject.booleanValue()){
			isUserLogin = true;
		}else{
			isUserLogin = false;
		}
		return isUserLogin;
	}
	
	private HttpSession getSession(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		return session;
	}

}
