package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstYearTable {
	String urlString="jdbc:mysql://localhost/Add_Courses";
	String username="root";
	String password="";
	
	void first() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(urlString,username,password);
			String query="CREATE TABLE First_year(id int PRIMARY KEY AUTO_INCREMENT,course_id int(10), course VARCHAR(20), batch VARCHAR(20), no_of_seats VARCHAR(20), module1 VARCHAR(30), module2 VARCHAR(30), module3 VARCHAR(30),module4 VARCHAR(30), module_tutor1 VARCHAR(30), module_tutor2 VARCHAR(30),module_tutor3 VARCHAR(30),module_tutor4 VARCHAR(30))";
			Statement statement=connection.createStatement();
			statement.execute(query);
			System.out.println("1st year Table created");
			
		
			connection.close();
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
	}

	public static void main(String[] args) {
		FirstYearTable fyt=new FirstYearTable();
		fyt.first();
		

	}

}
