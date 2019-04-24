package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;

public class DBConnector {
	
	public static Connection getconnect() throws Exception {
		
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
		
		
	}
	
	public static void disconnect(PreparedStatement st, Connection con) throws Exception {
		
		st.close();
		con.close();
		
	}
	
	public static void disconnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception {
		
		
		rs.close();
		DBConnector.disconnect(st, con);
		
	}

}
