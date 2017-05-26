package com.qi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WuZiQiServer {

	public static void main(String[] args) {
		//����һ���˿�
		ServerSocket serverSocket;
		List<Socket> list = new ArrayList<Socket>();
		try {
			serverSocket = new ServerSocket(8000);
			//�����������ӵĿͻ���
			while(true){
				Socket socket = serverSocket.accept();
				list.add(socket);//�������ĵ�ַ�洢��list������
				//�����пͻ��˷���������߳�
				new Thread(new ServerThread(list)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
