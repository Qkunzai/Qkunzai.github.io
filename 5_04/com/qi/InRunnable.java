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
		//����Ҫ���͵���Ϣ����������
		try {
			while(true){
				printWriter = new PrintWriter(socket.getOutputStream());
				System.out.println("�����뷢�͵���Ϣ");
				bb = sc.next();
				printWriter.write(bb+"\n");
				//printWriter.close();
				//ˢ����
				printWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
