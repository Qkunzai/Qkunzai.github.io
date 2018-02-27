package com.qi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WuZiQiServer {

	public static void main(String[] args) {
		//创建一个端口
		ServerSocket serverSocket;
		List<Socket> list = new ArrayList<Socket>();
		try {
			serverSocket = new ServerSocket(8000);
			//监听所有连接的客户端
			while(true){
				Socket socket = serverSocket.accept();
				list.add(socket);//将监听的地址存储在list集合内
				//给所有客户端返回坐标的线程
				new Thread(new ServerThread(list)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
