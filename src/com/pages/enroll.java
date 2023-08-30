package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class enroll {

	private JFrame frame;
	private JTextField nametxt;
	private JTextField emailtxt;
	private JTextField coursetxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enroll window = new enroll();
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
	public enroll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getContentPane().setForeground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 704, 572);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(49, 28, 567, 497);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setBounds(21, 10, 510, 77);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(130, 54, 28, -1);
		panel_1.add(label);
		
		JLabel lblNewLabel = new JLabel("Enroll Course");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(173, 10, 191, 43);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 220, 220));
		panel_2.setBounds(46, 97, 481, 368);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(164, 10, 122, 27);
		panel_2.add(lblNewLabel_1);
		
		nametxt = new JTextField();
		nametxt.setBounds(164, 61, 170, 19);
		panel_2.add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(164, 108, 170, 27);
		panel_2.add(lblNewLabel_1_1);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		emailtxt.setBounds(164, 155, 170, 19);
		panel_2.add(emailtxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Course");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(164, 195, 170, 27);
		panel_2.add(lblNewLabel_1_1_1);
		
		coursetxt = new JTextField();
		coursetxt.setColumns(10);
		coursetxt.setBounds(164, 243, 170, 19);
		panel_2.add(coursetxt);
		
		JButton addbtn = new JButton("Add");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String url="jdbc:mysql://localhost/enroll_database";
					String username="root";
					String password="";
					String name=nametxt.getText();
					
					String email=emailtxt.getText();
					String course=coursetxt.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="INSERT INTO enroll_student(Student_name,Email,Course) VALUES(?,?,?)";
					PreparedStatement gett=connection.prepareStatement(query);
					
					 gett.setString(1,name);
					 gett.setString(2,email);
					 gett.setString(3,name);
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Student Sucessfully enroll");
					 connection.close();
				
					
				}catch(ClassNotFoundException a) {
					System.out.println(a);
					
				}catch(SQLException ex) {
					System.out.println(ex);
					
				}	
			}
		});
		addbtn.setForeground(new Color(240, 255, 255));
		addbtn.setBackground(new Color(0, 128, 128));
		addbtn.setBounds(199, 289, 85, 21);
		panel_2.add(addbtn);
	}
}
