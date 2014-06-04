package com.MusicDessert.Service.implement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.DigestUtils;

import com.MusicDessert.ORM.MdMusic;
import com.MusicDessert.ORM.MdMusicCategory;
import com.MusicDessert.ORM.MdUser;
import com.MusicDessert.ORM.MdUserMusic;
import com.MusicDessert.DAO.implement.MusicDAO;
import com.MusicDessert.DAO.implement.UserDAO;
import com.MusicDessert.DAO.implement.UserMusicDAO;

public class Music implements com.MusicDessert.Service.Music {
	private MusicDAO musicDAO;
	private UserMusicDAO userMusicDAO;
	private UserDAO userDAO;
	
	private MusicDAO getMusicDAO() {
		return musicDAO;
	}

	public void setMusicDAO(MusicDAO musicDAO) {
		this.musicDAO = musicDAO;
	}

	private UserMusicDAO getUserMusicDAO() {
		return userMusicDAO;
	}

	public void setUserMusicDAO(UserMusicDAO userMusicDAO) {
		this.userMusicDAO = userMusicDAO;
	}
	
	private UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public List<MdMusic> getSystemMusics(){
		List<MdMusic> systemMusics = this.getMusicDAO().getMusicsByCategoryID(MusicDAO.SYSTEM_MUSIC_DEFAULT_CATEGORY_ID);
		return systemMusics;
	}

	@Override
	public List<MdMusic> getUserMusics(Integer userID) {
		List<MdMusic> userMusics = null;
		List<MdUserMusic> mdUserMusics = this.getUserMusicDAO().getUserMusicsByUserID(userID);
		
		if(mdUserMusics != null){
			List<Integer> ids = new ArrayList<Integer>();
			for(int i = 0; i < mdUserMusics.size(); ++i){
				Integer musicId = mdUserMusics.get(i).getMdMusic().getId();
				ids.add(musicId);
			}
			userMusics = this.getMusicDAO().getMusicsByMusicIDs(ids);
		}
		return userMusics;
	}
	
	@Override
	public boolean saveMusic(String musicName, File tempUploadedMusic, Integer userId, String userName){
		final String musicDispayName = this.getMusicDisplayName(musicName);
		final String musicSystemName = this.getMusicSystemName(musicName, userName);
		final String musicRelativePath = this.getMusicRelativePath(musicSystemName);
		MdMusicCategory musicCategory = new MdMusicCategory();
		if(this.getUserDAO().isAdmin(userId)){
			musicCategory.setId(MusicDAO.SYSTEM_MUSIC_DEFAULT_CATEGORY_ID);
		}else{
			musicCategory.setId(MusicDAO.USER_MUSIC_DEFAULT_CATEGORY_ID);
		}
		
		//这里是用来将用户上传的音乐的信息给保存到数据库中去
		MdMusic music = new MdMusic();
		music.setDisplayName(musicDispayName);
		music.setSystemName(musicSystemName);
		music.setPath(musicRelativePath);
		music.setMdMusicCategory(musicCategory);
		music = this.getMusicDAO().saveMusic(music);
		
		//如果上传者不是管理员的话，那么我们就需要将音乐盒用户的关系个保存到数据中去
		if(!this.getUserDAO().isAdmin(userId)){
			MdUserMusic userMusic = new MdUserMusic();
			userMusic.setMdMusic(music);
			MdUser user = new MdUser();
			user.setId(userId);
			userMusic.setMdUser(user);
			userMusic.setPlayTimes(0);
			this.getUserMusicDAO().saveUserMusic(userMusic);
		}
				
		this.saveMusicToFileSystem(musicSystemName, tempUploadedMusic);
		
		return true;
	}
	
	private void saveMusicToFileSystem(String musicSystemName, File tempUploadedMusic){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			final String musicAbsolutePath = this.getMusicAbsolutePath(musicSystemName);
			File muisc= new File(musicAbsolutePath);
			fis = new FileInputStream(tempUploadedMusic); 
			fos = new FileOutputStream(muisc);
			
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
	}
	
	private String getMusicRelativePath(String musicSystemName){
		final String Parent_Directory = "Music";
		String musicRelativePath = Parent_Directory + "/" + musicSystemName;
		return musicRelativePath;
	}
	
	private String getMusicAbsolutePath(String musicSystemName){
		String musicRelativePath = this.getMusicRelativePath(musicSystemName);
		String MusicAbsolutePath =  ServletActionContext.getServletContext().getRealPath(musicRelativePath);;
		return MusicAbsolutePath;
	}
	
	//文件名没有后缀
	private String getMusicDisplayName(String musicName){
		int indexOfLastPointer = musicName.lastIndexOf(".");
		String musicDisplayName = musicName.substring(0, indexOfLastPointer);
		System.out.println("MusicDisplayName: " + musicDisplayName);
		return musicDisplayName;
	}
	
	//文件名是有后缀的
	private String getMusicSystemName(String musicName, String userName){
		Date date =  new Date();
		String musicSystemName = musicName + "-" + userName + "-" + date.toString();
		musicSystemName =  DigestUtils.md5DigestAsHex(musicSystemName.getBytes());
		musicSystemName += "." + this.getMusicFileSuffix(musicName);
		return musicSystemName;
	}
	
	private String getMusicFileSuffix(String musicName){
		int indexOfLastPointer = musicName.lastIndexOf(".");
		String musicFileSuffix = musicName.substring(indexOfLastPointer + 1);
		return musicFileSuffix;
	}
}
