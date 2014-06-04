package com.MusicDessert.DAO;

import java.util.List;

import com.MusicDessert.ORM.MdUserMusic;

public interface UserMusicDAO {
	public void saveUserMusic(MdUserMusic userMusic);
	public List<MdUserMusic> getUserMusicsByUserID(Integer userID);
}
