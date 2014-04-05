package com.MusicDessert.Service.implement;

import java.io.File;

public class FolderMaker {
	private String PARENT_FOLDER = "UserMusicFolder";
	
	private boolean isDirectoryExists(String directoryPath){
		boolean isDirectoryExists = true;
		File file = new File(directoryPath);
		if(file.exists() && file.isDirectory()){
			isDirectoryExists = true;
		}else{
			isDirectoryExists = false;
		}
		return isDirectoryExists;	
	}
	
	public boolean makeDirectory(String directoryName){
		boolean isMakeDirectorySuccess = false;
		String directoryPath = this.PARENT_FOLDER + "/" + directoryName;
		if(!isDirectoryExists(directoryPath)){
			File file = new File(directoryPath);
			isMakeDirectorySuccess = file.mkdir();
		}
		return isMakeDirectorySuccess;
	}
}
