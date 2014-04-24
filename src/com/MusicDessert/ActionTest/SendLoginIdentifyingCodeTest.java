/*package com.MusicDessert.ActionTest;

import org.apache.struts2.StrutsSpringTestCase;

import com.MusicDessert.Action.LoginAction;
import com.opensymphony.xwork2.ActionProxy;

public class SendLoginIdentifyingCodeTest extends StrutsSpringTestCase {
	 private ActionProxy proxy;
	 LoginAction loginAction;
	 
	 protected String[] getContextLocations() {  
		 return new String[]{"file:I:/java workspace/MusicDessert_Software/WebRoot/WEB-INF/applicationContext.xml"};  
	 }  
	 
	 private void init(){  
	     proxy = getActionProxy("/sendLoginIdentifyingCodeAction");  
	     loginAction = (LoginAction)proxy.getAction();  
	 }
	 
	 public void testSendLoginIdentifyingCode(){
		 try{
			 this.request.setParameter("userName", "wanglei");
			 init();  
			 proxy.execute();
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }  


}*/


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
public class SendLoginIdentifyingCodeTest extends StrutsSpringJUnit4TestCase<LoginAction> {
	@Before
	public void initRequestInformation(){
		this.request.setParameter("userName", "wanglei");
	}
	
	@Test
	public void sendLoginIdentifyingCodeTest(){
		try{
			String result = this.executeAction("/sendLoginIdentifyingCodeAction");
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

