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

public class DeleteStudent {

	private JFrame frame;
	private JTextField id_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent window = new DeleteStudent();
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
	public DeleteStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setResizable(false);
		frame.setBounds(100, 100, 392, 347);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		panel.setBounds(50, 10, 287, 52);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Details of Students");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(43, 10, 234, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(50, 72, 287, 222);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(71, 22, 127, 19);
		panel_1.add(lblNewLabel_1);
		
		id_txt = new JTextField();
		id_txt.setBounds(71, 73, 141, 19);
		panel_1.add(id_txt);
		id_txt.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String url="jdbc:mysql://localhost/StudentDatabase";
					String username="root";
					String password="";
						
					String ID=id_txt.getText();
		
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="DELETE from Student_table where ID=?";
					 PreparedStatement gett=connection.prepareStatement(query);
					 
					 
					 gett.setString(1,ID);

						 
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Student Sucessfully Deleted");
					 connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
			}
			}
		});
		btnNewButton.setBounds(89, 127, 85, 21);
		panel_1.add(btnNewButton);
	}

}
