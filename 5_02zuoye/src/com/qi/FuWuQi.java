package com.qi;

import java.io.*;
import java.net.*;

import javax.xml.ws.soap.Addressing;

public class FuWuQi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		
		try {
				serverSocket = new ServerSocket(9999);
				System.out.println("�����ɹ�");
				//�����˿ڶ���
					Socket socket = serverSocket.accept();
					String aaa = socket.getInetAddress().getHostAddress();
					System.out.println("�ͻ��˵�ַ��"+aaa);
					//�ַ�������
					InputStream input = socket.getInputStream();
					byte[] bytes = new byte[1024];
					int len = 0;
					StringBuffer abc = new  StringBuffer();
					while((len=input.read(bytes))!=-1){
						abc.append(new String(bytes,0,len));
					}
					//�ر�������
					input.close();
					//��ͻ��˴�������
					OutputStream output = socket.getOutputStream();
					output.write("���ǿͻ���".getBytes());
					output.close();
//					System.out.println("������˵:��������");
//					System.out.println("�ͻ���˵:"+abc.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
