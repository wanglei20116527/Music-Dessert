package com.MusicDessert.Service.implement;

import java.io.File;

public class FolderMaker {
	private String PARENT_FOLDER = "../../UserMusicFolder";
	
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
		String parentPath = this.getClass().getResource("").getPath().toString();
		for(int i = 0; i < 3; ++i){
			parentPath = parentPath.substring(0, parentPath.lastIndexOf("/"));
		}
		System.out.println(parentPath);
		boolean isMakeDirectorySuccess = false;
		String directoryPath = parentPath + "/" + directoryName;
		if(!isDirectoryExists(directoryPath)){
			File file = new File(directoryPath);
			isMakeDirectorySuccess = file.mkdir();
		}
		return isMakeDirectorySuccess;
	}
}
