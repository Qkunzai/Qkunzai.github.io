package com.qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FuWuQi {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;
		List<Socket> list = new ArrayList<Socket>();
		Map<String, String> fang = new HashMap<String, String>();//存放房间，key表示游戏房间号，value表示房间人数
		Map<Socket, String> map = new HashMap<Socket,String>();//存放用户，key表示用户，value表示房间号
		try {
			serverSocket = new ServerSocket(8000);
			while(true){
				//监听端口
				socket = serverSocket.accept();
				String fangID = "";
				int a = 2;//没有创建房间
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				fangID = bufferedReader.readLine();
				Set<String> setFang = fang.keySet();
				for(String fID:setFang){
					if(fangID.equals(fID)){
						if(fang.get(fID).equals("2")){
							a = 0;//存在此房间,房间已满人
							break;
						}
						a = 1;//存在此房间,且房间已有一人
						break;
					}
				}
				//将a返回给客户端
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(a);
				printWriter.flush();
				
				if(a==2){
					fang.put(fangID, "1");
				}else if(a==1){
					fang.put(fangID, "2");
				}else if(a==0){
					continue;//该房间已满人，不在继续执行以下操作
				}
				map.put(socket, fangID);
				
				
				list.add(socket);
				new Thread(new FuWuRunnable(socket,fangID,map)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
