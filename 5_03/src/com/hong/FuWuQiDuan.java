package com.hong;

import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class FuWuQiDuan {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		List<Socket> list = new ArrayList<Socket>();
		try {
			serverSocket = new ServerSocket(9999);
			System.out.println("�����ɹ�");
				while(true){
					socket = serverSocket.accept();
					list.add(socket);
					//�߳�ͬʱ���л�ʹ����������ͻ���ͬʱ�յ��ͻ��˷�������Ϣ
					new Thread(new MyThread(socket,list)).start();
					new Thread(new FanHui(socket,list)).start();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
