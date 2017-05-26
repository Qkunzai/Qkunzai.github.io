package com.qi;

import java.io.*;
import java.net.*;

import javax.xml.ws.soap.Addressing;

public class FuWuQi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		
		try {
				serverSocket = new ServerSocket(9999);
				System.out.println("创建成功");
				//监听端口对象
					Socket socket = serverSocket.accept();
					String aaa = socket.getInetAddress().getHostAddress();
					System.out.println("客户端地址："+aaa);
					//字符流发送
					InputStream input = socket.getInputStream();
					byte[] bytes = new byte[1024];
					int len = 0;
					StringBuffer abc = new  StringBuffer();
					while((len=input.read(bytes))!=-1){
						abc.append(new String(bytes,0,len));
					}
					//关闭流数据
					input.close();
					//向客户端传输数据
					OutputStream output = socket.getOutputStream();
					output.write("我是客户端".getBytes());
					output.close();
//					System.out.println("服务器说:你来干嘛");
//					System.out.println("客户端说:"+abc.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
