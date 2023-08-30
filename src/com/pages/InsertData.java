package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
//	String urlString="jdbc:mysql://localhost/SignupData";
//	String username="root";
//	String password="";
	
	void data() {
		try {
			String urlString="jdbc:mysql://localhost/SignupData";
			String username="root";
			String password="";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(urlString,username,password);
			String query="INSERT INTO signingData(user_name,email_or_PhoneNumber,password,phoneNumber) VALUES(?,?,?,?)";
			 PreparedStatement statement=connection.prepareStatement(query);

			
			 
		
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		InsertData da=new InsertData();
		da.data();
		

	}

}
