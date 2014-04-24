package com.MusicDessert.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.DigestUtils;

import com.MusicDessert.Service.implement.LogInIdentifyingCode;
import com.MusicDessert.Service.implement.Login;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private final String USERNAME_KEY = "userName";
	private final String PASSWORD_KEY = "password";
	private final String IDENTIFYING_CODE_KEY = "identifyingCode";
	private final String LOGIN_STATE_KEY = "loginState";//如果为true的话，表示登陆成功，反之则登陆失败
	private final long REGISTER_CODE_VALID_SECONDS = 180;
	
	
	private LogInIdentifyingCode logInIdentifyingCoder ;
	private Login login;
	
	public LoginAction(){
		this.setLogInIdentifyingCoder(new LogInIdentifyingCode());
	}
	
	public void setLogInIdentifyingCoder(LogInIdentifyingCode logInIdentifyingCoder){
		this.logInIdentifyingCoder = logInIdentifyingCoder;	
	}
	
	
	public void setLogin(Login login){
		this.login = login;
	}
	
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	private HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	private HttpSession getSession(){
		return this.getRequest().getSession();
	}
	
	private PrintWriter getPrintWriter(){
		PrintWriter printWriter = null;
		try{
			printWriter = this.getResponse().getWriter();
		}catch(IOException e){
			e.printStackTrace();
		}
		return printWriter;
	}
	
	private String getUserName(){
		String userName = this.getRequest().getParameter(USERNAME_KEY);
		userName = userName.trim();
		return userName;
	}
	
	private String getUserPassword(){
		String password = this.getRequest().getParameter(PASSWORD_KEY);
		password = password.trim();
		return password;
	}
	
	private String getUserIdentifyingCode(){
		String identifyingCode = this.getRequest().getParameter(IDENTIFYING_CODE_KEY);
		identifyingCode = identifyingCode.trim();
		return identifyingCode;
	}
	
	private String getPhoneNumber(String userName){
		String phoneNumber = this.login.getPhoneNumber(userName);
		return phoneNumber;
	}
	
	//下面的函数是用来检测用户最新产生的验证码的是否已经失效，如果当前用户还没有创建注册码的话，我们认为是失效的
	private boolean isLoginIdentifyingCodeLoseEfficacy(){
		boolean isLoseEfficacy = true;
		if(this.logInIdentifyingCoder.getIdentifyingCode() == null){
			isLoseEfficacy = true;
		}else{
			Date loginIdentifyingCodeCreateTime = this.logInIdentifyingCoder.getIdentifyingCodeCreateTime();
			Date currentTime = new Date();
			long interval = (currentTime.getTime() - loginIdentifyingCodeCreateTime.getTime()) / 1000;
			if(interval < this.REGISTER_CODE_VALID_SECONDS){
				isLoseEfficacy = false;
			}else{
				isLoseEfficacy = true;
			}
		}
		return isLoseEfficacy;
	}
	
	public void sendLoginIdentifyingCode() throws Exception{
		String userName = this.getUserName();
		String phoneNumber = this.getPhoneNumber(userName);
		if(!isLoginIdentifyingCodeLoseEfficacy()){
			this.getPrintWriter().println("loginCode_created");
		}else if(phoneNumber != null){
			this.logInIdentifyingCoder.sendAndSaveIdentifyingCode(phoneNumber);
			this.getPrintWriter().println("success");
		}else{
			this.getPrintWriter().println("user_not_exist");
		}
	}
	
	private String Md5Password(String password){
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		return password;
	}
	
	public void registerUserLoginSucess(String userName){
		HttpSession session = this.getSession();
		session.setAttribute(this.USERNAME_KEY, userName);
		session.setAttribute(this.LOGIN_STATE_KEY, true);
	}
	
	public void login() throws Exception{
		if(isLoginIdentifyingCodeLoseEfficacy()){
			this.getPrintWriter().println("loginCode_lose_efficacy");
			return;
		}
		String userName = this.getUserName();
		String password =  Md5Password(this.getUserPassword());
		JSONObject loginResultObjectJSON = new  JSONObject();
		if(this.login.isUserNameAndPasswordCorrect(userName, password)){
			registerUserLoginSucess(userName);
			loginResultObjectJSON.put("isLoginSuccess", true);
			loginResultObjectJSON.put("userName", this.getSession().getAttribute(this.USERNAME_KEY));
		}else{
			loginResultObjectJSON.put("isLoginSuccess", false);			
		}
		this.getPrintWriter().println(loginResultObjectJSON);
	}
	
	public void isUserLogin() throws Exception{
		HttpSession session = this.getSession();
		String userName = (String)session.getAttribute(this.USERNAME_KEY);
		Boolean loginStateBooleanObject = (Boolean)session.getAttribute(this.LOGIN_STATE_KEY);
		boolean loginState = false;
		if(loginStateBooleanObject != null){
			loginState = loginStateBooleanObject.booleanValue();
		}
		JSONObject loginObjectJSON = new  JSONObject();
		if(userName != null &&
				loginState){
			loginObjectJSON.put("loginState", true);
			loginObjectJSON.put("userName", this.getSession().getAttribute(this.USERNAME_KEY));
		}else{
			loginObjectJSON.put("loginState", false);
			//loginObjectJSON.put("userName", "wanglei20116527");
		}
		System.out.println(this.getSession().getAttribute(this.USERNAME_KEY));
		System.out.println(this.getSession().getAttribute(this.LOGIN_STATE_KEY));
		this.getPrintWriter().println(loginObjectJSON);
	}
	
	

}
