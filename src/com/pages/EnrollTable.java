package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EnrollTable {
	String urlString="jdbc:mysql://localhost/enroll_database";
	String username="root";
	String password="";
	
	void enrollt() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(urlString,username,password);
			String query="CREATE TABLE Enroll_Student(id int PRIMARY KEY AUTO_INCREMENT, Student_name VARCHAR(30),Email VARCHAR(30), Course VARCHAR(30))";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Enroll Table created");
			
		
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnrollTable en=new EnrollTable();
		en.enrollt();
	}

}
