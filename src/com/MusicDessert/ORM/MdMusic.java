package com.MusicDessert.ORM;

/**
 * MdMusic entity. @author MyEclipse Persistence Tools
 */

public class MdMusic implements java.io.Serializable {

	// Fields

	private Integer id;
	private MdCategory mdCategory;
	private MdUser mdUser;
	private String name;
	private String path;
	private String picturePath;

	public MdMusic() {
		//mdUser = new MdUser();
		//mdCategory = new MdCategory();
	}

	/** minimal constructor */
	public MdMusic(MdUser mdUser, String name, String path) {
		this.mdUser = mdUser;
		this.name = name;
		this.path = path;
	}

	/** full constructor */
	public MdMusic(MdCategory mdCategory, MdUser mdUser, String name,
			String path, String picturePath) {
		this.mdCategory = mdCategory;
		this.mdUser = mdUser;
		this.name = name;
		this.path = path;
		this.picturePath = picturePath;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MdCategory getMdCategory() {
		return this.mdCategory;
	}

	public void setMdCategory(MdCategory mdCategory) {
		this.mdCategory = mdCategory;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPicturePath() {
		return this.picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}