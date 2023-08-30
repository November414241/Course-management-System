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

public class AddStudent {

	private JFrame frame;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField emailtxt;
	private JTextField numbertxt;
	private JTextField coursenametxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent window = new AddStudent();
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
	public AddStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 139, 139));
		frame.setBounds(100, 100, 397, 456);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 183, 107));
		panel.setBounds(81, 10, 230, 52);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Details of Students");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 210, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(101, 72, 112, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		idtxt = new JTextField();
		idtxt.setForeground(new Color(0, 0, 0));
		idtxt.setBackground(new Color(255, 250, 250));
		idtxt.setBounds(101, 99, 184, 19);
		frame.getContentPane().add(idtxt);
		idtxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Name");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(101, 123, 112, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		nametxt = new JTextField();
		nametxt.setColumns(10);
		nametxt.setBounds(101, 151, 184, 19);
		frame.getContentPane().add(nametxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(101, 180, 112, 18);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		emailtxt.setBounds(101, 208, 184, 19);
		frame.getContentPane().add(emailtxt);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Contact Number");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(101, 237, 112, 18);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		numbertxt = new JTextField();
		numbertxt.setColumns(10);
		numbertxt.setBounds(101, 265, 184, 19);
		frame.getContentPane().add(numbertxt);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Course Name");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(101, 299, 112, 18);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		coursenametxt = new JTextField();
		coursenametxt.setColumns(10);
		coursenametxt.setBounds(101, 327, 184, 19);
		frame.getContentPane().add(coursenametxt);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String url="jdbc:mysql://localhost/StudentDatabase";
					String username="root";
					String password="";
					String ID=idtxt.getText();
					String student_name=nametxt.getText();
					String email=emailtxt.getText();
					String phone=numbertxt.getText();
					String coursename=coursenametxt.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="INSERT INTO Student_table(ID,student_name,email,phone_number,course) VALUES(?,?,?,?,?)";
					PreparedStatement gett=connection.prepareStatement(query);
					gett.setString(1,ID);
					 gett.setString(2,student_name);
					 gett.setString(3,email);
					 gett.setString(4,phone);
					 gett.setString(5,coursename);
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Student Sucessfully Added");
					 connection.close();
				
					
				}catch(ClassNotFoundException a) {
					System.out.println(a);
					
				}catch(SQLException ex) {
					System.out.println(ex);
					
				}	
			}
		});
		btnNewButton.setBounds(288, 372, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 128, 128));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String url="jdbc:mysql://localhost/StudentDatabase";
					String username="root";
					String password="";
					String ID=idtxt.getText();
					String student_name=nametxt.getText();
					String email=emailtxt.getText();
					String phone=numbertxt.getText();
					String coursename=coursenametxt.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="UPDATE Student_table set student_name=?,email=?,phone_number=?,course=? where ID=?";
					PreparedStatement gett=connection.prepareStatement(query);
					
					 gett.setString(1,student_name);
					 gett.setString(2,email);
					 gett.setString(3,phone);
					 gett.setString(4,coursename);
					 gett.setString(5,ID);
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Student Sucessfully Updated");
					 connection.close();
				
					
				}catch(ClassNotFoundException a) {
					System.out.println(a);
					
				}catch(SQLException ex) {
					System.out.println(ex);
					
				}	
			}
				
				
			
		});
		btnUpdate.setBounds(52, 372, 85, 21);
		frame.getContentPane().add(btnUpdate);
	}

}
