package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddTutors {

	private JFrame frame;
	private JTextField Tutornametxt;
	private JTextField temailtxt;
	private JTextField phonetxt;
	private JTextField idTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTutors window = new AddTutors();
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
	public AddTutors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 455, 518);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(79, 10, 283, 53);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Tutors");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(68, 10, 122, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tutors Name");
		lblNewLabel_1.setBounds(145, 138, 95, 26);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1);
		
		Tutornametxt = new JTextField();
		Tutornametxt.setBounds(145, 174, 147, 19);
		frame.getContentPane().add(Tutornametxt);
		Tutornametxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setBounds(145, 202, 95, 26);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		temailtxt = new JTextField();
		temailtxt.setBounds(145, 238, 147, 19);
		temailtxt.setColumns(10);
		frame.getContentPane().add(temailtxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1_1.setBounds(145, 267, 95, 26);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		phonetxt = new JTextField();
		phonetxt.setBounds(145, 315, 147, 19);
		phonetxt.setColumns(10);
		frame.getContentPane().add(phonetxt);
		
		JButton tadddetailtxt = new JButton("Add Details");
		tadddetailtxt.setForeground(new Color(255, 250, 250));
		tadddetailtxt.setBackground(new Color(0, 128, 128));
		tadddetailtxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String url="jdbc:mysql://localhost/tutorsdatabase";
					String username="root";
					String password="";
					String id=idTxt.getText();
					String name=Tutornametxt.getText();
					String email=temailtxt.getText();
					String phone=phonetxt.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="INSERT INTO tutorTable(ID,Tutor_name,email,phone_number) VALUES(?,?,?,?)";
					PreparedStatement gett=connection.prepareStatement(query);
					gett.setString(1,id);
					 gett.setString(2,name);
					 gett.setString(3,email);
					 gett.setString(4,phone);
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Tutor Sucessfully Added");
					 connection.close();
				
					
				}catch(ClassNotFoundException a) {
					System.out.println(a);
					
				}catch(SQLException ex) {
					System.out.println(ex);
					
				}	
			}
		});
		tadddetailtxt.setBounds(145, 365, 105, 21);
		frame.getContentPane().add(tadddetailtxt);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(145, 73, 95, 26);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		idTxt.setBounds(145, 109, 147, 19);
		frame.getContentPane().add(idTxt);
	}
}
