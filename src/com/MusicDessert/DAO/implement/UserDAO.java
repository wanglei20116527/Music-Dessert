package com.MusicDessert.DAO.implement;


import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


import com.MusicDessert.ORM.MdUser;

public class UserDAO extends HibernateDaoSupport implements
		com.MusicDessert.DAO.UserDAO {

	@Override
	public void saveUser(MdUser user) {
		try{
		this.getHibernateTemplate().save(user);
		this.getHibernateTemplate().flush();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
