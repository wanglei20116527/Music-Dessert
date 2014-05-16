package com.MusicDessert.DAO;

import java.util.List;

import com.MusicDessert.ORM.MdMusic;
import com.MusicDessert.ORM.MdUser;

public interface UserMusicDAO {
	public void saveUserMusic(MdMusic userMusic);
	public List<MdMusic> getUserMusicsByUserID(Integer userID);
}
