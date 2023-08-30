package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.JScrollPane;

public class ViewProgress {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProgress window = new ViewProgress();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewProgress() {
		initialize();
		try {
			
			
			String url="jdbc:mysql://localhost/result_database";
			String username="root";
			String password="";						
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url,username,password);		
			String query="SELECT * from student_result";
			Statement statement=connection.createStatement();		
			DefaultTableModel tmodel=(DefaultTableModel)table.getModel();
			tmodel.setRowCount(0);
			
			ResultSet set = statement.executeQuery(query);

			while(set.next()) {
				 String id=set.getString("id");
				 String studentname=set.getString("student_name");
				 String module1=set.getString("module1_name");
				 String module2=set.getString("module2_name");
				 String module3=set.getString("module3_name");
				 String grade=set.getString("percent");
				 String tableData[]= {id,studentname,module1,module2,module3,grade};	 	 
			 	 tmodel.addRow(tableData);
			 	 

			 	 
			 }
			 
				  connection.close();
	}catch(ClassNotFoundException a) {
		System.out.println(a);
		
	}catch(SQLException ex) {
		System.out.println(ex);
		
		
	}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 663, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(10, 10, 174, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Progress");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setBackground(new Color(85, 107, 47));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 154, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 70, 619, 279);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 599, 259);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(255, 250, 250));
		table.setBackground(new Color(0, 139, 139));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Student Name", "Module 1", "Module 2", "Module 3", "Percentage"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
	}
}
