package com.MusicDessert.Service.implement;

import java.io.File;

public class FolderMaker {
	
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
	
	public boolean makeDirectory(String directoryPath){
		boolean isMakeDirectorySuccess = false;
		if(!isDirectoryExists(directoryPath)){
			File file = new File(directoryPath);
			isMakeDirectorySuccess = file.mkdir();
		}
		return isMakeDirectorySuccess;
	}
}
