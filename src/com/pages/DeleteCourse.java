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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Color;

public class DeleteCourse {

	private JFrame frame;
	private JTextField id_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCourse window = new DeleteCourse();
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
	public DeleteCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 397, 387);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(46, 28, 294, 68);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete course");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(83, 25, 201, 33);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(46, 117, 294, 196);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter course ID");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(75, 68, 113, 23);
		panel_1.add(lblNewLabel_1);
		
		id_txt = new JTextField();
		id_txt.setBounds(75, 101, 120, 19);
		panel_1.add(id_txt);
		id_txt.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 250, 250));
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Level ", "Level_4", "Level_5", "Level_6"}));
		comboBox.setBounds(75, 10, 120, 21);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setForeground(new Color(255, 250, 250));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(comboBox.getSelectedItem().toString()=="Level_4") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
							
						String course_id=id_txt.getText();
										
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						
						String query="DELETE from first_year where course_id=?";
						 PreparedStatement gett=connection.prepareStatement(query);
						
						 gett.setString(1,course_id);
						 

					 
						 gett.executeUpdate();
						 
//						 int var=JOptionPane.showConfirmDialog(null, "Do you want to delete ?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
//						 System.out.println(var);
						 JOptionPane.showMessageDialog(null, "Course Sucessfully Deleted");
						 connection.close();

					}else if(comboBox.getSelectedItem().toString()=="Level_5") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						
						String course_id=id_txt.getText();
							
									
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
					
						
						 String query="DELETE from Second_year where course_id=?";
						 PreparedStatement gett=connection.prepareStatement(query);
						 
						 gett.setString(1,course_id);
						 
						 gett.executeUpdate();
						 
						 JOptionPane.showMessageDialog(null, "Course Sucessfully Deleted");
						 connection.close();
						
						
					}else if(comboBox.getSelectedItem().toString()=="Level_6") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						
						String course_id=id_txt.getText();
						
										
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						
						
						 String query="DELETE from Third_year where course_id=?";
						 PreparedStatement gett=connection.prepareStatement(query);
						 
						 gett.setString(1,course_id);
						 gett.executeUpdate();
						 
						 JOptionPane.showMessageDialog(null, "Course Sucessfully Deleted");
						 connection.close();
					}
				}catch(ClassNotFoundException a) {
					System.out.println(a);
					
				}catch(SQLException ex) {
					System.out.println(ex);
					
					
				}
					
					
				}
		});
		btnNewButton.setBounds(92, 165, 85, 21);
		panel_1.add(btnNewButton);
		
		
	}
}
