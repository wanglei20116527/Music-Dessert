package com.MusicDessert.DAO.implement;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.MusicDessert.ORM.MdRecommandedmusic;

public class MdRecommandedmusicDAO extends HibernateDaoSupport implements
		com.MusicDessert.DAO.MdRecommandedmusicDAO {

	@Override
	public List<MdRecommandedmusic> findAllRecommandedmusics() {
		List<MdRecommandedmusic> recommandedmusics = (List<MdRecommandedmusic>)this.getHibernateTemplate().find("from MdRecommandedmusic");
		return recommandedmusics;
	}

}
