package com.qi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class KeHuDuan {
	public static void main(String[] na){
		try {
			Socket socket  = new Socket("192.168.199.161",9999);
			System.out.println("���ӳɹ�"+socket.isConnected());
			//��ͻ��˷�������
			OutputStream outputStream =socket.getOutputStream();
			outputStream.write("������ƻ����".getBytes());
			//�������˷�������ʹ�õķ�����ͻ�����������˷��ط�����ͬ
			InputStream input = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			StringBuffer abc = new  StringBuffer();
			while((len=input.read(bytes))!=-1){
				abc.append(new String(bytes,0,len));
			}
			System.out.println("���ص�����"+abc.toString());
			//�ر�������
			input.close();
			//��������ر�������
			//outputStream.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
