package com.qi;

//��������

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
        	//������������
            server = new ServerSocket(8086);
            System.out.println("�������˴����ɹ�");
            while(true){
            	//�����˿�
	            Socket socket = server.accept();
                byte[] buf = new byte[1024];
	            //��ȡ������Ϣ
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
	            
	            //MySQl��ѯ��Ӧ��λ��
	    		//����Connection����
	    		Connection con;
				//������������
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","0214");

				//�ж������Ƿ�ɹ�
				if(!con.isClosed()){
					 System.out.println("Succeeded connecting to the Database!");
				}
				//����statement���������ִ��SQL���
				Statement statement = con.createStatement();
				//Ҫִ�е�SQL���
				String sql = "select * from html";
				//ResultSet�࣬������Ż�ȡ�Ľ����
				ResultSet rs = statement.executeQuery(sql);
				//����Ҫ��ѯ���ֶ�
				String name = null;
				String weizhi = null;
				while(rs.next()){
					//��ȡname����
					name = rs.getString("name");
					if(name.equals(sss[0])){
					//��ȡweizhi��������
						weizhi = rs.getString("weizhi");
					}
				}
				System.out.println(weizhi);
				
				
	            //������Ӧ����
	            FileInputStream fileInputStream = new FileInputStream(new File(weizhi));
	            PrintStream writer = new PrintStream(socket.getOutputStream());
	            writer.println("HTTP/1.1 200 OK");// ����Ӧ����Ϣ,������Ӧ��
	            writer.println("Content-Type:text/html");
	            writer.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ
	            byte[] buf1 = new byte[fileInputStream.available()];
	            //��ȡ�ļ����ݵ�buf1���鵱�С�
	            fileInputStream.read(buf1);
	            //д�뵽��������С�
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
