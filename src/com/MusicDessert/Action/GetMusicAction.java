package com.MusicDessert.Action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MusicDessert.ActionSupport.MusicActionSupport;
import com.MusicDessert.KEY.Key;
import com.MusicDessert.ORM.MdMusic;

public class GetMusicAction extends MusicActionSupport {
	private static final long serialVersionUID = 1L;

	public void getMusics(){
		try{
			JSONArray musicsArrayJSON = new JSONArray(); 
			List<MdMusic> musics = null;
			if(this.isUserLogin()){
				musics = this.getMusic().getUserMusics(this.getUserID());
			}else{
				musics = this.getMusic().getSystemMusics();
			}
			if(musics != null){
				for(int i = 0; i < musics.size(); ++i){
					JSONObject musicObjectJSON = new JSONObject();
					MdMusic music = musics.get(i);
					musicObjectJSON.put("musicID", music.getId());
					musicObjectJSON.put("musicName", music.getDisplayName());
					musicObjectJSON.put("musicPath", music.getPath());
					musicsArrayJSON.add(musicObjectJSON);
				}
			}
			this.getPrintWriter().print(musicsArrayJSON);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public boolean isUserLogin(){
		boolean isUserLogin = false;
		Boolean loginStateBooleanObject = (Boolean)this.getSession().getAttribute(Key.LOGIN_STATE_KEY);
		if(loginStateBooleanObject != null && loginStateBooleanObject.booleanValue()){
			isUserLogin = true;
		}
		return isUserLogin;
	}
}
