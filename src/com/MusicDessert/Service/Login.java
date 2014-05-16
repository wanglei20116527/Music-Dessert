package com.MusicDessert.Service;

public interface Login{
	public String getPhoneNumber(String userName);
	public boolean isUserNameAndPasswordCorrect(String userName, String password);
	public Integer getUserID(String userName);

}
