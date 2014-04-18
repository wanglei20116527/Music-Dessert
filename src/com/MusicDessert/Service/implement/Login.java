package com.MusicDessert.Service.implement;

import com.MusicDessert.DAO.UserDAO;
import com.MusicDessert.ORM.MdUser;

public class Login implements com.MusicDessert.Service.Login {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public String getPhoneNumber(String userName) {
		MdUser user = this.userDAO.findUserByUserName(userName);
		String phoneNumber = null;
		if(user != null){
			phoneNumber = user.getPhoneNumber();
		}else{
			phoneNumber = null;
		}
		return phoneNumber;
	}

	@Override
	public boolean isUserNameAndPasswordCorrect(String userName, String password) {
		MdUser user = this.userDAO.findUserByUserNameAndPhoneNumber(userName, password);
		boolean isUserNameAndPasswordCorrect = false;
		if(user != null){
			isUserNameAndPasswordCorrect = true;
		}else{
			isUserNameAndPasswordCorrect = false;
		}
		return isUserNameAndPasswordCorrect;
	}

}
