package com.qi;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.InputMap;

public class KeHuDuan {

	public static void main(String[] args){
		
		try {
			Socket socket = new Socket("192.168.199.161",8888);
			//�ͻ��˿��ظ���������˷�������
				//while(true){
					System.out.println("�Ƿ��Ѿ���ͻ������ӳɹ�"+socket.isConnected());
					System.out.println("��������Ҫ���ݵ�����");
					Scanner sc = new Scanner(System.in);
					String a = sc.next();
					PrintWriter bufferedWriter = new PrintWriter(socket.getOutputStream());
					PrintWriter wr = new PrintWriter(socket.getOutputStream());
					wr.write("������˼:\n");
					bufferedWriter.write(a+"\n");
					bufferedWriter.flush();
					System.out.println("���ݴ������������");
					//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					//�����ɿͻ��˷��ص�����
//					BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//					String aa = bufferedReader2.readLine();
//					System.out.println("��������:"+aa);
					//bufferedReader2.close();
	//	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
