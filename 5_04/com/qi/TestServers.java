package com.qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestServers {

	public static void main(String[] args) {

		//����һ���˿�
		ServerSocket serverSocket=null;
		Socket socket = null;
		Map<String,Socket> maps = new HashMap<String, Socket>();
		List<Socket> list = new ArrayList<Socket>();
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("�����ɹ�");
			//�����������ͻ���
			while(true){
			//����ÿһ������Ŀͻ���
			socket = serverSocket.accept();
			//�������Ŀͻ��˵�ַ�����list������
			list.add(socket);
			//��ȡ�ͻ��˵�����
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//ֻ��ȡһ��
			String ss = bufferedReader.readLine();
			//����ȡ��������˿ڵ�ַ�����map������
			maps.put(ss,socket);
			//�����շ����߳�
			new Thread(new ServerThread(maps,socket,list)).start();	//�շ�ͬʱ
//			new Thread(new OutRunnable(list)).start();	//��
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
