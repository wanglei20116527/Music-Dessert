package com.MusicDessert.Service;

public interface UserInfoValidityChecker {
	public boolean isUserNameValid(String userName);
	public boolean isPasswordValid(String password);
	public boolean isPhoneNumberValid(String phoneNumber);
}
