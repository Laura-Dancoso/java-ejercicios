package com.laura.AudienciaJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    public static Connection getConnection() throws Exception{

        String driver ="com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/programas";
        String user = "root";
        String pwd = "";
        Class.forName(driver).newInstance();

        return DriverManager.getConnection(url,user,pwd);
    }
}
