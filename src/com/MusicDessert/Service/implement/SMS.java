package com.MusicDessert.Service.implement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMS implements com.MusicDessert.Service.SMS {

	private final String  MESSAGESEND_NET_INTEFACE = "http://2.smsfx.sinaapp.com/send.php?tel=15905515978&pwd=wang19921211&";
	
	@Override
	public void sendMessageToPhone(String targetPhoneNumber, String context){
		URL url = null;
		URLConnection conn = null;
		try{
			String urlString = MESSAGESEND_NET_INTEFACE;
			urlString += "aim=" + targetPhoneNumber + "&text=";
			urlString += URLEncoder.encode(context);
			System.out.println(urlString);
			url = new URL(urlString);
			conn = url.openConnection();
			conn.connect();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String result = "";
			String line = in.readLine();
			while(line != null){
				result += line;
				line = in.readLine();
			}
			System.out.println(result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
