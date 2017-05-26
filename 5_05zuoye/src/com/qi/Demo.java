package com.qi;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo implements Serializable {
	
	public static void main(String[] args){
		
		ServerSocket serverSocket =null;
		Socket socket = null;
		try{
			//创建一个端口
			serverSocket = new ServerSocket(8999);
			//监听端口
			socket = serverSocket.accept();
			//读取一个类
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			Student ss = (Student) inputStream.readObject();
			System.out.println("客户端发来一个对象"+ss);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
