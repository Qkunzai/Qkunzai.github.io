package com.qi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestShiWu2 implements Runnable {

	@Override
	public void run() {
		PreparedStatement preparedStatement;
		Connection connection = Sql.fanHui();
		int i=1;
		String sql = "update shiwus set name='33' where id="+(++i);
		try{
			
			connection.setAutoCommit(false);//开启事务功能
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
		}catch(Exception e){
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			Sql.jieShou(connection);
		}
	}

}

