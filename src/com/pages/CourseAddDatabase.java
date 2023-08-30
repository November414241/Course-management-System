package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseAddDatabase {
	
	String url="jdbc:mysql://localhost";
	String username="root";
	String password="";
	
	void addCourse() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			String query="CREATE DATABASE Add_Courses";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Add courses Databases Created");
			
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		CourseAddDatabase base=new CourseAddDatabase();
		base.addCourse();
		

	}

}
