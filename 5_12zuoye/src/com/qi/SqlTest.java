package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class SqlTest {

	public static void main(String[] args) {
		//����Connection���� 	
		Connection connection;
		try {
			//���ӵ���������
			Class.forName("com.mysql.jdbc.Driver");
			//1.getConnection()����������MySQL���ݿ⣡��
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qq","root","971103");
			//��ѯ�Ƿ��ѹر����connection����ȡ������˼�ǲ��ر�
			if(!connection.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			//����statement���������ִ��sql���
			Statement statement = connection.createStatement();
			//ResultSet�࣬������Ż�ȡ�Ľ����
			ResultSet resultSet = statement.executeQuery("select * from book");
			System.out.println("--------------------------------------------------------");
			System.out.println("-----------------------ִ�н��---------------------------");
			System.out.println("--------------------------------------------------------");
			System.out.println("���\t"+"����\t"+"����\t"+"����\t"+"������\t"+"�۸�");
			System.out.println("--------------------------------------------------------");
			while(resultSet.next()){
				//��ȡ����
				String bian = 	resultSet.getString("bianhao");
				String fen = 	resultSet.getString("fenlei");
				String shu = 	resultSet.getString("shuming");
				String zuo = 	resultSet.getString("zuozhe");
				String chu = 	resultSet.getString("chuban");
				String jia = 	resultSet.getString("danjia");
				System.out.println(bian+"\t"+fen+"\t"+shu+"\t"+zuo+"\t"+chu+"\t"+jia);
			}
			//ɾ������
			java.sql.PreparedStatement statement3 =connection.prepareStatement("delete from book where zuozhe = ?");
			statement3.setString(1,"���");
			statement3.executeUpdate();
			//��������
			java.sql.PreparedStatement psql = connection.prepareStatement("insert into book (bianhao,fenlei,shuming,zuozhe,chuban,danjia)" + "values(?,?,?,?,?,?)");
			psql.setInt(1,320000);		//���ò���Ϊһ���������Ϊ3200������
			psql.setString(2,"TP4/15");		//���ò���Ϊ2������Ϊ�������
			psql.setString(3,"���java");
			psql.setString(4, "���");
			psql.setString(5,"  ");
			psql.setFloat(6, (float)79.3);
			psql.executeUpdate();
			//��������
			//Ԥ������£��޸ģ����ݣ�����յ���۸��Ϊ60.0
			java.sql.PreparedStatement statement2 =connection.prepareStatement("update book set bianhao = ? where zuozhe = ?");
			statement2.setInt(1,320002);
			statement2.setString(2, "���");
			statement2.executeUpdate();
			resultSet.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
