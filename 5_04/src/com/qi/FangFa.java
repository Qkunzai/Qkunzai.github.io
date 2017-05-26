package com.qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FangFa implements Runnable {
	private Socket socket=null;
	private Map<String, Socket> maps = new HashMap<String, Socket>();
	public FangFa(Socket socket,Map<String, Socket> maps){
		this.socket=socket;
		this.maps=maps;
	}
	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			//读取客户端返回的内容
			String ss = bufferedReader.readLine();
			//遍历HashMap查询谁发的信息
			Set<String> keys = maps.keySet();
			String abc="";
			for(String k:keys){
				Socket sba = maps.get(k);
				if(sba == socket){
					abc = k;
				}
			}
			System.out.println("客户端发送的消息");
			String sss = abc+"说:"+ss;
			System.out.println(sss);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
