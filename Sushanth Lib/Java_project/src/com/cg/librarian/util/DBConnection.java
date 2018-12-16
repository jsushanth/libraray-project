package com.cg.librarian.util;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.sql.*;
	import java.util.Properties;

	public class DBConnection {

		

		
			public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException  {

				Connection connection=null;
				Properties properties = new Properties();

				
				FileInputStream inputStream = new FileInputStream("resources/DB.properties");
				
				
				
					properties.load(inputStream);
					

					String driver = properties.getProperty("driver");
					//System.out.println(driver);
					String url = properties.getProperty("url");
					String username = properties.getProperty("username");
					String password = properties.getProperty("password");

						Class.forName(driver);
						connection=DriverManager.getConnection(url, username, password);
					
inputStream.close();

				return connection;

			}
			
		}




