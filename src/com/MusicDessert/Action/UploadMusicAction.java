package com.MusicDessert.Action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.MusicDessert.ORM.MdMusic;
import com.MusicDessert.ORM.MdUser;
import com.MusicDessert.Service.implement.UserMusic;
import com.opensymphony.xwork2.ActionSupport;


public class UploadMusicAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private final String USERNAME_KEY = "userName";
	private final String USERID_KEY = "userID";
	private File files;
	private String filesFileName;
	private String filesContentType; 
	
	private UserMusic userMusic;
	
	public void setUserMusic(UserMusic userMusic) {
		this.userMusic = userMusic;
	}

	public File getFiles() {
		return files;
	}
	
	public void setFiles(File files) {
		this.files = files;
	}
	
	public String getFilesFileName() {
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
			if(saveMusicInformationToDB() && 
					saveMusicToUserMusicFolder()){
				JSONObject uploadMusicJSONObject = new  JSONObject();
				this.getPrintWriter().print(uploadMusicJSONObject);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private boolean saveMusicInformationToDB(){
		boolean isSaveSuccess = true;
		MdMusic music = new MdMusic();
		String musicName = filesFileName;
		music.setName(musicName);
		
		String userName = this.getUserName();
		String musicPath = this.userMusic.getUserMusicFolderPath(userName) + "/" + musicName;
		music.setPath(musicPath);
		
		MdUser user = new MdUser();
		Integer userID = this.getUserID();
		user.setId(userID);
		music.setMdUser(user);
		
		this.userMusic.saveUserMusicToDB(music);
		return isSaveSuccess;
	}
	
	private boolean saveMusicToUserMusicFolder(){
		String userName = this.getUserName();
		boolean isSaveSuccess = this.userMusic.saveUserMusicToUserMusicFolder(userName, filesFileName, files);
		return isSaveSuccess;
	}
	
	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	private HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	private HttpSession getSession(){
		return this.getRequest().getSession();
	}
	
	private PrintWriter getPrintWriter(){
		PrintWriter printWriter = null;
		try{
			printWriter = this.getResponse().getWriter();
		}catch(IOException e){
			e.printStackTrace();
		}
		return printWriter;
	}
	
	private String getUserName(){
		HttpSession session = this.getSession();
		String userName = (String)session.getAttribute(this.USERNAME_KEY);
		return userName;
	}
	
	private Integer getUserID(){
		HttpSession session = this.getSession();
		Integer userID = (Integer)session.getAttribute(this.USERID_KEY);
		return userID;
	}
}

