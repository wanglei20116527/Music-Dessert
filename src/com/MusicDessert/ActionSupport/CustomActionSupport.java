package com.MusicDessert.ActionSupport;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public abstract class CustomActionSupport extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	protected final HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	protected final HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	protected final HttpSession getSession(){
		return this.getRequest().getSession();
	}
	
	protected final PrintWriter getPrintWriter(){
		PrintWriter printWriter = null;
		try{
			printWriter = this.getResponse().getWriter();
		}catch(IOException e){
			e.printStackTrace();
		}
		return printWriter;
	}
}
