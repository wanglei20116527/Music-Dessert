package com.MusicDessert.Action;

import java.io.File;

import com.MusicDessert.ActionSupport.MusicActionSupport;

import net.sf.json.JSONObject;

public class UploadMusicAction extends MusicActionSupport {
	private static final long serialVersionUID = 1L;
	private File files;
	private String filesFileName;
	private String filesContentType; 
	
	private File getFiles() {
		return files;
	}
	
	public void setFiles(File files) {
		this.files = files;
	}
	
	private String getFilesFileName() {
		return filesFileName;
	}

	public void setFilesFileName(String filesFileName) {
		this.filesFileName = filesFileName;
	}

	public String getFilesContentType() {
		return filesContentType;
	}
	
	public void setFilesContentType(String filesContentType) {
		this.filesContentType = filesContentType;
	}

	public void uploadMusic(){
		try{
			String musicName = this.getFilesFileName();
			File tempUploadedMusic = this.getFiles();
			this.getMusic().saveMusic(musicName, tempUploadedMusic, this.getUserID(), this.getUserName());
			JSONObject uploadMusicJSONObject = new  JSONObject();
			this.getPrintWriter().print(uploadMusicJSONObject);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

