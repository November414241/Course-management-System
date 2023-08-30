package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultTable {
	String urlString="jdbc:mysql://localhost/result_database";
	String username="root";
	String password="";
	void resultTable() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(urlString,username,password);
			String query="CREATE TABLE Student_result(id varchar(30),student_name varchar(30),module1_name varchar(30),module2_name varchar(30),module3_name varchar(30),percent varchar(30))";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("result table created");
			
		
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}


	public static void main(String[] args) {
		
		ResultTable rt=new ResultTable();
		rt.resultTable();
	}

}
