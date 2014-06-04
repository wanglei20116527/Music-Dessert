package com.MusicDessert.DAO.implement;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.MusicDessert.ORM.MdUserMusic;

public class UserMusicDAO extends HibernateDaoSupport implements
		com.MusicDessert.DAO.UserMusicDAO {

	@Override
	public void saveUserMusic(MdUserMusic userMusic) {
		this.getHibernateTemplate().save(userMusic);
		this.getHibernateTemplate().flush();
	}
	
	@Override
	public List<MdUserMusic> getUserMusicsByUserID(Integer userID){
		List<MdUserMusic> userMusics = (List<MdUserMusic>)this.getHibernateTemplate().find("from MdUserMusic user where user.mdUser.id = ?", userID);
		return userMusics;
	}

}
