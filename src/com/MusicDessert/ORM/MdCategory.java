package com.MusicDessert.ORM;

import java.util.HashSet;
import java.util.Set;

/**
 * MdCategory entity. @author MyEclipse Persistence Tools
 */

public class MdCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private MdUser mdUser;
	private String name;
	private Set mdMusics = new HashSet(0);

	// Constructors

	/** default constructor */
	public MdCategory() {
	}

	/** minimal constructor */
	public MdCategory(MdUser mdUser, String name) {
		this.mdUser = mdUser;
		this.name = name;
	}

	/** full constructor */
	public MdCategory(MdUser mdUser, String name, Set mdMusics) {
		this.mdUser = mdUser;
		this.name = name;
		this.mdMusics = mdMusics;
	}

	// Property accessors

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

	public Set getMdMusics() {
		return this.mdMusics;
	}

	public void setMdMusics(Set mdMusics) {
		this.mdMusics = mdMusics;
	}

}