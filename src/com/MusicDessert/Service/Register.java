package com.MusicDessert.Service;

import com.MusicDessert.ORM.MdUser;

public interface Register {
	public void register(MdUser user);
	public boolean isUserNameRegistered(String userName);
	public boolean isPhoneNumberRegistered(String phoneNumber);
}
