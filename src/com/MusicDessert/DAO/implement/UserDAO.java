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
	
	@Override
	public MdUser findUserByUserName(String userName){
		MdUser user = null;
		try{
			List<MdUser> users = (List<MdUser>)this.getHibernateTemplate().find("from MdUser where name = ?", userName);
			if(users.size() != 0){
				final int firstUserIndex = 0;
				user = users.get(firstUserIndex);
			}else{
				user = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public MdUser findUserByUserPhoneNumber(String phoneNumber){
		MdUser user = null;
		try{
			List<MdUser> users = (List<MdUser>)this.getHibernateTemplate().find("from MdUser where phoneNumber = ?", phoneNumber);
			if(users.size() != 0){
				final int firstUserIndex = 0;
				user = users.get(firstUserIndex);
			}else{
				user = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public MdUser findUserByUserNameAndPhoneNumber(String userName, String password){
		MdUser user = null;
		try{
			List<MdUser> users = (List<MdUser>)this.getHibernateTemplate().find("from MdUser where name = ? and password = ?", userName, password);
			if(users.size() != 0){
				final int firstUserIndex = 0;
				user = users.get(firstUserIndex);
			}else{
				user = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
}
