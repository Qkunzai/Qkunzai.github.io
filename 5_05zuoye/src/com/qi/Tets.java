package com.qi;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Tets implements Serializable {
	public static void main(String[] args){
		Socket socket = null;
		try{
			//���ӷ�������
			socket = new Socket("192.168.199.161",8999);
			//�����������һ������
			ObjectOutputStream objectOutputStream =  new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(new Student("����ң",20));
			objectOutputStream.flush();
			objectOutputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	
	
			
	
	
	}
	
}
