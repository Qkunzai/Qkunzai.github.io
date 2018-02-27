package com.qi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerTest {
	
	public static void main(String[] args){
		ServerSocket serverSocket =null;
		ServerThreads serverThreads = null;
		List<Socket> list = new ArrayList<Socket>();
		try {
			//开启端口
			serverSocket = new ServerSocket(8999);
			System.out.println("创建成功！");
				//监听端口
			while(true){
					Socket socket = serverSocket.accept();
					list.add(socket);		//监听每一个连接的客户端
					//读取用户的名字
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String ss = bufferedReader.readLine();	//读取用户名字
					System.out.println(ss);
					serverThreads = new ServerThreads(socket,ss,list);
					//接受客户端的消息并储存在数据库中的线程
					new Thread(serverThreads).start(); 		//启动线程
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
