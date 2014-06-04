package com.MusicDessert.ORM;

import java.util.HashSet;
import java.util.Set;

public class MdMusic implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private MdMusicCategory mdMusicCategory;
	private String displayName;
	private String systemName;
	private String path;
	private String musician;
	private String style;
	private Set mdUserMusics = new HashSet(0);

	public MdMusic() {
	}

	public MdMusic(MdMusicCategory mdMusicCategory, String displayName,
			String systemName, String path) {
		this.mdMusicCategory = mdMusicCategory;
		this.displayName = displayName;
		this.systemName = systemName;
		this.path = path;
	}

	public MdMusic(MdMusicCategory mdMusicCategory, String displayName,
			String systemName, String path, String musician, String style,
			Set mdUserMusics) {
		this.mdMusicCategory = mdMusicCategory;
		this.displayName = displayName;
		this.systemName = systemName;
		this.path = path;
		this.musician = musician;
		this.style = style;
		this.mdUserMusics = mdUserMusics;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MdMusicCategory getMdMusicCategory() {
		return this.mdMusicCategory;
	}

	public void setMdMusicCategory(MdMusicCategory mdMusicCategory) {
		this.mdMusicCategory = mdMusicCategory;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMusician() {
		return this.musician;
	}

	public void setMusician(String musician) {
		this.musician = musician;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Set getMdUserMusics() {
		return this.mdUserMusics;
	}

	public void setMdUserMusics(Set mdUserMusics) {
		this.mdUserMusics = mdUserMusics;
	}

}