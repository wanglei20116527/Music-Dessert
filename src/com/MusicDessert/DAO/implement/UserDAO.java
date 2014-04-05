package com.MusicDessert.DAO.implement;


import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.MusicDessert.ORM.MdUser;

public class UserDAO extends HibernateDaoSupport implements
		com.MusicDessert.DAO.UserDAO {

	@Override
	public void saveUser(MdUser user) {
		System.out.println("DAO user start");
		try{
		//this.getHibernateTemplate().setCheckWriteOperations(false);
		this.getHibernateTemplate().save(user);
		this.getHibernateTemplate().flush();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("wanglei is cool");
		}
		System.out.println("DAO user end");
	}

}
