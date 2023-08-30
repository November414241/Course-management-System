package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentAddTable {
	String url="jdbc:mysql://localhost/StudentDatabase";
	String username="root";
	String password="";
	
	void student() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			String query="CREATE TABLE Student_table(ID varchar(10), student_name varchar(30),email varchar(30),phone_number varchar(30), course varchar(30))";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Student Table Created");
			
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentAddTable st=new StudentAddTable();
		st.student();

	}

}
