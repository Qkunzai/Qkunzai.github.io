package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/5/22.
 */
public class ShuJuKu {
    static Connection connection = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/注册","root","971103");
            if (!connection.isClosed())
                System.out.println("数据库链接成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection fanHui(){
        return connection;
    }




    private ShuJuKu(){}
}
