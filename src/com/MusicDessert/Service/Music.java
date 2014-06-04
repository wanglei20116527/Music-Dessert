package com.MusicDessert.Service;

import java.io.File;
import java.util.List;

import com.MusicDessert.ORM.MdMusic;

public interface Music {
	public List<MdMusic> getSystemMusics();
	public List<MdMusic> getUserMusics(Integer userID);
	public boolean saveMusic(String musicName, File tempUploadedMusic, Integer userId, String userName);
}
