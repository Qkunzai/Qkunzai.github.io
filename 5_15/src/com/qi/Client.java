package com.qi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Client extends JFrame {
	Connection connection = DanLi.fanHui();
	public Client(Socket socket){
		
		//布局为空
		this.setLayout(null);
		
		//发送数据的单行文本框
		JTextField field = new JTextField();
		this.add(field);
		
		//接受数据的文本框
		JTextArea area = new JTextArea();
		area.setEditable(false);
		this.add(area);
		
		new Thread(new ClientRunnable(socket,area)).start();	//接受服务器返回线程
		
		//发送按钮
		JButton button = new JButton("发送");
		//发送按钮事件
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintWriter printWriter = null;
				try {
					if(!"".equals(field.getText())){
						printWriter = new PrintWriter(socket.getOutputStream());
						printWriter.write(field.getText()+"\n");//由客户端写入到服务器端
						printWriter.flush();//刷新缓冲区
						field.setText("");	//清空文本框内容
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		this.add(button);
		
		//显示历史消息按钮
		JButton button2 = new JButton("历史消息");
		
		//历史消息按钮事件
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from qqliaotian");
					while(resultSet.next()){
						String name = resultSet.getString("name");
						String record = resultSet.getString("record");
						area.setText(area.getText()+name+":"+record+"\n");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		this.add(button2);
		
		//清空历史记录
		JButton button3 = new JButton("清空历史记录");
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("select * from qqliaotian");
					java.sql.PreparedStatement statement3 =connection.prepareStatement("delete from qqliaotian where name = ?");
					while(resultSet.next()){
						String name = resultSet.getString("name");
						statement3.setString(1,name);
						statement3.executeUpdate();
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		this.add(button3);
		
		//多人聊天选择按钮
		JButton button4 = new JButton("多人聊天");
		button4.setBounds(80, 130, 120, 200);
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				button3.setBounds(280,430,120,40);	//清空历史记录按钮界面
				button2.setBounds(140,430,120,40);	//历史记录界面
				button.setBounds(0,430,120,40);		//发送按钮界面
				area.setBounds(0,0,600,400);		//返回消息显示界面
				field.setBounds(0, 400, 600, 30);	//发送文本框界面
				button4.setVisible(false);			//选择后该按钮消失
			}
		});
		this.add(button4);
		//单人聊天选择按钮
		JButton button5 = new JButton("单人聊天");
		button5.setBounds(390,130,120,200);
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				button3.setBounds(280,430,120,40);	//清空历史记录按钮界面
				button2.setBounds(140,430,120,40);	//历史记录界面
				button.setBounds(0,430,120,40);		//发送按钮界面
				area.setBounds(0,0,600,400);		//返回消息显示界面
				field.setBounds(0, 400, 600, 30);	//发送文本框界面
				button5.setVisible(false);			//选择后该按钮消失
			}
		});
		this.add(button5);
		//显示窗口
		this.setVisible(true);	//窗口体显示在桌面
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//关闭窗口
		this.setBounds(400,400,600,600);	//画出窗口
	}
	public static void main(String[] args){
		//连接服务器端
		Socket socket = null;
		PrintWriter printWriter=null;
		try {
			socket = new Socket("192.168.199.161",8999);
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("李四"+"\n"); 
			printWriter.flush();
			new Client(socket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
