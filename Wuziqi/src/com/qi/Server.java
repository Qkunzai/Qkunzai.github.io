package com.qi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	public static void main(String[] args){
		ServerSocket serverSocket;
		List<Socket> list = new ArrayList<Socket>();
		try {
			serverSocket = new ServerSocket(8999);
			while(true){
				Socket socket = serverSocket.accept();//监听所有的链接对象
				list.add(socket);//将监听的地址存储在list集合内
			}
			//接受并返回棋子的线程
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
