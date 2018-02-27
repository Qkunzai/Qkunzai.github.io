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

		//开启一个端口
		ServerSocket serverSocket=null;
		Socket socket = null;
		Map<String,Socket> maps = new HashMap<String, Socket>();
		List<Socket> list = new ArrayList<Socket>();
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("创建成功");
			//可以连入多个客户端
			while(true){
			//监听每一个连入的客户端
			socket = serverSocket.accept();
			//将监听的客户端地址存放在list集合中
			list.add(socket);
			//读取客户端的名字
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//只读取一行
			String ss = bufferedReader.readLine();
			//将读取的名字与端口地址存放在map集合内
			maps.put(ss,socket);
			//开启收发的线程
			new Thread(new ServerThread(maps,socket,list)).start();	//收发同时
//			new Thread(new OutRunnable(list)).start();	//发
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
