package com.MusicDessert.Service.implement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInfoValidityChecker implements
		com.MusicDessert.Service.UserInfoValidityChecker {

	@Override
	public boolean isUserNameValid(String userName) {
		final String  REGEXP_EXPRESSION = "^[a-zA-Z][0-9a-zA-Z]{1,}$";
		Pattern pattern = Pattern.compile(REGEXP_EXPRESSION);
		Matcher matcher = pattern.matcher(userName);
		boolean isUserNameValid = matcher.matches();
		return isUserNameValid;
	}

	@Override
	public boolean isPasswordValid(String password) {
		return true;
	}

	@Override
	public boolean isPhoneNumberValid(String phoneNumber) {
		final String  REGEXP_EXPRESSION = "^1[3|5|8][0-9]{9}";
		Pattern pattern = Pattern.compile(REGEXP_EXPRESSION);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isPhoneNumberValid = matcher.matches();
		return isPhoneNumberValid;
	}

}
