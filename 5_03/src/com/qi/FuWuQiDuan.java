package com.qi;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
public class FuWuQiDuan {

	public static void main(String[] args){
		ServerSocket serverSocket = null;
		Socket socket = null;
		Map<String,Socket> maps = new HashMap<String,Socket>();
		try {
			//开启一个可供连接的端口
				serverSocket = new ServerSocket(8999);
				System.out.println("创建成功");
				//监听连接服务器的所有客户端的
				//加上循环因为有阻塞所以不会死循环，会一直接入客户端的连接
				while(true){
					socket = serverSocket.accept();
					//输出客户端传输来的内容
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String aaa = bufferedReader.readLine();
					System.out.println("客户端说"+aaa);
					//给客户端返回数据
					PrintWriter bufferedWriter = new PrintWriter(socket.getOutputStream());
					bufferedWriter.write(aaa+"\n");
					bufferedWriter.flush();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
