package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
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

public class EditCourse {

	private JFrame frame;
	private JTextField id_txt;
	private JTextField course_txt;
	private JTextField seat_txt;
	private JTextField Batch_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCourse window = new EditCourse();
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
	public EditCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 420, 484);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(59, 21, 284, 46);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Courses");
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 10, 169, 26);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 250, 250));
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(129, 13, 103, 21);
		panel.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Level", "Level_4", "Level_5", "Level_6"}));
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(59, 92, 284, 329);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Course ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(26, 10, 88, 19);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(26, 63, 134, 19);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total Seats Available");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(26, 132, 159, 19);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Batch");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(26, 203, 159, 19);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		id_txt = new JTextField();
		id_txt.setBackground(new Color(255, 250, 250));
		id_txt.setBorder(null);
		id_txt.setBounds(26, 28, 183, 19);
		panel_1.add(id_txt);
		id_txt.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 51, 189, 2);
		panel_1.add(separator);
		
		course_txt = new JTextField();
		course_txt.setBorder(null);
		course_txt.setBounds(26, 81, 189, 25);
		panel_1.add(course_txt);
		course_txt.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 109, 189, 2);
		panel_1.add(separator_1);
		
		seat_txt = new JTextField();
		seat_txt.setBorder(null);
		seat_txt.setBounds(18, 151, 191, 25);
		panel_1.add(seat_txt);
		seat_txt.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(26, 181, 189, 2);
		panel_1.add(separator_2);
		
		Batch_txt = new JTextField();
		Batch_txt.setBorder(null);
		Batch_txt.setBounds(26, 220, 191, 25);
		panel_1.add(Batch_txt);
		Batch_txt.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(26, 250, 189, 2);
		panel_1.add(separator_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(comboBox.getSelectedItem().toString()=="Level_4") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						
					String course_id=id_txt.getText();
					String course=course_txt.getText();
					String seat=seat_txt.getText();
					String batch=Batch_txt.getText();				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="UPDATE first_year set course=?, batch=?,no_of_seats=? where course_id=?";
					 PreparedStatement gett=connection.prepareStatement(query);
					 
					 gett.setString(1,course);
					 gett.setString(2, batch);
					 gett.setString(3,seat);
					 gett.setString(4,course_id);
					 

					 
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Course Sucessfully Updataed");
					 connection.close();

					}else if(comboBox.getSelectedItem().toString()=="Level_5") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						
						String course_id=id_txt.getText();
						String course=course_txt.getText();
						String seat=seat_txt.getText();
						String batch=Batch_txt.getText();	
									
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					
					String query="UPDATE Second_year set course=?, batch=?,no_of_seats=? where course_id=?";
					 PreparedStatement gett=connection.prepareStatement(query);
					 gett.setString(1,course);
					 gett.setString(2, batch);
					 gett.setString(3,seat);
					 gett.setString(4,course_id);
					 
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Course Sucessfully Updated");
					 connection.close();
						
						
					}else if(comboBox.getSelectedItem().toString()=="Level_6") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						
						String course_id=id_txt.getText();
						String course=course_txt.getText();
						String seat=seat_txt.getText();
						String batch=Batch_txt.getText();	
									
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					
					String query="UPDATE Third_year set course=?, batch=?,no_of_seats=? where course_id=?";
					 PreparedStatement gett=connection.prepareStatement(query);
					 gett.setString(1,course);
					 gett.setString(2, batch);
					 gett.setString(3,seat);
					 gett.setString(4,course_id);
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Course Sucessfully Updated");
					 connection.close();
					}
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
				
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setBounds(72, 298, 85, 21);
		panel_1.add(btnNewButton);
	}
}
