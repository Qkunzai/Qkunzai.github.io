package com.qi;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
public class FuWuQiDuan {

	public static void main(String[] args){
		ServerSocket serverSocket = null;
		Socket socket = null;
		Map<String,Socket> maps = new HashMap<String,Socket>();
		try {
			//����һ���ɹ����ӵĶ˿�
				serverSocket = new ServerSocket(8999);
				System.out.println("�����ɹ�");
				//�������ӷ����������пͻ��˵�
				//����ѭ����Ϊ���������Բ�����ѭ������һֱ����ͻ��˵�����
				while(true){
					socket = serverSocket.accept();
					//����ͻ��˴�����������
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String aaa = bufferedReader.readLine();
					System.out.println("�ͻ���˵"+aaa);
					//���ͻ��˷�������
					PrintWriter bufferedWriter = new PrintWriter(socket.getOutputStream());
					bufferedWriter.write(aaa+"\n");
					bufferedWriter.flush();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
