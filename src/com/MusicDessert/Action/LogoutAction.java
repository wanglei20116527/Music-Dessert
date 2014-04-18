package com.MusicDessert.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}

	private HttpSession getSession(){
		return this.getRequest().getSession();
	}
	
	public String logout() throws Exception{
		this.getSession().invalidate();
		return this.SUCCESS;
	}
}
