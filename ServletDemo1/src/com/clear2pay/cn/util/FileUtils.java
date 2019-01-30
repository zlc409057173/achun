package com.clear2pay.cn.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class FileUtils {
	
	public void show(File file){
		if(!file.exists()){
			return;
		}
		if(file.isDirectory()){
			show(file);
		}else{
			System.out.println(file.getName());
		}
	}
	
	public void fileReader(File file) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(file));
		
	}
}
