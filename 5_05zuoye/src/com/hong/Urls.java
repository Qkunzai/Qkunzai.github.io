package com.hong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Urls {

	public static void main(String[] args) {

		
		String url="";
		try {
			URL url1 = new URL(url);
			//��URL
			URLConnection connection = url1.openConnection();
			//������������
			connection.connect();
			//��ȡԴ�ļ�
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			//StringBuffer buffer = new StringBuffer();
//			String ss = "";
//			ss=bufferedReader.readLine();
//			System.out.println(ss);
			//图片下载
			File file = new File("src/1.mp3");
			InputStream inputStream = connection.getInputStream();
			byte[] bytes = new byte[1024];
			int len=0;
			FileOutputStream outputStream = new FileOutputStream(file);
			while((len=inputStream.read(bytes))!=-1){
				outputStream.write(bytes,0,len);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
