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

public class EditTutors {

	private JFrame frame;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField emailtxt;
	private JTextField numtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTutors window = new EditTutors();
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
	public EditTutors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 394, 457);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(60, 10, 252, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Tutors");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(61, 10, 113, 38);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(60, 95, 252, 315);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tutors ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(73, 10, 78, 18);
		panel_1.add(lblNewLabel_1);
		
		idtxt = new JTextField();
		idtxt.setBounds(73, 38, 118, 19);
		panel_1.add(idtxt);
		idtxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
									
					String url="jdbc:mysql://localhost/tutorsdatabase";
					String username="root";
					String password="";
						
					String id=idtxt.getText();
					String name=nametxt.getText();
					String emaill=emailtxt.getText();
					String number=numtxt.getText();				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="UPDATE tutortable set Tutor_name=?,email=?,phone_number=? where ID=?";
					 PreparedStatement gett=connection.prepareStatement(query);
					 
					 
					 gett.setString(1,name);
					 gett.setString(2,emaill);
					 gett.setString(3,number);
					 gett.setString(4,id);
						 
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Tutors Sucessfully Updataed");
					 connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
			}
				
			}
			
		});
		btnNewButton.setBounds(84, 260, 85, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tutors Name");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(73, 66, 96, 18);
		panel_1.add(lblNewLabel_1_1);
		
		nametxt = new JTextField();
		nametxt.setColumns(10);
		nametxt.setBounds(73, 91, 118, 19);
		panel_1.add(nametxt);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(73, 120, 96, 18);
		panel_1.add(lblNewLabel_1_1_1);
		
		emailtxt = new JTextField();
		emailtxt.setColumns(10);
		emailtxt.setBounds(73, 148, 118, 19);
		panel_1.add(emailtxt);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(73, 190, 134, 18);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		numtxt = new JTextField();
		numtxt.setColumns(10);
		numtxt.setBounds(73, 218, 118, 19);
		panel_1.add(numtxt);
	}

}
