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
			//��ȡ�ͻ��˷��ص�����
			String ss = bufferedReader.readLine();
			//����HashMap��ѯ˭������Ϣ
			Set<String> keys = maps.keySet();
			String abc="";
			for(String k:keys){
				Socket sba = maps.get(k);
				if(sba == socket){
					abc = k;
				}
			}
			System.out.println("�ͻ��˷��͵���Ϣ");
			String sss = abc+"˵:"+ss;
			System.out.println(sss);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
