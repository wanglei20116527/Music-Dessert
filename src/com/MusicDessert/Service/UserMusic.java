package com.MusicDessert.Service;

import java.io.File;
import java.util.List;

import com.MusicDessert.ORM.MdMusic;

public interface UserMusic {
	public String getUserMusicFolderPath(String userName);
	public boolean saveUserMusicToDB(MdMusic userMusic);
	public boolean saveUserMusicToUserMusicFolder(String userName, String musicName, File musicFile);
	public List<MdMusic> getUserMusicsByUserID(Integer userID);
	

}
