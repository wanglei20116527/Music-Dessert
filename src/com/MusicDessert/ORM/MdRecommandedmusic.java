package com.MusicDessert.ORM;

/**
 * MdRecommandedmusic entity. @author MyEclipse Persistence Tools
 */

public class MdRecommandedmusic implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String picturePath;

	// Constructors

	/** default constructor */
	public MdRecommandedmusic() {
	}

	/** minimal constructor */
	public MdRecommandedmusic(String name) {
		this.name = name;
	}

	/** full constructor */
	public MdRecommandedmusic(String name, String picturePath) {
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