
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
			if(!this.getUserInfoValidityChecker().isUserNameValid(userName)){//����û����Ƿ�Ϸ�
				this.getPrintWriter().println("UserName_Invalid");
				return;
			}
			if(!this.getUserInfoValidityChecker().isPasswordValid(password)){//����û������Ƿ�Ϸ�
				this.getPrintWriter().println("Password_Invalid");
				return;
			}
			if(!this.getUserInfoValidityChecker().isPhoneNumberValid(phoneNumber)){//����û����ֻ����Ƿ�Ϸ�
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
			if(this.getIdentifyingCodeFactory().isIdentifyingCodeBeenSended() && // �ж�ע�����Ƿ��ѱ�ע��
					!this.getIdentifyingCodeFactory().isIdentifyingCodeLoseEfficacy()){//�жϷ��͵�ע�����Ƿ��Ѿ�ʧЧ
				this.getPrintWriter().print("IdentifyingCode_Created");
			}else if(this.getRegister().isPhoneNumberRegistered(phoneNumber)){//��������������û�ע���õ��ֻ����Ƿ��Ѿ���ע����
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
