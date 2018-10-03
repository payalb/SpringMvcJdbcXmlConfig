package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.java.exception.DatabaseException;

public class DatabaseUtil {

	
	private String url;
	private String username;
	private String password;
	private String driverName;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Connection getConnection() throws DatabaseException {
		Connection connection= null;
		try {
			Class.forName(driverName);
		
		 connection=	DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			throw new DatabaseException("Could not load the driver class for the database!");
		} catch (SQLException e) {
			throw new DatabaseException("Could not connect to the database. Please check the credentials");
		}
		return connection;
	}
	
}
