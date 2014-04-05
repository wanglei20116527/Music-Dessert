package com.MusicDessert.ORM;

import java.util.HashSet;
import java.util.Set;

public class MdUser implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String password;
	private String phoneNumber;
	private Set mdCategories = new HashSet(0);


	public MdUser() {
	}

	public MdUser(String name, String password, String phoneNumber) {
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public MdUser(String name, String password, String phoneNumber,
			Set mdCategories) {
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.mdCategories = mdCategories;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getMdCategories() {
		return this.mdCategories;
	}

	public void setMdCategories(Set mdCategories) {
		this.mdCategories = mdCategories;
	}

}