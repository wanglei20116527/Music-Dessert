package com.MusicDessert.Service.implement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.MusicDessert.DAO.implement.UserMusicDAO;
import com.MusicDessert.ORM.MdMusic;
import com.MusicDessert.ORM.MdUser;

public class UserMusic implements com.MusicDessert.Service.UserMusic {
	private UserMusicDAO userMusicDAO;
	
	public void setUserMusicDAO(UserMusicDAO userMusicDAO) {
		this.userMusicDAO = userMusicDAO;
	}
	
	@Override
	public String getUserMusicFolderPath(String userName){
		String userMusicFolderPath = "User/" + userName;
		return userMusicFolderPath;
	}

	@Override
	public boolean saveUserMusicToDB(MdMusic userMusic) {
		this.userMusicDAO.saveUserMusic(userMusic);
		return true;
	}

	@Override
	public boolean saveUserMusicToUserMusicFolder(String userName, String musicName, File musicFile) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			String userMusicFolderPath = this.getUserMusicFolderPath(userName);
			userMusicFolderPath = ServletActionContext.getServletContext().getRealPath(userMusicFolderPath);
			File userMusicFolder = new File(userMusicFolderPath);  
			if (!userMusicFolder.exists()) {  
				userMusicFolder.mkdir();  
			}
			String userMusicSavePath = userMusicFolderPath + "/" + musicName;
			File userMusic = new File(userMusicSavePath);
			fis = new FileInputStream(musicFile); 
			fos = new FileOutputStream(userMusic);
			
			byte[] buffer = new byte[1024];          
			int len = 0;  
			while((len=fis.read(buffer))>0)  
			{  
				fos.write(buffer,0,len);  
			}  
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fos != null){
					fos.flush();
					fos.close();
				}
				if(fis != null){
					fis.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public List<MdMusic> getUserMusicsByUserID(Integer userID) {
		List<MdMusic> userMusics = this.userMusicDAO.getUserMusicsByUserID(userID);
		return userMusics;
	}

}
