package com.MusicDessert.DAO;

import com.MusicDessert.ORM.MdUser;

public interface UserDAO {
	public void saveUser(MdUser user);
	public MdUser findUserByUserName(String userName);
	public MdUser findUserByUserPhoneNumber(String phoneNumber);
	public MdUser findUserByUserNameAndPhoneNumber(String userName, String password);
}
