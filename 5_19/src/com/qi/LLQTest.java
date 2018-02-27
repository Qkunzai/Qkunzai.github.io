package com.qi;

//服务器端

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

public class LLQTest {
	public static void main(String[] args) {
        ServerSocket server = null;
        try{
        	//创建服务器端
            server = new ServerSocket(8086);
            System.out.println("服务器端创建成功");
            while(true){
            	//监听端口
	            Socket socket = server.accept();
                byte[] buf = new byte[1024];
	            //读取请求信息
//                InputStream in = socket.getInputStream();
//                in.read(buf);
//                System.out.println("request from client " + socket.getInetAddress().getHostAddress());
//                System.out.println(new String(buf));
	            
	            BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            String s = bufferedReader.readLine();
//	            System.out.println(s);
	            String[] ss = s.split("/");
	            String[] sss = ss[1].split(" ");
//	            System.out.println(sss[0]);
	            
	            //MySQl查询相应的位置
	    		//声明Connection对象
	    		Connection con;
				//加载驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","0214");

				//判断链接是否成功
				if(!con.isClosed()){
					 System.out.println("Succeeded connecting to the Database!");
				}
				//创建statement类对象，用来执行SQL语句
				Statement statement = con.createStatement();
				//要执行的SQL语句
				String sql = "select * from html";
				//ResultSet类，用来存放获取的结果集
				ResultSet rs = statement.executeQuery(sql);
				//声明要查询的字段
				String name = null;
				String weizhi = null;
				while(rs.next()){
					//获取name数据
					name = rs.getString("name");
					if(name.equals(sss[0])){
					//获取weizhi这列数据
						weizhi = rs.getString("weizhi");
					}
				}
				System.out.println(weizhi);
				
				
	            //发送响应内容
	            FileInputStream fileInputStream = new FileInputStream(new File(weizhi));
	            PrintStream writer = new PrintStream(socket.getOutputStream());
	            writer.println("HTTP/1.1 200 OK");// 返回应答消息,并结束应答
	            writer.println("Content-Type:text/html");
	            writer.println();// 根据 HTTP 协议, 空行将结束头信息
	            byte[] buf1 = new byte[fileInputStream.available()];
	            //读取文件内容到buf1数组当中。
	            fileInputStream.read(buf1);
	            //写入到输出流当中。
	            writer.write(buf1);
	            writer.flush();
	            writer.close();
	            socket.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
