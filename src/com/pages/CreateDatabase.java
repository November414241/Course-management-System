package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
	String url="jdbc:mysql://localhost";
	String username="root";
	String password="";
	
	void Createbox() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			String query="CREATE DATABASE SignupData";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Signupdata Databases Created");
			
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		CreateDatabase data=new CreateDatabase();
		data.Createbox();
		
		
	}

}
