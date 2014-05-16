package com.MusicDessert.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.MusicDessert.ORM.MdMusic;
import com.MusicDessert.ORM.MdRecommandedmusic;
import com.MusicDessert.Service.implement.Recommandedmusic;
import com.MusicDessert.Service.implement.User;
import com.MusicDessert.Service.implement.UserMusic;
import com.opensymphony.xwork2.ActionSupport;

public class MusicAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Recommandedmusic recommandedMusic;
	private UserMusic userMusic;
	private User user;
	
	public void setRecommandedMusic(Recommandedmusic recommandedMusic) {
		this.recommandedMusic = recommandedMusic;
	}
	
	public void setUserMusic(UserMusic userMusic) {
		this.userMusic = userMusic;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	private PrintWriter getPrintWriter() {
		PrintWriter printWriter = null;
		try{
			printWriter = ServletActionContext.getResponse().getWriter();
		}catch(IOException e){
			e.printStackTrace();
		}
		return printWriter;
	}
	
	private JSONArray addRecommandedmusicsToMusicArrayJSON(JSONArray musicsArrayJSON, 
			List<MdRecommandedmusic> recommandedMusics){
		for(int i = 0; i < recommandedMusics.size(); ++i){
			JSONObject musicObjectJSON = new   JSONObject();
			MdRecommandedmusic music = recommandedMusics.get(i);
			Integer musicID = music.getId();
			musicObjectJSON.put("musicID", musicID);
			String musicName = music.getName();
			musicObjectJSON.put("musicName", musicName);
			String musicPath = music.getPicturePath();
			musicObjectJSON.put("musicPath", musicPath);
			musicsArrayJSON.add(musicObjectJSON);
		}
		return musicsArrayJSON;
	}
	
	private JSONArray addUserMusicsToMusicArrayJSON(JSONArray musicsArrayJSON, 
			List<MdMusic> userMusics){
		for(int i = 0; i < userMusics.size(); ++i){
			JSONObject musicObjectJSON = new   JSONObject();
			MdMusic music = userMusics.get(i);
			Integer musicID = music.getId();
			musicObjectJSON.put("musicID", musicID);
			String musicName = music.getName();
			musicObjectJSON.put("musicName", musicName);
			String musicPath = music.getPath();
			musicObjectJSON.put("musicPath", musicPath);
			musicsArrayJSON.add(musicObjectJSON);
		}
		return musicsArrayJSON;
	}

	public void getMusics() throws Exception{
		JSONArray musicsArrayJSON = new JSONArray(); 
		
		List<MdRecommandedmusic> recommandedMusics = this.recommandedMusic.getAllRecommandedmusics();
		musicsArrayJSON = this.addRecommandedmusicsToMusicArrayJSON(musicsArrayJSON, recommandedMusics);
		
		if(this.user.isUserLogin()){//这里是用来判断当前用户是否已经登录了
			Integer userID = this.user.getLoginedUserID();
			List<MdMusic> userMusics = this.userMusic.getUserMusicsByUserID(userID);
			musicsArrayJSON = this.addUserMusicsToMusicArrayJSON(musicsArrayJSON, userMusics);
		}
		
		this.getPrintWriter().print(musicsArrayJSON);
		
	}
}
