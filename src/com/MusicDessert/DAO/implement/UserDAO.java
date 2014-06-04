package com.MusicDessert.DAO.implement;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


import com.MusicDessert.ORM.MdUser;

public class UserDAO extends HibernateDaoSupport implements
		com.MusicDessert.DAO.UserDAO {
	private final String Admin_Value = "Y";
	private final String Not_Admin_Value = "N";
	
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
	public boolean isAdmin(Integer userID){
		boolean isAdmin = false;
		MdUser user = this.findUserByUserId(userID);
		if(user !=null && user.getIsAdmin().equals(Admin_Value)){
			isAdmin = true;
		}
		return isAdmin;
	}
	
	@Override
	public MdUser findUserByUserId(Integer userID){
		MdUser user = null;
		try{
			List<MdUser> users = (List<MdUser>)this.getHibernateTemplate().find("from MdUser where id = ?", userID);
			if(users.size() != 0){
				final int firstUserIndex = 0;
				user = users.get(firstUserIndex);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public MdUser findUserByUserName(String userName){
		MdUser user = null;
		try{
			List<MdUser> users = (List<MdUser>)this.getHibernateTemplate().find("from MdUser where userName = ?", userName);
			if(users.size() != 0){
				final int firstUserIndex = 0;
				user = users.get(firstUserIndex);
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
			List<MdUser> users = (List<MdUser>)this.getHibernateTemplate().find("from MdUser where userName = ? and password = ?", userName, password);
			if(users.size() != 0){
				final int firstUserIndex = 0;
				user = users.get(firstUserIndex);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
}
