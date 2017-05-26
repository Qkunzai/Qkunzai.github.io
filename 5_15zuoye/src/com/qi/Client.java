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
		
		//����Ϊ��
		this.setLayout(null);
		
		//�������ݵĵ����ı���
		JTextField field = new JTextField();
		this.add(field);
		
		//�������ݵ��ı���
		JTextArea area = new JTextArea();
		area.setEditable(false);
		this.add(area);
		
		new Thread(new ClientRunnable(socket,area)).start();	//���ܷ����������߳�
		
		//���Ͱ�ť
		JButton button = new JButton("����");
		//���Ͱ�ť�¼�
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintWriter printWriter = null;
				try {
					if(!"".equals(field.getText())){
						printWriter = new PrintWriter(socket.getOutputStream());
						printWriter.write(field.getText()+"\n");//�ɿͻ���д�뵽��������
						printWriter.flush();//ˢ�»�����
						field.setText("");	//����ı�������
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		this.add(button);
		
		//��ʾ��ʷ��Ϣ��ť
		JButton button2 = new JButton("��ʷ��Ϣ");
		
		//��ʷ��Ϣ��ť�¼�
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
		
		//�����ʷ��¼
		JButton button3 = new JButton("�����ʷ��¼");
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
		
		//��������ѡ��ť
		JButton button4 = new JButton("��������");
		button4.setBounds(80, 130, 120, 200);
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				button3.setBounds(280,430,120,40);	//�����ʷ��¼��ť����
				button2.setBounds(140,430,120,40);	//��ʷ��¼����
				button.setBounds(0,430,120,40);		//���Ͱ�ť����
				area.setBounds(0,0,600,400);		//������Ϣ��ʾ����
				field.setBounds(0, 400, 600, 30);	//�����ı������
				button4.setVisible(false);			//ѡ���ð�ť��ʧ
			}
		});
		this.add(button4);
		//��������ѡ��ť
		JButton button5 = new JButton("��������");
		button5.setBounds(390,130,120,200);
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					
				button3.setBounds(280,430,120,40);	//�����ʷ��¼��ť����
				button2.setBounds(140,430,120,40);	//��ʷ��¼����
				button.setBounds(0,430,120,40);		//���Ͱ�ť����
				area.setBounds(0,0,600,400);		//������Ϣ��ʾ����
				field.setBounds(0, 400, 600, 30);	//�����ı������
				button5.setVisible(false);			//ѡ���ð�ť��ʧ
			}
		});
		this.add(button5);
		//��ʾ����
		this.setVisible(true);	//��������ʾ������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//�رմ���
		this.setBounds(400,400,600,600);	//��������
	}
	public static void main(String[] args){
		//���ӷ�������
		Socket socket = null;
		PrintWriter printWriter=null;
		try {
			socket = new Socket("192.168.199.161",8999);
			printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.write("����"+"\n"); 
			printWriter.flush();
			new Client(socket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
