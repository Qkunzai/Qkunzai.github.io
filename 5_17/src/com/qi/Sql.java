package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

public class Sql {
	
	static Connection connection;//唯一的connection变量
	static LinkedList<Connection> connections = new LinkedList<Connection>();
	
	static{
		for(int i=0;i<10;i++){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiwu","root","971103");
				connections.add(connection);
				if(!connection.isClosed()){
					System.out.println("初始化链接");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 当集合内的最大长度不为零时，就返回一个connection对象并移除，当最大长度为零时就等待
	 * 每次只允许一个线程来使用链接数据库
	 * @return
	 */
	public static Connection fanHui(){
		synchronized (connections) {
			if(connections.size()>0){
				System.out.println("当前还剩余"+connections.size()+"条");
				return connections.removeFirst();
			}else{
				try {
					connections.wait();//链接用光时所有线程进行等待
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * 当连接数据库使用完后将链接权限还回来，并启动已经在等待状态的线程
	 */
	public static void jieShou(Connection connection){
		synchronized (connections) {
			connections.add(connection);//将使用的链接还回来
			System.out.println("有人还回一条");
			System.out.println("还回后还剩余的链接数"+connections.size()+"条");
			connections.notifyAll();//唤醒所有等待的线程	
		}
	}
	
	
	
	private Sql(){}
	
}
