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
		//���ͻ��˷�������
				PrintWriter bufferedWriter = null;
				String aaa = "";
				try {
					//���ϵı������������ӷ������˵Ŀͻ��˷�����Ϣ
					for(Socket l:list){
					bufferedWriter = new PrintWriter(l.getOutputStream());
					aaa = bufferedWriter.toString();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				//д����ͻ��˷��ص�����
				bufferedWriter.write(aaa+"\n");
				bufferedWriter.flush();
	}

}
