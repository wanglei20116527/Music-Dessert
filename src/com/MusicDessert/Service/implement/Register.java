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
		return isFolderMakeSuccess;
	}

	@Override
	public void register(MdUser user) {
		System.out.println("Service register start");
		this.userDAO.saveUser(user);
		String folderName = user.getName();
		createUserMusicFolder(folderName);
		System.out.println("Service register end");
	}
	
	

}
