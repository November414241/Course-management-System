package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TutorTable {
	String url="jdbc:mysql://localhost/tutorsdatabase";
	String username="root";
	String password="";
	
	void tutors() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);
			String query="CREATE TABLE tutorTable(ID varchar(10), Tutor_name varchar(20),email varchar(30),phone_number varchar(20))";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("Tutor Table Created");
			
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}


	public static void main(String[] args) {
		TutorTable ob=new TutorTable();
		ob.tutors();

	}

}
