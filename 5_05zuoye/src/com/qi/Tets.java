package com.qi;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Tets implements Serializable {
	public static void main(String[] args){
		Socket socket = null;
		try{
			//连接服务器端
			socket = new Socket("192.168.199.161",8999);
			//向服务器发送一个对象
			ObjectOutputStream objectOutputStream =  new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(new Student("何逍遥",20));
			objectOutputStream.flush();
			objectOutputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	
	
			
	
	
	}
	
}
