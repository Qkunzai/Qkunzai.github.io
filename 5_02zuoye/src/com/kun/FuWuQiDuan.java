package com.kun;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FuWuQiDuan {

	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//¼àÌý
		try {
			Socket socket = serverSocket.accept();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
