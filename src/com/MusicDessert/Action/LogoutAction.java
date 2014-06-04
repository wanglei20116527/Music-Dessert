package com.MusicDessert.Action;

import com.MusicDessert.ActionSupport.CustomActionSupport;

public final class LogoutAction extends CustomActionSupport {
	private static final long serialVersionUID = 1L;

	public String logout(){
		try{
			this.getSession().invalidate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
}
