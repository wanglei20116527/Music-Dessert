package com.MusicDessert.DAO.implement;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.MusicDessert.ORM.MdMusic;

public class MusicDAO extends HibernateDaoSupport implements
		com.MusicDessert.DAO.MusicDAO {

	@Override
	public MdMusic saveMusic(MdMusic music) {
		this.getHibernateTemplate().save(music);
		this.getHibernateTemplate().flush();
		return music;
	}
	
	@Override
	public List<MdMusic> getMusicsByMusicIDs(List<Integer> ids){
		List<MdMusic> musics = null;
		boolean isFirstMusic = true;
		if(ids.size() != 0){
			String queryString = "from MdMusic music where ";
			Iterator<Integer> iterator = ids.iterator();
			while(iterator.hasNext()){
				Integer musicID = iterator.next();
				if(isFirstMusic){
					queryString += " music.id = " + musicID + " ";
					isFirstMusic = false;
				}else{
					queryString += " or music.id = " + musicID + " ";
				}
			}
			System.out.println("****************************************");
			System.out.println("query: " + queryString);
			System.out.println("****************************************");
			musics = (List<MdMusic>)this.getHibernateTemplate().find(queryString, null);
		}
		return musics;
	}
	
	@Override
	public List<MdMusic> getMusicsByCategoryID(Integer categoryID){
		List<MdMusic> musics = (List<MdMusic>)this.getHibernateTemplate().find("from MdMusic music where music.mdMusicCategory.id = ?", categoryID);
		return musics;
	}
}
