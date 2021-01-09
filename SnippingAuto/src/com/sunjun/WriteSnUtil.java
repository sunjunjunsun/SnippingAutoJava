package com.sunjun;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteSnUtil {
	public static void writeSn(String text) {
		String formatStr = new SimpleDateFormat("MMdd").format(new Date());
		String textNameFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		String parentPath="C:\\sn\\Java";
		if(!new File(parentPath).exists()) {
			new File(parentPath).mkdirs();
		}
		File file=new File(parentPath+"\\" + textNameFormat + ".txt");
    	 try {
			FileOutputStream fos=new FileOutputStream(file,true);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
		    bw.write(text.toUpperCase() +"\r\n");
			bw.close();
			osw.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void WriteSnToServer(String basePath, String snNum) {
		String formatStr = new SimpleDateFormat("MMdd").format(new Date());
		File file=new File(basePath+"\\Content.txt");
    	 try {
			FileOutputStream fos=new FileOutputStream(file,true);
			OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
		    bw.write(snNum.toUpperCase() +"\r\n");
			bw.close();
			osw.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
