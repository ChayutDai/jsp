package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.UserLoginDomain;

import util.ConnectionDBUtil;



public class TestDBConnection {
	public static void main(String[] args)throws SQLException {

		UserLoginDao userLoginDao = new UserLoginDao();
		/*List<UserLoginDomain> userLoginDomainList =userLoginDao.listUserLoginDomain();
		
		//UserLoginDomain add = userLoginDao.getUserLoginDomain(username);
			for (UserLoginDomain u : userLoginDomainList) {
				
				System.out.println("userloginId: "+u.getUserLoginId());
				System.out.println("username: "+u.getUsername());
				System.out.println("password: "+u.getPassword());
				System.out.println("--------------");
			}*/
		UserLoginDomain userLoginDomain = userLoginDao.getUserLoginDomain("ched");
		if (userLoginDomain !=null) {
			System.out.println("userloginId: "+userLoginDomain.getUserLoginId());
			System.out.println("username: "+userLoginDomain.getUsername());
			System.out.println("password: "+userLoginDomain.getPassword());
			System.out.println("--------------");
			
		} else {
			System.out.println("Not Found User");
		}
	}

}
