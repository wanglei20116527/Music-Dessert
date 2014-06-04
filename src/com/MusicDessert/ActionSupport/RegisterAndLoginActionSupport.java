package com.MusicDessert.ActionSupport;

import org.springframework.util.DigestUtils;

import com.MusicDessert.KEY.Key;
import com.MusicDessert.Service.implement.IdentifyingCodeFactory;
import com.MusicDessert.Service.implement.UserInfoValidityChecker;

public abstract class RegisterAndLoginActionSupport extends CustomActionSupport {
	private static final long serialVersionUID = 1L;
	
	private IdentifyingCodeFactory identifyingCodeFactory;
	private UserInfoValidityChecker userInfoValidityChecker;
	
	public abstract void sendIdentifyingCode();
	
	//这个函数是通过用户名获得指定用户的电话号码
	protected abstract String getPhoneNumber();
	
	public final void setIdentifyingCodeFactory(
			IdentifyingCodeFactory identifyingCodeFactory) {
		this.identifyingCodeFactory = identifyingCodeFactory;
	}
	
	protected final IdentifyingCodeFactory getIdentifyingCodeFactory(){
		return identifyingCodeFactory;
	}
	
	public final void setUserInfoValidityChecker(UserInfoValidityChecker userInfoValidityChecker) {
		this.userInfoValidityChecker = userInfoValidityChecker;
	}
	
	protected final UserInfoValidityChecker getUserInfoValidityChecker() {
		return userInfoValidityChecker;
	}

	protected final String getUserName(){
		String userName = this.getRequest().getParameter(Key.USERNAME_KEY);
		userName = userName.trim();
		return userName;
	}
	
	protected final String getPassword(){
		String password = this.getRequest().getParameter(Key.PASSWORD_KEY);
		password = password.trim();
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		return password;
	}
	
	protected final String getIdentifyingCode(){
		String identifyingCode = this.getRequest().getParameter(Key.IDENTIFYING_CODE_KEY);
		identifyingCode = identifyingCode.trim();
		return identifyingCode;
	}
}
