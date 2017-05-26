package com.qi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestClient extends JFrame {
	
	
	public TestClient(Socket socket) {
		Socket socket2 = socket;
		//布局格式为空
		this.setLayout(null);
		//实例化一个显示聊天记录的区域
		JTextArea jLabel = new JTextArea();
		this.add(jLabel);
		//实例化一个聊天发送框
		JTextField chooser = new JTextField();
		this.add(chooser);
		//发送按钮
		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						String ss = chooser.getText();
						PrintWriter printWriter;
						try {
							if(!"".equals(ss)){
							//向服务器写入内容
							printWriter = new PrintWriter(socket2.getOutputStream());
							printWriter.write(ss+"\n");
							printWriter.flush();
							//刷新输入框
							chooser.setText("");
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		});
		this.add(button);
		//收消息线程
		new Thread(new ClientFanHui(jLabel,socket2)).start();
		//选择多人聊天还是单人
				JButton button10 = new JButton("1.多人聊天");
				button10.setBounds(200,120,120,40);
				button10.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jLabel.setBounds(0, 0, 800, 200);
						jLabel.setEditable(false);	//文本框不可操作
						chooser.setBounds(0, 200, 800, 30);
						button.setBounds(10, 240, 80, 40);
						button10.setVisible(false);
					}
				});
				this.add(button10);
		//窗口显示在桌面
		this.setBounds(200,200,800,400);
		//点击客户端的关闭有效
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		//创建一个连接客户端的Socket对象
		Socket socket=null;
		try {
			//连接到客户端
			socket = new Socket("192.168.199.161",8888);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("22\n");
			printWriter.flush();
			//
			new TestClient(socket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
