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
			String ss = bufferedReader.readLine();	//读取一行数据
			//连接数据库之后使用数据库语句
			preparedStatement = connection.prepareStatement("insert into qqliaotian (name,record)" + "values(?,?)");
			//存入用户名字
			preparedStatement.setString(1, aa);
			//存入用户输入的聊天记录
			preparedStatement.setString(2, ss);
			preparedStatement.executeUpdate();
			//创建Statement类用来执行sql语句
			Statement statement = connection.createStatement();
			//ResultSet类，用来存放获取的结果集
			ResultSet resultSet = statement.executeQuery("select * from qqliaotian");
			//查询表内的所有数据
			while(resultSet.next()){
				//获取数据
				name = resultSet.getString("name");
				record = resultSet.getString("record");
			}
			//将查询到的数据写入到所有客户端
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
