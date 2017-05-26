package com.qi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		
		//��������
		ServerSocket serverSocket;
		Socket socket;
		BufferedReader bufferedReader;
		try {
			//��������
			serverSocket = new ServerSocket(8080);
			socket = serverSocket.accept();
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s = bufferedReader.readLine();
			String[] ss = s.split("/");
			String[] sss = ss[1].split("[?]");
			for(String s1:ss){
				System.out.println(s1);
			}
		//��Ӧ����
		FileInputStream fileInputStream = new FileInputStream(new File("src/com/qi/Test.html"));
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println("HTTP/1.1 200 OK");//����Ӧ����Ϣ��������Ӧ��
		printStream.println("Content-Type:Test/html");
		printStream.println();//����HTTPЭ�飬���н�����ͷ��Ϣ
		byte[] buf = new byte[fileInputStream.available()];
		//��ȡ�ļ����ݵ�buf1���鵱��
		fileInputStream.read(buf);
		//д�뵽���������
		printStream.write(buf);
		printStream.flush();
		printStream.close();
		socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
