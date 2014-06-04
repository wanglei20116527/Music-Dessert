package com.MusicDessert.ORM;

//MdUserMusic entity

public class MdUserMusic implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private MdUser mdUser;
	private MdMusic mdMusic;
	private Integer playTimes;

	public MdUserMusic() {
	}

	public MdUserMusic(MdUser mdUser, MdMusic mdMusic) {
		this.mdUser = mdUser;
		this.mdMusic = mdMusic;
	}
	
	public MdUserMusic(MdUser mdUser, MdMusic mdMusic, Integer playTimes) {
		this.mdUser = mdUser;
		this.mdMusic = mdMusic;
		this.playTimes = playTimes;
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

	public MdMusic getMdMusic() {
		return this.mdMusic;
	}

	public void setMdMusic(MdMusic mdMusic) {
		this.mdMusic = mdMusic;
	}

	public Integer getPlayTimes() {
		return this.playTimes;
	}

	public void setPlayTimes(Integer playTimes) {
		this.playTimes = playTimes;
	}

}