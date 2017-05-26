package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;

public class DanLi {

	//唯一变量为静态
	static Connection connection = null;
	
	//静态代码块只能执行一次
	static {
		//连接到驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//1.getConnection()方法，连接MySQL数据库！！
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QQ","root","971103");
			//查询是否已关闭这个connection对象，取反的意思是不关闭
			if(!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//给外部一个接口返回已经连接过数据库驱动的对象
	public static Connection fanHui(){
		return connection;
	}
	//单例模式为私有构造器
	private DanLi(){
		
		
	}
}
