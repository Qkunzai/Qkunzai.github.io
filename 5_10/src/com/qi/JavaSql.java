package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaSql {
	//将Connection类设置成静态
	static Connection connection;
	//静态代码块只能执行一次
	static {
		//连接到驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//1.getConnection()方法，连接MySQL数据库！！
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wuqizi","root","971103");
			//查询是否已关闭这个connection对象，取反的意思是不关闭
			if(!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection fanHui(){
		return connection;
	}
	
	private JavaSql(){
		
	}
	
	
}
