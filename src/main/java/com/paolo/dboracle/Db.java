package com.paolo.dboracle;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.paolo.appfrontend.HomeScreen;

import com.paolo.dboracle.DbException;

public class Db {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {

			try {
				
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);

			} catch (SQLException e) {

				throw new DbException(e.getMessage());

			}
		}

		return conn;
	}

	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	
	private static Properties loadProperties() {
	    try {
	        Properties props = new Properties();
	        
	        // Obtém os valores dos campos de texto
	        String host = HomeScreen.getFieldHost().getText();
	        String user = HomeScreen.getFieldUser().getText();
	        String password = HomeScreen.getFieldPassword().getText();
	        
	        

	        // Adiciona os valores às propriedades
	        props.setProperty("password", password);
	        props.setProperty("user", user);
	        props.setProperty("dburl", host);
	        
	        System.out.println(props);
	        return props;
	    } catch (Exception e) {
	        throw new DbException(e.getMessage());
	    }
	}

}
