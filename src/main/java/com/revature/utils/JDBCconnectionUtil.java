package com.revature.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import com.revature.dao.EmployeeDaoImp;

public class JDBCconnectionUtil {

	
	//JDBC  - java database connectivity
	public  static Connection getConnection() throws SQLException {
		try {
			Properties props = new Properties();
			FileInputStream in = new FileInputStream("C:\\SpringToolSuite\\ERproj1\\src\\main\\resources\\dbConnInfo.properties");
			props.load(in);
			in.close();
			
			String driver = props.getProperty("jdbc.driver");
				if(driver!=null) {
					Class.forName(driver);	
				}
					String url = props.getProperty("jdbc.url");
					String username = props.getProperty("jdbc.username");
					String password = props.getProperty("jdbc.password");
			return DriverManager.getConnection(url, username, password);
			
			
		}
		catch ( IOException | ClassNotFoundException | SQLException e) {
			e.getStackTrace();
			e.printStackTrace();		
		}
		return null;	
	}
}
