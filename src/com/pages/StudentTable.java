package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTable {
	String urlString="jdbc:mysql://localhost/SignupData";
	String username="root";
	String password="";
	void dtable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(urlString,username,password);
			String query="CREATE TABLE student(signingData_id int PRIMARY KEY AUTO_INCREMENT, user_name VARCHAR(30), email_or_PhoneNumber VARCHAR(30), password VARCHAR(30), phoneNumber VARCHAR(30))";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Student Table created");
			
		
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		 StudentTable table=new StudentTable();
		 table.dtable();

	}

}
