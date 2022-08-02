package sar.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTemplate_ad {

	public static Connection getConnection() throws Exception{
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##MINIPRJ_2";
		String pwd = "MINIPRJ";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,id,pwd);
		conn.setAutoCommit(false);
		
		return conn;
		
	}
	public static void commit(Connection conn) {
		try {
			if(conn != null) conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
		if(conn != null) conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement st) {
		try {
			if(st != null) st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//스캐너
	public static Scanner sc = new Scanner(System.in);
	
	public static int getInt() {
		String s = sc.nextLine();
		return Integer.parseInt(s);
	}
	
	
	
	
	
}
