package com.qi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class InRunnable implements Runnable {
		Socket socket=null;
		Scanner sc = new Scanner(System.in);
		public InRunnable(Socket socket){
			this.socket=socket;
		}
	@Override
	public void run() {
		PrintWriter printWriter=null;
		String bb = "";
		//将需要发送的信息传给服务器
		try {
			while(true){
				printWriter = new PrintWriter(socket.getOutputStream());
				System.out.println("请输入发送的消息");
				bb = sc.next();
				printWriter.write(bb+"\n");
				//printWriter.close();
				//刷新流
				printWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
