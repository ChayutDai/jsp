package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class ConnectionDBUtil {
	public static Connection createConnection(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coopjava", "root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM coopjava.userlogin");
			
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return conn;
	}
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} 		
	}
	
}
