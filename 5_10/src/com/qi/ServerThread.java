package com.qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread implements Runnable{
	
	List<Socket> list = new ArrayList<Socket>();
	private int x;//���ͻ��˷��ص�X������
	private int y;//���ͻ��˷��ص�Y������
	private boolean isHei;//�ͻ��˴�������ɫ�任
	public ServerThread(List<Socket> list){
		this.list = list;
	}
	@Override
	public void run() {
		BufferedReader bufferedReader;
		PrintWriter printWriter;
		for(Socket ls:list){
			try {
				while(true){
					bufferedReader = new BufferedReader(new InputStreamReader(ls.getInputStream()));
					printWriter = new PrintWriter(ls.getOutputStream());
					x=bufferedReader.read();
					y=bufferedReader.read();
					isHei=bufferedReader.ready();
					if(isHei==true){
						isHei=false;
						printWriter.print(isHei);
					}
					printWriter.write(x);
					printWriter.write(y);
					printWriter.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	

}
