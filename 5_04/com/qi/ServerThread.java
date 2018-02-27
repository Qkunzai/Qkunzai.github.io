package com.qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServerThread implements Runnable {

	private Map<String,Socket> maps = new HashMap<String,Socket>();
	private Socket socket=null;
	private List<Socket> list= new ArrayList<Socket>();
	//初始化传来的信息
	public ServerThread(Map maps,Socket socket,List<Socket> list){
		this.maps=maps;
		this.socket=socket;
		this.list=list;
	}
	public void run(){
		//读取字节流
		BufferedReader bufferedReader=null;
		String ss=null;
				try {
					while(true){
						bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						//只读取一行
						ss = bufferedReader.readLine();
						//通过key值来进行遍历
						Set<String> sets = maps.keySet();
						String aa="";
						for(String s:sets){
							//通过key值来获取value值
							Socket so = maps.get(s);
							//当集合内存放的地址与传来的客户端地址相同时将key值赋给aa
//							if(so==socket){
								aa = s;
//							}
						}
						//在服务器端输出这句话
						String dd = aa+"说:"+ss;
						System.out.println(dd);
						//接收客户端返回的信息
						try {
								//返回给所有客户端
								PrintWriter printWriter=null;
									for(Socket sockets:list){
										printWriter = new PrintWriter(sockets.getOutputStream());
										printWriter.write(dd+"\n");
										printWriter.flush();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
