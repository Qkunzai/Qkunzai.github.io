package com.qi;

import java.io.*;
import java.net.*;
import java.util.*;

public class FuWuRunnable implements Runnable{
	private Socket socket;
	private String fangID;
	private Map<Socket, String> map;
//	private Pieces pieces;
	public FuWuRunnable(Socket socket,String fangID,Map map){
		this.socket = socket;
		this.fangID = fangID;
		this.map = map;
	}
	public void run() {
		while(true){
			ObjectInputStream inputStream = null;
			try {
				//接收客户端发来的棋子对象
				inputStream = new ObjectInputStream(socket.getInputStream());
				Object o = inputStream.readObject();
				Set<Socket> setMap = map.keySet();
				for(Socket sm:setMap){
					if(map.get(sm).equals(fangID)){
						ObjectOutputStream objectOutputStream = new ObjectOutputStream(sm.getOutputStream());
						objectOutputStream.writeObject(o);
						objectOutputStream.flush();
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
//				break;
			}
		}
	}
}
