package com.MusicDessert.ActionTest;

import junit.framework.Assert;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.MusicDessert.Action.LoginAction;
import com.MusicDessert.KEY.Key;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:I:/java workspace/MusicDessert_Software/WebRoot/WEB-INF/applicationContext.xml"})
public class SendRegisterIdentifyingCodeTest extends StrutsSpringJUnit4TestCase<LoginAction>{
	@Before
	public void initRequestInformation(){
		//this.response.reset();
		String userName = "wanglei";
		this.request.setParameter(Key.USERNAME_KEY, userName);
	}
	
	@Test
	@Ignore
	public void sendLoginIdentifyingCodeTest2(){
		try{
			final String expected = "Success";
			String result = this.executeAction("/sendLoginIdentifyingCodeAction");
			Assert.assertEquals(expected, result.trim());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test

	public void sendLoginIdentifyingCodeTest(){
		try{
			final String expected = "Success";
			String result = this.executeAction("/sendLoginIdentifyingCodeAction").trim();
			System.out.println("result: " + result);
			Thread.sleep(11000);
			result = this.executeAction("/sendLoginIdentifyingCodeAction").trim();
			result = result.replaceFirst("Success", "");
			Assert.assertEquals(expected, result.trim());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
