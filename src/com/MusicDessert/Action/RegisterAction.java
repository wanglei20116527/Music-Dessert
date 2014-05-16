
package com.MusicDessert.Action;

import com.MusicDessert.ORM.MdUser;
import com.MusicDessert.Service.Register;
import com.MusicDessert.Service.implement.RegisterIdentifyingCode;

import java.io.PrintWriter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.DigestUtils;


import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private final long REGISTER_CODE_VALID_SECONDS = 180;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private PrintWriter out;
	
	private Register register;
	private RegisterIdentifyingCode registerIdentifyingCoder;
	
	RegisterAction(){
		try{
			this.request = ServletActionContext.getRequest ();
			this.response = ServletActionContext.getResponse();
			this.session = request.getSession();
			this.out = response.getWriter();
			this.setRegisterIdentifyingCoder(new RegisterIdentifyingCode());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setRegister(Register register) {
		this.register = register;
	}

	private String getRegisterPhoneNumber(){
		String phoneNumber = this.request.getParameter("phoneNumber");
		return phoneNumber;
	}
	
	private String getRegisterUserName(){
		String userName = this.request.getParameter("userName");
		return userName;
	}
	
	private String getRegisterPassword(){
		String password = this.request.getParameter("password");
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		return password;
	}
	
	private String getInputRegisterIdentifyingCode(){
		String registerIdentifyingCode = this.request.getParameter("identifyingCode");
		return registerIdentifyingCode;
	}
	
	public RegisterIdentifyingCode getRegisterIdentifyingCoder() {
		return registerIdentifyingCoder;
	}

	public void setRegisterIdentifyingCoder(RegisterIdentifyingCode registerIdentifyingCoder) {
		this.registerIdentifyingCoder = registerIdentifyingCoder;
	}

	public void register() throws Exception{
		try{
			String userName = getRegisterUserName();
			String password = getRegisterPassword();
			String phoneNumber = getRegisterPhoneNumber();
			String identifyingCode = getInputRegisterIdentifyingCode();
			if(!this.isUserNameValid(userName)){
				out.println("userName_valid");
				return;
			}
			if(!this.isUserPasswordValid(password)){
				out.println("password_valid");
				return;
			}
			if(!this.isPhoneNumberValid(phoneNumber)){
				out.println("phoneNumber_valid");
				return;
			}
			if(this.isUserName(userName)){
				out.println("userName_registered");
				return;
			}
			if(this.isPhoneNumberRegistered(phoneNumber)){
				out.println("phoneNumber_registered");
				return;	
			}
			if(this.isRegisterIdentifyingCodeLoseEfficacy()){
				out.println("identifyingCode_Lose_Efficacy");
				return;
			}
			if(!isIdentifyingCodeCorrect(identifyingCode)){
				out.println("identifyingCode_wrong");//�������ֵ��ʾ�����û��������֤���Ǵ���ģ��������û���û�в�����֤��
				return;
			}
			
			MdUser user = new MdUser(userName, password, phoneNumber);
			this.register.register(user);
			out.println("success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private boolean isUserNameValid(String userName){
		final String  REGEXP_EXPRESSION = "^[a-zA-Z][0-9a-zA-Z]{1,}$";
		Pattern pattern = Pattern.compile(REGEXP_EXPRESSION);
		Matcher matcher = pattern.matcher(userName);
		boolean isUserNameValid = matcher.matches();
		return isUserNameValid;
	}
	
	private boolean isUserPasswordValid(String password){
		return true;//����������û�ע��ʹ�õ����룬�����Ժ���ʱ���д
	}
	
	private boolean isPhoneNumberValid(String phoneNumber){
		final String  REGEXP_EXPRESSION = "^1[3|5|8][0-9]{9}";
		Pattern pattern = Pattern.compile(REGEXP_EXPRESSION);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isPhoneNumberValid = matcher.matches();
		return isPhoneNumberValid;
	}
	
	private boolean isUserName(String userName){
		boolean isUserNameRegistered = this.register.isUserNameRegistered(userName);
		return isUserNameRegistered;
	}
	
	private boolean isIdentifyingCodeCorrect(String identifyingCode){
		boolean isIdentifyingCodeCorrect= false; 
		if(this.getRegisterIdentifyingCoder().getIdentifyingCode() == null){
			isIdentifyingCodeCorrect = false;	
		}else if(this.getRegisterIdentifyingCoder().getIdentifyingCode().equals(identifyingCode)){
			isIdentifyingCodeCorrect = true;
		}else{
			isIdentifyingCodeCorrect = false;
		}
		return isIdentifyingCodeCorrect;
	}
	
	public void sendRegisterIdentifyingCode() throws Exception{
		try{		
			String phoneNumber = this.getRegisterPhoneNumber();
			if(isPhoneNumberRegistered(phoneNumber)){//��������������û�ע���õ��ֻ����Ƿ��Ѿ���ע����
				this.out.print("phoneNumber_registered");
				return;
			}
			if(!isRegisterIdentifyingCodeLoseEfficacy()){
				this.out.print("registerCode_created");
				return;
			}
			this.getRegisterIdentifyingCoder().sendAndSaveIdentifyingCode(phoneNumber);
			this.out.println("success");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//����ĺ�������������û�ע��ʹ�õĵ绰�����Ƿ��Ѿ���ע����
	private boolean isPhoneNumberRegistered(String phoneNumber){
		boolean phoneNumberRegistered = this.register.isPhoneNumberRegisterd(phoneNumber);
		return phoneNumberRegistered;
		
	}
	
	//����ĺ�������������û����²�������֤����Ƿ��Ѿ�ʧЧ�������ǰ�û���û�д���ע����Ļ���������Ϊ��ʧЧ��
	private boolean isRegisterIdentifyingCodeLoseEfficacy(){
		boolean isLoseEfficacy = true;
		if(this.getRegisterIdentifyingCoder().getIdentifyingCode() == null){
			isLoseEfficacy = true;
		}else{
			Date registerIdentifyingCodeCreateTime = this.getRegisterIdentifyingCoder().getIdentifyingCodeCreateTime();
			Date currentTime = new Date();
			long interval = (currentTime.getTime() - registerIdentifyingCodeCreateTime.getTime()) / 1000;
			if(interval < this.REGISTER_CODE_VALID_SECONDS){
				isLoseEfficacy = false;
			}else{
				isLoseEfficacy = true;
			}
		}
		return isLoseEfficacy;
	}
}
