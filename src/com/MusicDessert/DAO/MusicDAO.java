package com.MusicDessert.DAO;

import java.util.List;

import com.MusicDessert.ORM.MdMusic;

public interface MusicDAO {
	public static final int SYSTEM_MUSIC_DEFAULT_CATEGORY_ID = 1;
	public static final int USER_MUSIC_DEFAULT_CATEGORY_ID = 100;
	
	public MdMusic saveMusic(MdMusic music);
	public List<MdMusic> getMusicsByMusicIDs(List<Integer> ids);
	public List<MdMusic> getMusicsByCategoryID(Integer categoryID);
}
