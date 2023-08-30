package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EnrollDatabase {
	
	String url="jdbc:mysql://localhost";
	String username="root";
	String password="";
	
	void enroll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			String query="CREATE DATABASE Enroll_database";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Enroll Databases Created");
			
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		EnrollDatabase en=new EnrollDatabase();
		en.enroll();
		

	}

}
