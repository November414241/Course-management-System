package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField emailPart;
	private JPasswordField passwordPart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBackground(new Color(0, 139, 139));
		frame.setResizable(false);
		frame.setBounds(100, 100, 548, 393);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(10, 10, 514, 63);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Login Panel\r\n");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblNewLabel.setBounds(113, 10, 391, 43);
		panel.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup();
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Arial", Font.BOLD, 12));
		btnBack.setBackground(new Color(95, 158, 160));
		btnBack.setBounds(0, 0, 85, 21);
		panel.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(10, 83, 514, 243);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(240, 255, 240));
		comboBox.setBackground(new Color(0, 139, 139));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select user mode", "Student", "Teacher", "Admin"}));
		comboBox.setBounds(184, 22, 171, 21);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(120, 62, 54, 21);
		panel_1.add(lblNewLabel_1);
		
		emailPart = new JTextField();
		emailPart.setForeground(new Color(245, 255, 250));
		emailPart.setBackground(new Color(0, 128, 128));
		emailPart.setBorder(null);
		emailPart.setBounds(207, 61, 248, 22);
		panel_1.add(emailPart);
		emailPart.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(207, 85, 248, 2);
		panel_1.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(245, 255, 250));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(120, 120, 77, 21);
		panel_1.add(lblNewLabel_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(207, 139, 248, 2);
		panel_1.add(separator_1);
		
		passwordPart = new JPasswordField();
		passwordPart.setForeground(new Color(255, 255, 255));
		passwordPart.setBackground(new Color(0, 128, 128));
		passwordPart.setBorder(null);
		passwordPart.setBounds(207, 112, 248, 22);
		panel_1.add(passwordPart);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_email=emailPart.getText();
				String user_password=passwordPart.getText();
;				String url="jdbc:mysql://localhost/SignupData";
				String username="root";
				String password="";
				
				try {
					if(comboBox.getSelectedItem().toString()=="Student") {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					String query="SELECT *FROM Student where email_or_PhoneNumber='"+user_email+"'and password='"+user_password+"'";
					
					Statement statement=connection.createStatement();
					ResultSet set = statement.executeQuery(query);
					
					if(set.next()) {
						new Dashboard("Student");
						
						frame.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Password Incorrect !!");
					}
					
					connection.close();
					
					}else if(comboBox.getSelectedItem().toString()=="Teacher") {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						String query="SELECT *FROM Teacher where email_or_PhoneNumber='"+user_email+"'and password='"+user_password+"'";
						Statement statement=connection.createStatement();
						ResultSet set = statement.executeQuery(query);
						
						if(set.next()) {
							new Dashboard("Teacher");
							frame.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "Password Incorrect !!");
						}
						
						connection.close();
						
					}else if(comboBox.getSelectedItem().toString()=="Admin") {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						String query="SELECT *FROM Admin where email_or_PhoneNumber='"+user_email+"'and password='"+user_password+"'";
						Statement statement=connection.createStatement();
						ResultSet set = statement.executeQuery(query);
						
						if(set.next()) {
							
							new Dashboard("Admin");
							
							frame.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "Password Incorrect !!");
						}
						
						connection.close();
						
					}
				}catch(ClassNotFoundException t) {
					System.out.println(t);
					
				}catch(SQLException ex) {
					System.out.println(ex);
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setBounds(419, 212, 85, 21);
		panel_1.add(btnNewButton);
	}
}
