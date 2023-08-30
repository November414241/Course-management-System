package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

public class AddCourse {

	private JFrame frame;
	private JTextField courseinput;
	private JTextField batchtxt;
	private JTextField seattxt;
	private JTextField module1txt;
	private JTextField moduletxt2;
	private JTextField moduletxt3;
	private JTextField tutortxt1;
	private JTextField tutortxt2;
	private JTextField tutortxt3;
	private JTextField moduletxt4;
	private JTextField tutortxt4;
	private JTextField courseid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse window = new AddCourse();
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
	public AddCourse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 995, 605);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setForeground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 981, 82);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add Course");
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(23, 10, 126, 62);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBounds(0, 92, 981, 466);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Name");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(88, 10, 92, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBatch.setBounds(373, 10, 92, 23);
		panel_1.add(lblBatch);
		
		JLabel lblNewLabel_1_1 = new JLabel("No. of Seats");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(682, 10, 92, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblModule = new JLabel("Module 1");
		lblModule.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModule.setBounds(88, 151, 92, 23);
		panel_1.add(lblModule);
		
		JLabel lblModule_2 = new JLabel("Module 2");
		lblModule_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModule_2.setBounds(360, 151, 92, 23);
		panel_1.add(lblModule_2);
		
		JLabel lblModule_2_1 = new JLabel("Module 3");
		lblModule_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModule_2_1.setBounds(599, 151, 92, 23);
		panel_1.add(lblModule_2_1);
		
		JLabel lblModuleTutor = new JLabel("Module1 Tutor");
		lblModuleTutor.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModuleTutor.setBounds(88, 260, 104, 23);
		panel_1.add(lblModuleTutor);
		
		JLabel lblModuleTutor_3 = new JLabel("Module2 Tutor");
		lblModuleTutor_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModuleTutor_3.setBounds(360, 260, 104, 23);
		panel_1.add(lblModuleTutor_3);
		
		JLabel lblModuleTutor_1 = new JLabel("Module3 Tutor");
		lblModuleTutor_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModuleTutor_1.setBounds(599, 260, 104, 23);
		panel_1.add(lblModuleTutor_1);
		
		courseinput = new JTextField();
		courseinput.setBackground(new Color(255, 255, 240));
		courseinput.setBounds(88, 43, 146, 19);
		panel_1.add(courseinput);
		courseinput.setColumns(10);
		
		batchtxt = new JTextField();
		batchtxt.setColumns(10);
		batchtxt.setBounds(373, 35, 146, 19);
		panel_1.add(batchtxt);
		
		seattxt = new JTextField();
		seattxt.setColumns(10);
		seattxt.setBounds(682, 35, 146, 19);
		panel_1.add(seattxt);
		
		module1txt = new JTextField();
		module1txt.setColumns(10);
		module1txt.setBounds(88, 184, 129, 19);
		panel_1.add(module1txt);
		
		moduletxt2 = new JTextField();
		moduletxt2.setColumns(10);
		moduletxt2.setBounds(360, 184, 129, 19);
		panel_1.add(moduletxt2);
		
		moduletxt3 = new JTextField();
		moduletxt3.setColumns(10);
		moduletxt3.setBounds(599, 184, 129, 19);
		panel_1.add(moduletxt3);
		
		tutortxt1 = new JTextField();
		tutortxt1.setColumns(10);
		tutortxt1.setBounds(88, 314, 129, 19);
		panel_1.add(tutortxt1);
		
		tutortxt2 = new JTextField();
		tutortxt2.setColumns(10);
		tutortxt2.setBounds(360, 314, 129, 19);
		panel_1.add(tutortxt2);
		
		tutortxt3 = new JTextField();
		tutortxt3.setColumns(10);
		tutortxt3.setBounds(599, 314, 129, 19);
		panel_1.add(tutortxt3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Level", "Level_4", "Level_5", "Level_6"}));
		comboBox.setBounds(373, 83, 272, 21);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(comboBox.getSelectedItem().toString()=="Level_4") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
							
						String course_id=courseid.getText();	
						String course=courseinput.getText();
						String batch=batchtxt.getText();
						String seat=seattxt.getText();
						String module1=module1txt.getText();
						String module2=moduletxt2.getText();
						String module3=moduletxt3.getText();					
						String module4=moduletxt4.getText();
						String tutor1=tutortxt1.getText();
						String tutor2=tutortxt2.getText();
						String tutor3=tutortxt3.getText();
						String tutor4=tutortxt4.getText();
									
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
					
					
					 String query="INSERT INTO First_year(course_id,course,batch,no_of_seats,module1,module2,module3,module4,module_tutor1,module_tutor2,module_tutor3,module_tutor4) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
					 PreparedStatement gett=connection.prepareStatement(query);
					 gett.setString(1,course_id);
					 gett.setString(2,course);
					 gett.setString(3,batch);
					 gett.setString(4,seat);
					 gett.setString(5,module1);
					 gett.setString(6,module2);
					 gett.setString(7,module3);
					 gett.setString(8,module4);
					 gett.setString(9,tutor1);
					 gett.setString(10,tutor2);
					 gett.setString(11,tutor3);
					 gett.setString(12,tutor4);
					 
					 gett.executeUpdate();
					 
					 JOptionPane.showMessageDialog(null, "Course Sucessfully Added");
					 connection.close();

					}else if(comboBox.getSelectedItem().toString()=="Level_5") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						String course_id=courseid.getText();		
						String course=courseinput.getText();
						String batch=batchtxt.getText();
						String seat=seattxt.getText();
						String module1=module1txt.getText();
						String module2=moduletxt2.getText();
						String module3=moduletxt3.getText();					
						String module4=moduletxt4.getText();
						String tutor1=tutortxt1.getText();
						String tutor2=tutortxt2.getText();
						String tutor3=tutortxt3.getText();
						String tutor4=tutortxt4.getText();
										
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);					
						 String query="INSERT INTO Second_year(course_id,course,batch,no_of_seats,module1,module2,module3,module4,module_tutor1,module_tutor2,module_tutor3,module_tutor4) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
						 PreparedStatement gett=connection.prepareStatement(query);
						 gett.setString(1,course_id);
						 gett.setString(2,course);
						 gett.setString(3,batch);
						 gett.setString(4,seat);
						 gett.setString(5,module1);
						 gett.setString(6,module2);
						 gett.setString(7,module3);
						 gett.setString(8,module4);
						 gett.setString(9,tutor1);
						 gett.setString(10,tutor2);
						 gett.setString(11,tutor3);
						 gett.setString(12,tutor4);					 
						 gett.executeUpdate();						 
						 JOptionPane.showMessageDialog(null, "Course Sucessfully Added");
						 connection.close();						
					}else if(comboBox.getSelectedItem().toString()=="Level_6") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						String course_id=courseid.getText();		
						String course=courseinput.getText();
						String batch=batchtxt.getText();
						String seat=seattxt.getText();
						String module1=module1txt.getText();
						String module2=moduletxt2.getText();
						String module3=moduletxt3.getText();					
						String module4=moduletxt4.getText();
						String tutor1=tutortxt1.getText();
						String tutor2=tutortxt2.getText();
						String tutor3=tutortxt3.getText();
						String tutor4=tutortxt4.getText();
									
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						
					
					 String query="INSERT INTO Third_year(course_id,course,batch,no_of_seats,module1,module2,module3,module4,module_tutor1,module_tutor2,module_tutor3,module_tutor4) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
					 PreparedStatement gett=connection.prepareStatement(query);
					 gett.setString(1,course_id);
					 gett.setString(2,course);
					 gett.setString(3,batch);
					 gett.setString(4,seat);
					 gett.setString(5,module1);
					 gett.setString(6,module2);
					 gett.setString(7,module3);
					 gett.setString(8,module4);
					 gett.setString(9,tutor1);
					 gett.setString(10,tutor2);
					 gett.setString(11,tutor3);
					 gett.setString(12,tutor4);					 
					 gett.executeUpdate();					 
					 JOptionPane.showMessageDialog(null, "Course Sucessfully Added");
					 connection.close();
					}
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
			
			
			
			
		}
			
		});
		btnNewButton.setBounds(826, 428, 109, 28);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
		
		moduletxt4 = new JTextField();
		moduletxt4.setColumns(10);
		moduletxt4.setBounds(826, 184, 129, 19);
		panel_1.add(moduletxt4);
		
		JLabel lblModule_2_1_1 = new JLabel("Module 4");
		lblModule_2_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModule_2_1_1.setBounds(824, 151, 92, 23);
		panel_1.add(lblModule_2_1_1);
		
		JLabel lblModuleTutor_1_1 = new JLabel("Module4 Tutor");
		lblModuleTutor_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblModuleTutor_1_1.setBounds(826, 260, 104, 23);
		panel_1.add(lblModuleTutor_1_1);
		
		tutortxt4 = new JTextField();
		tutortxt4.setColumns(10);
		tutortxt4.setBounds(826, 314, 129, 19);
		panel_1.add(tutortxt4);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courseinput.setText("");
				batchtxt.setText("");
				seattxt.setText("");
				module1txt.setText("");
				moduletxt2.setText("");
				moduletxt3.setText("");
				moduletxt4.setText("");
				tutortxt1.setText("");
				tutortxt2.setText("");
				tutortxt3.setText("");
				tutortxt4.setText("");
				courseid.setText("");
				
				
				
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(682, 428, 109, 28);
		panel_1.add(btnReset);
		
		JLabel lblCourseId = new JLabel("Course Id");
		lblCourseId.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCourseId.setBounds(88, 81, 92, 23);
		panel_1.add(lblCourseId);
		
		courseid = new JTextField();
		courseid.setColumns(10);
		courseid.setBounds(88, 114, 146, 19);
		panel_1.add(courseid);
	}
}
