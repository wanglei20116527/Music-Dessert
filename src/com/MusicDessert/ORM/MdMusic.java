package com.MusicDessert.ORM;

/**
 * MdMusic entity. @author MyEclipse Persistence Tools
 */

public class MdMusic implements java.io.Serializable {

	// Fields

	private Integer id;
	private MdCategory mdCategory;
	private String name;
	private String picturePath;

	// Constructors

	/** default constructor */
	public MdMusic() {
	}

	/** minimal constructor */
	public MdMusic(MdCategory mdCategory, String name) {
		this.mdCategory = mdCategory;
		this.name = name;
	}

	/** full constructor */
	public MdMusic(MdCategory mdCategory, String name, String picturePath) {
		this.mdCategory = mdCategory;
		this.name = name;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicturePath() {
		return this.picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

}