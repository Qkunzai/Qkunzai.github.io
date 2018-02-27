package com.qi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class ClientRunnable implements Runnable {

	Socket socket = null;
	JTextArea area = null;
	public ClientRunnable(Socket socket, JTextArea area) {
		this.socket = socket;
		this.area = area;
	}
	@Override
	public void run() {
		BufferedReader bufferedReader;
		while(true)
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String ss = bufferedReader.readLine();
			System.out.println(ss);
			area.setText(area.getText()+"\n"+ss);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
