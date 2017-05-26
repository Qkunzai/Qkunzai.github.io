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
		Map<String, String> fang = new HashMap<String, String>();//��ŷ��䣬key��ʾ��Ϸ����ţ�value��ʾ��������
		Map<Socket, String> map = new HashMap<Socket,String>();//����û���key��ʾ�û���value��ʾ�����
		try {
			serverSocket = new ServerSocket(8000);
			while(true){
				//�����˿�
				socket = serverSocket.accept();
				String fangID = "";
				int a = 2;//û�д�������
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				fangID = bufferedReader.readLine();
				Set<String> setFang = fang.keySet();
				for(String fID:setFang){
					if(fangID.equals(fID)){
						if(fang.get(fID).equals("2")){
							a = 0;//���ڴ˷���,����������
							break;
						}
						a = 1;//���ڴ˷���,�ҷ�������һ��
						break;
					}
				}
				//��a���ظ��ͻ���
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.write(a);
				printWriter.flush();
				
				if(a==2){
					fang.put(fangID, "1");
				}else if(a==1){
					fang.put(fangID, "2");
				}else if(a==0){
					continue;//�÷��������ˣ����ڼ���ִ�����²���
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
