package com.MusicDessert.ActionTest;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.MusicDessert.Action.LoginAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:I:/java workspace/MusicDessert_Software/WebRoot/WEB-INF/applicationContext.xml"})
public class LoginActionTest extends StrutsSpringJUnit4TestCase<LoginAction> {
	@Before
	public void initUserLoginInformation(){
		this.request.setParameter("userName", "wanglei");
		this.request.setParameter("password", "wang19921211");
		this.request.setParameter("identifyingCode", "167996");
	}
	
	@Test
	public void login(){
		try{
			String loginResult = this.executeAction("/loginAction");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
