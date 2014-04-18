package com.MusicDessert.Service.implement;

import com.MusicDessert.DAO.UserDAO;
import com.MusicDessert.ORM.MdUser;

public class Register implements com.MusicDessert.Service.Register {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	private boolean createUserMusicFolder(String folderName){
		FolderMaker folderMaker = new FolderMaker();
		boolean isFolderMakeSuccess = folderMaker.makeDirectory(folderName);
		System.out.println("***************************************");
		System.out.println("isFolderMakeSuccess: " + isFolderMakeSuccess);
		System.out.println("***************************************");
		return isFolderMakeSuccess;
	}

	@Override
	public void register(MdUser user) {
		System.out.println("Service register start");
		this.userDAO.saveUser(user);
		String folderName = user.getName();
		System.out.println("wanglei is cool");
		createUserMusicFolder(folderName);
		System.out.println("Service register end");
	}
	
	@Override
	public boolean isUserNameRegistered(String userName){
		MdUser user = this.userDAO.findUserByUserName(userName);
		boolean isUserNameRegistered = true;
		if(user == null){
			isUserNameRegistered = false;
		}else{
			isUserNameRegistered = true;
		}
		return isUserNameRegistered;
	}
	@Override
	public boolean isPhoneNumberRegisterd(String phoneNumber){
		MdUser user = this.userDAO.findUserByUserPhoneNumber(phoneNumber);
		boolean isPhoneNumberRegisterd = true;
		if(user == null){
			isPhoneNumberRegisterd = false;
		}else{
			isPhoneNumberRegisterd = true;
		}
		return isPhoneNumberRegisterd;
	}
}
