package com.qi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTest {
	
	public static void main(String[] args){
		ServerSocket serverSocket =null;
		ServerThreads serverThreads = null;
		List<Socket> list = new ArrayList<Socket>();
		try {
			//�����˿�
			serverSocket = new ServerSocket(8999);
			System.out.println("�����ɹ���");
				//�����˿�
			while(true){
					Socket socket = serverSocket.accept();
					list.add(socket);		//����ÿһ�����ӵĿͻ���
					//��ȡ�û�������
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String ss = bufferedReader.readLine();	//��ȡ�û�����
					System.out.println(ss);
					serverThreads = new ServerThreads(socket,ss,list);
					//���ܿͻ��˵���Ϣ�����������ݿ��е��߳�
					new Thread(serverThreads).start(); 		//�����߳�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
