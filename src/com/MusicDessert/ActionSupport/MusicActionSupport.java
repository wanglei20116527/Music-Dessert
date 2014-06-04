package com.MusicDessert.ActionSupport;

import javax.servlet.http.HttpSession;

import com.MusicDessert.KEY.Key;
import com.MusicDessert.Service.implement.Music;

public class MusicActionSupport extends CustomActionSupport {
	private static final long serialVersionUID = 1L;
	
	private Music music;
	
	protected final Music getMusic() {
		return music;
	}

	public final void setMusic(Music music) {
		this.music = music;
	}
	
	//����ĺ�������������ϴ��ļ����û���ID
	protected final Integer getUserID(){
		HttpSession session = this.getSession();
		Integer userID = (Integer)session.getAttribute(Key.USERID_KEY);
		return userID;
	}
		
	//����ĺ�������������ϴ��ļ��û���name
	protected final String getUserName(){
		HttpSession session = this.getSession();
		String userName = (String)session.getAttribute(Key.USERNAME_KEY);
		return userName;
	}
}
