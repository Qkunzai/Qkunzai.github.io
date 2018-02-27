package com.hong;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class FanHui implements Runnable {

	Socket socket = new Socket();
	List<Socket> list = null;
	public FanHui(Socket socket,List list){
		this.socket=socket;
		this.list = list;
	}
	public void run() {
		//给客户端返回数据
				PrintWriter bufferedWriter = null;
				String aaa = "";
				try {
					//集合的遍历给所有连接服务器端的客户端返回信息
					for(Socket l:list){
					bufferedWriter = new PrintWriter(l.getOutputStream());
					aaa = bufferedWriter.toString();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				//写入给客户端返回的数据
				bufferedWriter.write(aaa+"\n");
				bufferedWriter.flush();
	}

}
