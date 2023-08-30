package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class Signup {

	private JFrame frame;
	private JTextField textF;
	private JPasswordField passwordField;
	private JTextField contactnumber;
	private JTextField emiltext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
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
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 139, 139));
		frame.setResizable(false);
		frame.setBounds(100, 100, 491, 602);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 10, 477, 55);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Signup Pannel");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblNewLabel.setBounds(101, 10, 287, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Username");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(169, 111, 129, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Email or Phone number");
		lblNewLabel_1_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(169, 192, 231, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Enter Password");
		lblNewLabel_1_1_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(169, 266, 129, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone number");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(169, 348, 129, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		textF = new JTextField();
		textF.setForeground(new Color(253, 245, 230));
		textF.setBackground(new Color(0, 139, 139));
		textF.setBorder(null);
		textF.setBounds(169, 134, 198, 23);
		frame.getContentPane().add(textF);
		textF.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(253, 245, 230));
		passwordField.setBackground(new Color(0, 139, 139));
		passwordField.setBorder(null);
		passwordField.setBounds(169, 289, 198, 30);
		frame.getContentPane().add(passwordField);
		
		contactnumber = new JTextField();
		contactnumber.setForeground(new Color(253, 245, 230));
		contactnumber.setBackground(new Color(0, 139, 139));
		contactnumber.setBorder(null);
		contactnumber.setColumns(10);
		contactnumber.setBounds(169, 371, 198, 30);
		frame.getContentPane().add(contactnumber);
		
		emiltext = new JTextField();
		emiltext.setForeground(new Color(253, 245, 230));
		emiltext.setBackground(new Color(0, 139, 139));
		emiltext.setBorder(null);
		emiltext.setColumns(10);
		emiltext.setBounds(169, 215, 198, 23);
		frame.getContentPane().add(emiltext);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(169, 160, 198, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(169, 239, 198, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(169, 319, 198, 2);
		frame.getContentPane().add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(169, 404, 198, 2);
		frame.getContentPane().add(separator_1_1_1);
		
		JComboBox comboBox = new JComboBox();	
		comboBox.setForeground(new Color(255, 250, 250));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBackground(new Color(0, 139, 139));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select User mode", "Student", "Teacher", "Admin"}));
		comboBox.setBounds(169, 438, 198, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(299, 505, 86, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				textF.setText("");
//				emiltext.setText("");
//				passwordField.setText("");
//				contactnumber.setText("");
//				
				try {
					
						if(comboBox.getSelectedItem().toString()=="Student") {
							String url="jdbc:mysql://localhost/SignupData";
							String username="root";
							String password="";
							
						
						String user_name=textF.getText();
						String email=emiltext.getText();
						String pass=String.valueOf(passwordField.getPassword());
						String num=contactnumber.getText();
										
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						
						
						String queryi="INSERT INTO Student(user_name,email_or_PhoneNumber,password,phoneNumber) VALUES(?,?,?,?)";
						 PreparedStatement gett=connection.prepareStatement(queryi);
						 gett.setString(1,user_name);
						 gett.setString(2,email);
						 gett.setString(3,pass);
						 gett.setString(4,num);
						 
						 gett.executeUpdate();
						 
						 JOptionPane.showMessageDialog(null, "Created !!");
						 connection.close();
					
						
					}else if(comboBox.getSelectedItem().toString()=="Teacher") {
						String urlString="jdbc:mysql://localhost/SignupData";
						String username="root";
						String password="";
						
						String user_name=textF.getText();
						String email=emiltext.getText();
						String pass=String.valueOf(passwordField.getPassword());
						String num=contactnumber.getText();
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(urlString,username,password);
						
						String queryi="INSERT INTO Teacher(user_name,email_or_PhoneNumber,password,phoneNumber) VALUES(?,?,?,?)";
						 PreparedStatement gett=connection.prepareStatement(queryi);
						 gett.setString(1,user_name);
						 gett.setString(2,email);
						 gett.setString(3,pass);
						 gett.setString(4,num);
						 gett.executeUpdate();
						 JOptionPane.showMessageDialog(null, "Created !!");
						 connection.close();
						 
						 
						 
						 
						
					}else if(comboBox.getSelectedItem().toString()=="Admin") {
						String urlString="jdbc:mysql://localhost/SignupData";
						String username="root";
						String password="";
						
						String user_name=textF.getText();
						String email=emiltext.getText();
						String pass=String.valueOf(passwordField.getPassword());
						String num=contactnumber.getText();
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(urlString,username,password);
						
						
						
						String queryi="INSERT INTO Admin(user_name,email_or_PhoneNumber,password,phoneNumber) VALUES(?,?,?,?)";
						 PreparedStatement gett=connection.prepareStatement(queryi);
						 gett.setString(1,user_name);
						 gett.setString(2,email);
						 gett.setString(3,pass);
						 gett.setString(4,num);
						 gett.executeUpdate();
						 JOptionPane.showMessageDialog(null, "Created !!");
						 connection.close();
						
						
					}
				}catch(ClassNotFoundException a) {
					System.out.println(a);
					
				}catch(SQLException ex) {
					System.out.println(ex);
					
					
				}
				
				
				
				
			}
		});
		btnCreate.setForeground(new Color(255, 250, 250));
		btnCreate.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnCreate.setBackground(new Color(0, 139, 139));
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCreate.setBounds(169, 505, 86, 30);
		frame.getContentPane().add(btnCreate);
		
		
	}
}
