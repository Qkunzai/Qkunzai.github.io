package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DanLi {

	//Ψһ����Ϊ��̬
	static Connection connection = null;
	
	//��̬�����ֻ��ִ��һ��
	static {
		//���ӵ���������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//1.getConnection()����������MySQL���ݿ⣡��
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QQ","root","971103");
			//��ѯ�Ƿ��ѹر����connection����ȡ������˼�ǲ��ر�
			if(!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���ⲿһ���ӿڷ����Ѿ����ӹ����ݿ������Ķ���
	public static Connection fanHui(){
		return connection;
	}
	//����ģʽΪ˽�й�����
	private DanLi(){
		
		
	}
}
