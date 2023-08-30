package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DeleteTutors {

	private JFrame frame;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteTutors window = new DeleteTutors();
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
	public DeleteTutors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setResizable(false);
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 397, 402);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 183, 107));
		panel.setBounds(64, 23, 245, 53);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Tutors");
		lblNewLabel.setBackground(new Color(85, 107, 47));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(43, 10, 174, 33);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBounds(64, 105, 245, 196);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tutors ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(74, 46, 95, 22);
		panel_1.add(lblNewLabel_1);
		
		id = new JTextField();
		id.setBackground(new Color(248, 248, 255));
		id.setBounds(51, 78, 118, 19);
		panel_1.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String url="jdbc:mysql://localhost/tutorsdatabase";
					String username="root";
					String password="";
						
					String ID=id.getText();
		
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="DELETE from tutortable where ID=?";
					 PreparedStatement gett=connection.prepareStatement(query);
					 
					 
					 gett.setString(1,ID);

						 
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Tutors Sucessfully Deleted");
					 connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
			}
				
			
			}
		});
		btnNewButton.setBackground(new Color(112, 128, 144));
		btnNewButton.setBounds(70, 125, 85, 21);
		panel_1.add(btnNewButton);
	}

}
