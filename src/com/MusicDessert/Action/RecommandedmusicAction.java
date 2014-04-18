package com.MusicDessert.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.MusicDessert.ORM.MdRecommandedmusic;
import com.MusicDessert.Service.implement.Recommandedmusic;
import com.opensymphony.xwork2.ActionSupport;

public class RecommandedmusicAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Recommandedmusic recommandedMusic;
	
	private PrintWriter getPrintWriter() {
		PrintWriter printWriter = null;
		try{
			printWriter = ServletActionContext.getResponse().getWriter();
		}catch(IOException e){
			e.printStackTrace();
		}
		return printWriter;
	}
	public void setRecommandedMusic(Recommandedmusic recommandedMusic) {
		this.recommandedMusic = recommandedMusic;
	}

	public void getAllRecommandedmusics() throws Exception{
		List<MdRecommandedmusic> musics = this.recommandedMusic.getAllRecommandedmusics();
		System.out.println(musics.size());
		JSONArray musicsArrayJSON = new JSONArray(); 
		for(int i = 0; i < musics.size(); ++i){
			JSONObject musicObjectJSON = new   JSONObject();
			MdRecommandedmusic music = musics.get(i);
			Integer musicID = music.getId();
			musicObjectJSON.put("musicID", musicID);
			String musicName = music.getName();
			musicObjectJSON.put("musicName", musicName);
			String musicPath = music.getPicturePath();
			musicObjectJSON.put("musicPath", musicPath);
			musicsArrayJSON.add(musicObjectJSON);
		}
		this.getPrintWriter().print(musicsArrayJSON);
		
	}
}
