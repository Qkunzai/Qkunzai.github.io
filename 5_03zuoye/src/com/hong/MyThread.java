package com.hong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

public class MyThread implements Runnable{
	
	Socket socket = new Socket();
	List<Socket> list = null;
	public MyThread(Socket socket,List list){
		this.socket=socket;
		this.list = list;
	}
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			//将客户端传来的数据读取
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String aaa = "";
		try {
			//读取客户端传来的数据
			aaa = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("客户端说"+aaa);
	}

}
