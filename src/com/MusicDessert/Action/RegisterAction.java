
package com.MusicDessert.Action;

import com.MusicDessert.ActionSupport.RegisterAndLoginActionSupport;
import com.MusicDessert.KEY.Key;

import com.MusicDessert.ORM.MdUser;
import com.MusicDessert.Service.IdentifyingCodeFactory;
import com.MusicDessert.Service.Register;

public final class RegisterAction extends RegisterAndLoginActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Register register;
	
	public void setRegister(Register register) {
		this.register = register;
	}
	
	private Register getRegister() {
		return register;
	}
	
	public void register(){
		try{
			String userName = this.getUserName();
			String password = this.getPassword();
			String phoneNumber = this.getPhoneNumber();
			String identifyingCode = this.getIdentifyingCode();
			if(!this.getUserInfoValidityChecker().isUserNameValid(userName)){//检查用户名是否合法
				this.getPrintWriter().println("UserName_Invalid");
				return;
			}
			if(!this.getUserInfoValidityChecker().isPasswordValid(password)){//检查用户密码是否合法
				this.getPrintWriter().println("Password_Invalid");
				return;
			}
			if(!this.getUserInfoValidityChecker().isPhoneNumberValid(phoneNumber)){//检测用户的手机号是否合法
				this.getPrintWriter().println("PhoneNumber_Invalid");
				return;
			}
			if(this.getRegister().isUserNameRegistered(userName)){
				this.getPrintWriter().println("UserName_Registered");
				return;
			}
			if(this.getRegister().isPhoneNumberRegistered(phoneNumber)){
				this.getPrintWriter().println("PhoneNumber_Registered");
				return;	
			}
			/*IdentifyingCodeFactory.IdentifyingCodeState identifyingCodeState =
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
				MdUser user = new MdUser(userName, password, phoneNumber);
				this.getRegister().register(user);
				this.getPrintWriter().println("Success");
			}*/
			MdUser user = new MdUser(userName, password, phoneNumber);
			this.getRegister().register(user);
			this.getPrintWriter().println("Success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void sendIdentifyingCode() {
		try{		
			String phoneNumber = this.getPhoneNumber();
			if(this.getIdentifyingCodeFactory().isIdentifyingCodeBeenSended() && // 判断注册吗是否已被注册
					!this.getIdentifyingCodeFactory().isIdentifyingCodeLoseEfficacy()){//判断发送的注册吗是否已经失效
				this.getPrintWriter().print("IdentifyingCode_Created");
			}else if(this.getRegister().isPhoneNumberRegistered(phoneNumber)){//这里是用来检测用户注册用的手机号是否已经被注册了
				this.getPrintWriter().print("PhoneNumber_Registered");
			}else{
				this.getIdentifyingCodeFactory().sendAndSaveIdentifyingCode(phoneNumber);
				this.getPrintWriter().println("Success");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected String getPhoneNumber() {
		String phoneNumber = this.getRequest().getParameter(Key.PHONE_NUMBER_KEY);
		phoneNumber = phoneNumber.trim();
		return phoneNumber;
	}	
}
