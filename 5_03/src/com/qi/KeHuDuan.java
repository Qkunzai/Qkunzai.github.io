package com.qi;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.InputMap;

public class KeHuDuan {

	public static void main(String[] args){
		
		try {
			Socket socket = new Socket("192.168.199.161",8888);
			//客户端可重复向服务器端发送数据
				//while(true){
					System.out.println("是否已经与客户端连接成功"+socket.isConnected());
					System.out.println("请输入需要传递的内容");
					Scanner sc = new Scanner(System.in);
					String a = sc.next();
					PrintWriter bufferedWriter = new PrintWriter(socket.getOutputStream());
					PrintWriter wr = new PrintWriter(socket.getOutputStream());
					wr.write("酒酿相思:\n");
					bufferedWriter.write(a+"\n");
					bufferedWriter.flush();
					System.out.println("内容传输给服务器端");
					//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					//接受由客户端返回的数据
//					BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//					String aa = bufferedReader2.readLine();
//					System.out.println("服务器端:"+aa);
					//bufferedReader2.close();
	//	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
