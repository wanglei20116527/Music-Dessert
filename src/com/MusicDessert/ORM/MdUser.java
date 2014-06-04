package com.MusicDessert.ORM;

import java.util.HashSet;
import java.util.Set;

public class MdUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String isAdmin_Default_Value = "N";//表示isAdmin字段的默认值
	
	private Integer id;
	private String userName;
	private String password;
	private String phoneNumber;
	private String isAdmin;
	private Set mdUserMusics = new HashSet(0);
	private Set mdMusicCategories = new HashSet(0);

	public MdUser() {
	}
	
	public MdUser(String userName, String password, String phoneNumber){
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.isAdmin = isAdmin_Default_Value;
	}

	public MdUser(String userName, String password, String phoneNumber,
			String isAdmin) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.isAdmin = isAdmin;
	}

	public MdUser(String userName, String password, String phoneNumber,
			String isAdmin, Set mdUserMusics, Set mdMusicCategories) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.isAdmin = isAdmin;
		this.mdUserMusics = mdUserMusics;
		this.mdMusicCategories = mdMusicCategories;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set getMdUserMusics() {
		return this.mdUserMusics;
	}

	public void setMdUserMusics(Set mdUserMusics) {
		this.mdUserMusics = mdUserMusics;
	}

	public Set getMdMusicCategories() {
		return this.mdMusicCategories;
	}

	public void setMdMusicCategories(Set mdMusicCategories) {
		this.mdMusicCategories = mdMusicCategories;
	}

}