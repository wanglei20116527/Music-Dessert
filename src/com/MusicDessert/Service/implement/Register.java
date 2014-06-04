package com.MusicDessert.Service.implement;

import com.MusicDessert.DAO.UserDAO;
import com.MusicDessert.ORM.MdUser;

public class Register implements com.MusicDessert.Service.Register {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void register(MdUser user) {
		this.userDAO.saveUser(user);
	}
	
	@Override
	public boolean isUserNameRegistered(String userName){
		MdUser user = this.userDAO.findUserByUserName(userName);
		boolean isUserNameRegistered = true;
		if(user == null){
			isUserNameRegistered = false;
		}
		return isUserNameRegistered;
	}
	
	@Override
	public boolean isPhoneNumberRegistered(String phoneNumber){
		MdUser user = this.userDAO.findUserByUserPhoneNumber(phoneNumber);
		boolean isPhoneNumberRegisterd = true;
		if(user == null){
			isPhoneNumberRegisterd = false;
		}
		return isPhoneNumberRegisterd;
	}
}
