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
		
		//请求内容
		ServerSocket serverSocket;
		Socket socket;
		BufferedReader bufferedReader;
		try {
			//请求内容
			serverSocket = new ServerSocket(8080);
			socket = serverSocket.accept();
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String s = bufferedReader.readLine();
			String[] ss = s.split("/");
			String[] sss = ss[1].split("[?]");
			for(String s1:ss){
				System.out.println(s1);
			}
		//响应内容
		FileInputStream fileInputStream = new FileInputStream(new File("src/com/qi/Test.html"));
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println("HTTP/1.1 200 OK");//返回应答消息，并结束应答
		printStream.println("Content-Type:Test/html");
		printStream.println();//根据HTTP协议，空行将结束头信息
		byte[] buf = new byte[fileInputStream.available()];
		//读取文件内容到buf1数组当中
		fileInputStream.read(buf);
		//写入到输出流当中
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
