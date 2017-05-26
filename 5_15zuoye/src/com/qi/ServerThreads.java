package com.qi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServerThreads implements Runnable {

	Socket socket;
	String aa;
	String name = "";
	String record = "";
	List<Socket> list = new ArrayList<Socket>();
	public ServerThreads(Socket socket,String aa,List<Socket> list){
		this.socket = socket;
		this.aa = aa;
		this.list=list;
	}
	
	@Override
	public void run() {
		System.out.println(aa);
		Connection connection = DanLi.fanHui();
		BufferedReader bufferedReader = null;
		PreparedStatement preparedStatement = null;
		PrintWriter printWriter = null;
		try {
			while(true){
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String ss = bufferedReader.readLine();	//��ȡһ������
			//�������ݿ�֮��ʹ�����ݿ����
			preparedStatement = connection.prepareStatement("insert into qqliaotian (name,record)" + "values(?,?)");
			//�����û�����
			preparedStatement.setString(1, aa);
			//�����û�����������¼
			preparedStatement.setString(2, ss);
			preparedStatement.executeUpdate();
			//����Statement������ִ��sql���
			Statement statement = connection.createStatement();
			//ResultSet�࣬������Ż�ȡ�Ľ����
			ResultSet resultSet = statement.executeQuery("select * from qqliaotian");
			//��ѯ���ڵ���������
			while(resultSet.next()){
				//��ȡ����
				name = resultSet.getString("name");
				record = resultSet.getString("record");
			}
			//����ѯ��������д�뵽���пͻ���
			for(Socket so:list){
				printWriter = new PrintWriter(so.getOutputStream());
				printWriter.write(name+":"+record+"\n");
				printWriter.flush();
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
