package com.clear2pay.cn.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

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
	
	/** 
     * 随机读取文件内容 
     *  
     * @param fileName 
     *            文件名 
     */  
    public static void readFileByRandomAccess(String fileName) {  
        RandomAccessFile randomFile = null;  
        try {  
            System.out.println("随机读取一段文件内容：");  
            // 打开一个随机访问文件流，按只读方式  
            randomFile = new RandomAccessFile(fileName, "r");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            // 读文件的起始位置  
            int beginIndex = (fileLength > 4) ? 4 : 0;  
            // 将读文件的开始位置移到beginIndex位置。  
            randomFile.seek(beginIndex);  
            byte[] bytes = new byte[10];  
            int byteread = 0;  
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。  
            // 将一次读取的字节数赋给byteread  
            while ((byteread = randomFile.read(bytes)) != -1) {  
                System.out.write(bytes, 0, byteread);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (randomFile != null) {  
                try {  
                    randomFile.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }
    /** 
     * 以行为单位读取文件，常用于读面向行的格式化文件 
     *  
     * @param fileName 
     *            文件名 
     */  
    public static void readFileByLines(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        int line = 1;  
        String tempString = null;  
        try {  
            System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8")); 
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            }  
            reader.close();  
        } catch (IOException e) {  
        	System.out.println("line " + line);
        	e.printStackTrace();
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }
    /** 
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件 
     *  
     * @param fileName 
     *            文件名 
     */  
    public static void readFileByChars(String fileName) {  
        File file = new File(fileName);  
        Reader reader = null;  
        try {  
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");  
            // 一次读一个字符  
            reader = new InputStreamReader(new FileInputStream(file),"UTF-8");  
            int tempchar;  
            while ((tempchar = reader.read()) != -1) {  
                // 对于windows下，rn这两个字符在一起时，表示一个换行。  
                // 但如果这两个字符分开显示时，会换两次行。  
                // 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。  
                if (((char) tempchar) != 'r') {  
                    System.out.print((char) tempchar);  
                }  
            }  
            reader.close();  
        } catch (Exception e) { 
            e.printStackTrace();  
        }
    }
}
