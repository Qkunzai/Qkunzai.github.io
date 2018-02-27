package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class SqlTest {

	public static void main(String[] args) {
		//声明Connection对象 	
		Connection connection;
		try {
			//连接到驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//1.getConnection()方法，连接MySQL数据库！！
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qq","root","971103");
			//查询是否已关闭这个connection对象，取反的意思是不关闭
			if(!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			//创建statement类对象，用来执行sql语句
			Statement statement = connection.createStatement();
			//ResultSet类，用来存放获取的结果集
			ResultSet resultSet = statement.executeQuery("select * from book");
			System.out.println("--------------------------------------------------------");
			System.out.println("-----------------------执行结果---------------------------");
			System.out.println("--------------------------------------------------------");
			System.out.println("编号\t"+"分类\t"+"书名\t"+"作者\t"+"出版社\t"+"价格");
			System.out.println("--------------------------------------------------------");
			while(resultSet.next()){
				//获取数据
				String bian = 	resultSet.getString("bianhao");
				String fen = 	resultSet.getString("fenlei");
				String shu = 	resultSet.getString("shuming");
				String zuo = 	resultSet.getString("zuozhe");
				String chu = 	resultSet.getString("chuban");
				String jia = 	resultSet.getString("danjia");
				System.out.println(bian+"\t"+fen+"\t"+shu+"\t"+zuo+"\t"+chu+"\t"+jia);
			}
			//删除数据
			java.sql.PreparedStatement statement3 =connection.prepareStatement("delete from book where zuozhe = ?");
			statement3.setString(1,"李刚");
			statement3.executeUpdate();
			//增加数据
			java.sql.PreparedStatement psql = connection.prepareStatement("insert into book (bianhao,fenlei,shuming,zuozhe,chuban,danjia)" + "values(?,?,?,?,?,?)");
			psql.setInt(1,320000);		//设置参数为一，创建编号为3200的数据
			psql.setString(2,"TP4/15");		//设置参数为2，分类为编程语言
			psql.setString(3,"疯狂java");
			psql.setString(4, "李刚");
			psql.setString(5,"  ");
			psql.setFloat(6, (float)79.3);
			psql.executeUpdate();
			//更新数据
			//预处理更新（修改）数据，将李刚的书价格改为60.0
			java.sql.PreparedStatement statement2 =connection.prepareStatement("update book set bianhao = ? where zuozhe = ?");
			statement2.setInt(1,320002);
			statement2.setString(2, "李刚");
			statement2.executeUpdate();
			resultSet.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
