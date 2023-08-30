package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDatabases {
	String url="jdbc:mysql://localhost";
	String username="root";
	String password="";
	
	void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			
			if(!connection.isClosed()) {
				System.out.println("Connect !!");
				
			}
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}
	
	public static void main(String[] args) {
		ConnectDatabases connectn=new ConnectDatabases();
		connectn.connect();	

	}
	

}
