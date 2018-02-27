package com.qi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class KeHuDuan {
	public static void main(String[] na){
		try {
			Socket socket  = new Socket("192.168.199.161",9999);
			System.out.println("连接成功"+socket.isConnected());
			//向客户端发送数据
			OutputStream outputStream =socket.getOutputStream();
			outputStream.write("我是送苹果的".getBytes());
			//服务器端返回数据使用的方法与客户端向服务器端返回方法相同
			InputStream input = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			StringBuffer abc = new  StringBuffer();
			while((len=input.read(bytes))!=-1){
				abc.append(new String(bytes,0,len));
			}
			System.out.println("返回的数据"+abc.toString());
			//关闭流数据
			input.close();
			//输入后必须关闭流数据
			//outputStream.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
