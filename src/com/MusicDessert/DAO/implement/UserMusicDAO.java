package com.MusicDessert.DAO.implement;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.MusicDessert.ORM.MdMusic;
import com.MusicDessert.ORM.MdUser;

public class UserMusicDAO extends HibernateDaoSupport implements
		com.MusicDessert.DAO.UserMusicDAO {

	@Override
	public void saveUserMusic(MdMusic userMusic) {
		this.getHibernateTemplate().save(userMusic);
	}
	
	@Override
	public List<MdMusic> getUserMusicsByUserID(Integer userID){
		List<MdMusic> userMusics = (List<MdMusic>)this.getHibernateTemplate().find("from MdMusic user where user.mdUser.id = ?", userID);
		return userMusics;
	}

}
