package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class Sql {
	
	static Connection connection;//Ψһ��connection����
	static LinkedList<Connection> connections = new LinkedList<Connection>();
	
	static{
		for(int i=0;i<10;i++){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiwu","root","971103");
				connections.add(connection);
				if(!connection.isClosed()){
					System.out.println("��ʼ������");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * �������ڵ���󳤶Ȳ�Ϊ��ʱ���ͷ���һ��connection�����Ƴ�������󳤶�Ϊ��ʱ�͵ȴ�
	 * ÿ��ֻ����һ���߳���ʹ���������ݿ�
	 * @return
	 */
	public static Connection fanHui(){
		synchronized (connections) {
			if(connections.size()>0){
				System.out.println("��ǰ��ʣ��"+connections.size()+"��");
				return connections.removeFirst();
			}else{
				try {
					connections.wait();//�����ù�ʱ�����߳̽��еȴ�
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * ���������ݿ�ʹ���������Ȩ�޻��������������Ѿ��ڵȴ�״̬���߳�
	 */
	public static void jieShou(Connection connection){
		synchronized (connections) {
			connections.add(connection);//��ʹ�õ����ӻ�����
			System.out.println("���˻���һ��");
			System.out.println("���غ�ʣ���������"+connections.size()+"��");
			connections.notifyAll();//�������еȴ����߳�	
		}
	}
	
	
	
	private Sql(){}
	
}
