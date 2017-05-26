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
		//���ָ�ʽΪ��
		this.setLayout(null);
		//ʵ����һ����ʾ�����¼������
		JTextArea jLabel = new JTextArea();
		this.add(jLabel);
		//ʵ����һ�����췢�Ϳ�
		JTextField chooser = new JTextField();
		this.add(chooser);
		//���Ͱ�ť
		JButton button = new JButton("����");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						String ss = chooser.getText();
						PrintWriter printWriter;
						try {
							if(!"".equals(ss)){
							//�������д������
							printWriter = new PrintWriter(socket2.getOutputStream());
							printWriter.write(ss+"\n");
							printWriter.flush();
							//ˢ�������
							chooser.setText("");
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		});
		this.add(button);
		//����Ϣ�߳�
		new Thread(new ClientFanHui(jLabel,socket2)).start();
		//ѡ��������컹�ǵ���
				JButton button10 = new JButton("1.��������");
				button10.setBounds(200,120,120,40);
				button10.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						jLabel.setBounds(0, 0, 800, 200);
						jLabel.setEditable(false);	//�ı��򲻿ɲ���
						chooser.setBounds(0, 200, 800, 30);
						button.setBounds(10, 240, 80, 40);
						button10.setVisible(false);
					}
				});
				this.add(button10);
		//������ʾ������
		this.setBounds(200,200,800,400);
		//����ͻ��˵Ĺر���Ч
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		//����һ�����ӿͻ��˵�Socket����
		Socket socket=null;
		try {
			//���ӵ��ͻ���
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
