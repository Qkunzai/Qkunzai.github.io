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
			//����һ���˿�
			serverSocket = new ServerSocket(8999);
			//�����˿�
			socket = serverSocket.accept();
			//��ȡһ����
			ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
			Student ss = (Student) inputStream.readObject();
			System.out.println("�ͻ��˷���һ������"+ss);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
