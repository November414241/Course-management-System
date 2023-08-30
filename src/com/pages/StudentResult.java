package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class StudentResult {

	private JFrame frame;
	private JTextField student_id_txt;
	private JTextField student_name_txt;
	private JTextField module1_name_txt;
	private JTextField percent_txt;
	private JTextField module2_name_txt;
	private JTextField module3_name_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentResult window = new StudentResult();
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
	public StudentResult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 396, 456);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(10, 10, 362, 54);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 99, 34);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(10, 74, 362, 318);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 10, 77, 23);
		panel_1.add(lblNewLabel_1);
		
		student_id_txt = new JTextField();
		student_id_txt.setBounds(10, 43, 117, 19);
		panel_1.add(student_id_txt);
		student_id_txt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(207, 10, 117, 23);
		panel_1.add(lblNewLabel_1_1);
		
		student_name_txt = new JTextField();
		student_name_txt.setColumns(10);
		student_name_txt.setBounds(209, 43, 127, 19);
		panel_1.add(student_name_txt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Module-1 Name");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 75, 117, 23);
		panel_1.add(lblNewLabel_1_1_1);
		
		module1_name_txt = new JTextField();
		module1_name_txt.setColumns(10);
		module1_name_txt.setBounds(10, 114, 117, 19);
		panel_1.add(module1_name_txt);
		
		percent_txt = new JTextField();
		percent_txt.setColumns(10);
		percent_txt.setBounds(207, 198, 117, 19);
		panel_1.add(percent_txt);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Total Percentage");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(207, 165, 117, 23);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton = new JButton("Upload Result");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String url="jdbc:mysql://localhost/result_database";
					String username="root";
					String password="";
						
					String id=student_id_txt.getText();
					String student_name=student_name_txt.getText();
					String module1_name=module1_name_txt.getText();
					String module2_name=module2_name_txt.getText();
					String module3_name=module3_name_txt.getText();
					String percent=percent_txt.getText();				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="INSERT INTO student_result(id,student_name,module1_name,module2_name,module3_name,percent) VALUES(?,?,?,?,?,?)";
					 PreparedStatement gett=connection.prepareStatement(query);
					 				 
					 gett.setString(1,id);
					 gett.setString(2,student_name);
					 gett.setString(3,module1_name);
					 gett.setString(4,module2_name);
					 gett.setString(5,module3_name);
					 gett.setString(6,percent);					 
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Result Sucessfully Updataed");
					 connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
			}
				
			
				
			}
		});
		btnNewButton.setBounds(118, 264, 127, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Module-2 Name");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(207, 75, 117, 23);
		panel_1.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Module-3 Name");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2_1.setBounds(10, 165, 117, 23);
		panel_1.add(lblNewLabel_1_1_1_2_1);
		
		module2_name_txt = new JTextField();
		module2_name_txt.setColumns(10);
		module2_name_txt.setBounds(207, 114, 129, 19);
		panel_1.add(module2_name_txt);
		
		module3_name_txt = new JTextField();
		module3_name_txt.setColumns(10);
		module3_name_txt.setBounds(10, 198, 117, 19);
		panel_1.add(module3_name_txt);
		frame.setVisible(true);
	}
}
