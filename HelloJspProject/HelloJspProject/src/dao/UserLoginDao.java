package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionDBUtil;

import domain.UserLoginDomain;

public class UserLoginDao {
	
	public List<UserLoginDomain> listUserLoginDomain()throws SQLException{
		
		String sql="SELECT * FROM coopjava.userlogin";
		
		Connection conn = ConnectionDBUtil.createConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<UserLoginDomain> resultList = new ArrayList<UserLoginDomain>();
		
		while (rs.next()) {
			
			UserLoginDomain userLoginDomain = new UserLoginDomain();
			userLoginDomain.setUserLoginId(rs.getInt("user_login_id"));
			userLoginDomain.setUsername(rs.getString("username"));
			userLoginDomain.setPassword(rs.getString("password"));
			
			resultList.add(userLoginDomain);
			
		}
		rs.close();
		st.close();
		
		ConnectionDBUtil.closeConnection(conn);
		
		return resultList.size() >0 ? resultList:null;
	}
	
	public UserLoginDomain getUserLoginDomain(String username)throws SQLException{

		String sql="SELECT * FROM coopjava.userlogin  where username = '"+username+"'";
		
		Connection conn = ConnectionDBUtil.createConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		UserLoginDomain userLoginDomain =null;
        
		if (rs.next()) {
			userLoginDomain = new UserLoginDomain();
			userLoginDomain.setUserLoginId(rs.getInt("user_login_id"));
			userLoginDomain.setUsername(rs.getString("username"));
			userLoginDomain.setPassword(rs.getString("password"));
		}
		rs.close();
		st.close();
		
		ConnectionDBUtil.closeConnection(conn);
		
		return userLoginDomain;
		
	}

}
