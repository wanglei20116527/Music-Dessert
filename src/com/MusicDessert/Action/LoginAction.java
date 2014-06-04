package com.MusicDessert.Action;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.MusicDessert.ActionSupport.RegisterAndLoginActionSupport;
import com.MusicDessert.KEY.Key;
import com.MusicDessert.Service.IdentifyingCodeFactory;
import com.MusicDessert.Service.implement.Login;

public final class LoginAction extends RegisterAndLoginActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Login login;
	
	public void setLogin(Login login){
		this.login = login;
	}
	
	private Login getLogin() {
		return login;
	}

	@Override
	public void sendIdentifyingCode(){
		String phoneNumber = this.getPhoneNumber();
		if(phoneNumber == null){
			this.getPrintWriter().print("User_Not_Exist");
		}else if(this.getIdentifyingCodeFactory().isIdentifyingCodeBeenSended() &&
					!this.getIdentifyingCodeFactory().isIdentifyingCodeLoseEfficacy()){
			this.getPrintWriter().print("IdentifyingCode_Created");
		}else{
			this.getIdentifyingCodeFactory().sendAndSaveIdentifyingCode(phoneNumber);
			this.getPrintWriter().print("Success");
		}
		this.getPrintWriter().flush();
	}
	
	public void login() throws Exception{
		try{
			
			String userName = this.getUserName();
			String password = this.getPassword();
			String identifyingCode = getIdentifyingCode();
			
			if(!this.getUserInfoValidityChecker().isUserNameValid(userName)){//检查用户名是否合法
				this.getPrintWriter().println("UserName_Invalid");
				return;
			}
			
			if(!this.getUserInfoValidityChecker().isPasswordValid(password)){//检查用户密码是否合法
				this.getPrintWriter().println("Password_Invalid");
				return;
			}
			
			IdentifyingCodeFactory.IdentifyingCodeState identifyingCodeState =
					this.getIdentifyingCodeFactory().getIdentifyingCodeState(identifyingCode);
			switch(identifyingCodeState){
			case UnCreated:
				this.getPrintWriter().println("IdentifyingCode_UnCreated");
				break;
			case LoseEfficacy:
				this.getPrintWriter().println("IdentifyingCode_LoseEfficacy");
				break;
			case Wrong:
				this.getPrintWriter().println("IdentifyingCode_Wrong");
				break;
			case Correct:
				if(this.getLogin().isUserNameAndPasswordCorrect(userName, password)){
					this.saveUserLoginSuccessInfo(userName);
					this.getPrintWriter().println("Success");
				}else{
					this.getPrintWriter().println("User_Or_Password_Wrong");			
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void isUserLogin() throws Exception{
		String userName = (String)this.getSession().getAttribute(Key.USERNAME_KEY);
		Boolean loginStateBooleanObject = (Boolean)this.getSession().getAttribute(Key.LOGIN_STATE_KEY);
		boolean loginState = false;
		if(loginStateBooleanObject != null){
			loginState = loginStateBooleanObject.booleanValue();
		}
		JSONObject loginObjectJSON = new  JSONObject();
		if(userName != null &&
				loginState){
			loginObjectJSON.put("loginState", true);
			loginObjectJSON.put("userName", this.getSession().getAttribute(Key.USERNAME_KEY));
		}else{
			loginObjectJSON.put("loginState", false);
		}
		this.getPrintWriter().println(loginObjectJSON);
	}
	
	@Override
	//这个函数是通过用户名获得指定用户的电话号码
	protected String getPhoneNumber(){
		String userName = this.getUserName();
		String phoneNumber = this.getLogin().getPhoneNumber(userName);
		return phoneNumber;
	}
	
	private void saveUserLoginSuccessInfo(String userName){
		HttpSession session = this.getSession();
		session.setAttribute(Key.USERNAME_KEY, userName);
		Integer userID = this.getLogin().getUserID(userName);
		session.setAttribute(Key.USERID_KEY, userID);
		session.setAttribute(Key.LOGIN_STATE_KEY, true);
	}
}
