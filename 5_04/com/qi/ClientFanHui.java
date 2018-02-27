package com.qi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ClientFanHui implements Runnable {
	
	Socket socket;
	JTextArea jLabel;
	

	public ClientFanHui(JTextArea jLabel,Socket socket){
		this.jLabel=jLabel;
		this.socket=socket;
	}
	public void run() {
		//从服务器接受并显示
		BufferedReader bufferedReader;
		while(true){
			try {
					bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String ss1 = bufferedReader.readLine();
					jLabel.setText(jLabel.getText()+"\n"+ss1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
