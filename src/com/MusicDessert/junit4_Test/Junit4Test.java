package com.MusicDessert.junit4_Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Junit4Test {
	private String name1 = "";
	private String name2 = ""; 
	public Junit4Test(String name1, String name2){
		this.name1 = name1;
		this.name2 = name2;
	}
	
	@BeforeClass
	public static void beforeClass(){
		
	}
	
	@AfterClass
	public static void afterClass(){
	}
	
	@Before
	public void beforeTest(){
		
	}
	
	@Test(timeout=200)
	public void mainTest(){
		//for(int i = 0; i < 10000; ++i){
			System.out.println("name: " + this.name1 + " friend name: " + this.name2);
		//}
	}
	
	@Test
	@Ignore
	public void mainTest2(){
		
	}
	
	@After
	public void afterTest(){
		
	}
	
	@Parameters   
	public static Collection getData(){
		return Arrays.asList(new Object[][]{
				{"wanglei1","kang1"},
				{"wanglei2","kang2"},
				{"wanglei3","kang3"}
		});
	}

}
