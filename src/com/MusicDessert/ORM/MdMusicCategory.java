package com.MusicDessert.ORM;

import java.util.HashSet;
import java.util.Set;

public class MdMusicCategory implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private MdUser mdUser;
	private String name;
	private String description;
	private Set mdMusics = new HashSet(0);

	public MdMusicCategory() {
	}
	
	public MdMusicCategory(MdUser mdUser, String name, String description,
			Set mdMusics) {
		this.mdUser = mdUser;
		this.name = name;
		this.description = description;
		this.mdMusics = mdMusics;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MdUser getMdUser() {
		return this.mdUser;
	}

	public void setMdUser(MdUser mdUser) {
		this.mdUser = mdUser;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getMdMusics() {
		return this.mdMusics;
	}

	public void setMdMusics(Set mdMusics) {
		this.mdMusics = mdMusics;
	}

}