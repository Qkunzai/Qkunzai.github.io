package com.qi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static void main(String[] args){
		ServerSocket serverSocket;
		List<Socket> list = new ArrayList<Socket>();
		try {
			serverSocket = new ServerSocket(8999);
			while(true){
				Socket socket = serverSocket.accept();//�������е����Ӷ���
				list.add(socket);//�������ĵ�ַ�洢��list������
			}
			//���ܲ��������ӵ��߳�
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
