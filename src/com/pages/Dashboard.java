package com.pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Dashboard {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable dataofstudent;
	private String userType;
	private JTextField recent_user;
	private JTextField recent_email_user;
	private JTextField recent_phone_number;
	private JTable enrolltable;
	private JTextField loginuser_txt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard("Teacher");
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
	public Dashboard(String userType) {
		
		this.userType=userType;
		
		initialize();
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(255, 250, 250));
		frame.setResizable(false);
		frame.setBounds(100, 100, 1192, 655);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(218, 0, 968, 633);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 968, 633);
		panel2.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel DashboardPanel = new JPanel();
		DashboardPanel.setBackground(new Color(173, 216, 230));
		DashboardPanel.setForeground(Color.GRAY);
		layeredPane.add(DashboardPanel, "name_546707741475600");
		DashboardPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -12, 968, 88);
		panel.setBackground(new Color(95, 158, 160));
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		DashboardPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Dashboard");
		lblNewLabel_3.setForeground(new Color(47, 79, 79));
		lblNewLabel_3.setBackground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 29, 348, 49);
		panel.add(lblNewLabel_3);
		
		JPanel data_panel = new JPanel();
		data_panel.setBounds(26, 92, 806, 512);
		data_panel.setBackground(new Color(135, 206, 235));
		data_panel.setForeground(new Color(0, 128, 128));
		DashboardPanel.add(data_panel);
		data_panel.setLayout(null);
		
		JPanel score_course_panel = new JPanel();
		score_course_panel.setBounds(26, 20, 203, 116);
		data_panel.add(score_course_panel);
		score_course_panel.setBackground(new Color(95, 158, 160));
		score_course_panel.setBorder(UIManager.getBorder("CheckBox.border"));
		score_course_panel.setLayout(null);
		
		JLabel txt_course = new JLabel("Total Courses");
		txt_course.setForeground(new Color(0, 0, 0));
		txt_course.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txt_course.setBounds(40, 10, 102, 13);
		score_course_panel.add(txt_course);
		
		JTextArea Course_data = new JTextArea();
		Course_data.setLineWrap(true);
		Course_data.setBackground(new Color(95, 158, 160));
		Course_data.setFont(new Font("Arial", Font.PLAIN, 40));
		Course_data.setBounds(60, 33, 102, 77);
		score_course_panel.add(Course_data);
		Course_data.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					String url="jdbc:mysql://localhost/add_courses";
					String username="root";
					String password="";						
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);		
					String query="SELECT COUNT(1) as NumberofRows FROM "+"first_year";
					Statement statement=connection.createStatement();		
//				
					
					ResultSet set = statement.executeQuery(query);
					set.next();
					int n=set.getInt("NumberofRows");
					String data=String.valueOf(n);
					System.out.println(data);
//					System.out.println(set.getInt("NumberofRows"));
							
					Course_data.setText(data);					 
					connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
			}
		});
		Course_data.setEditable(false);
		
		JPanel score_course_panel_1 = new JPanel();
		score_course_panel_1.setBounds(296, 20, 203, 116);
		data_panel.add(score_course_panel_1);
		score_course_panel_1.setBackground(new Color(95, 158, 160));
		score_course_panel_1.setLayout(null);
		score_course_panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		
		JLabel lblNewLabel_9_1 = new JLabel("Total Students");
		lblNewLabel_9_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_9_1.setBounds(40, 10, 102, 13);
		score_course_panel_1.add(lblNewLabel_9_1);
		
		JTextArea Student_data = new JTextArea();
		Student_data.setFont(new Font("Arial", Font.PLAIN, 40));
		Student_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					String url="jdbc:mysql://localhost/studentdatabase";
					String username="root";
					String password="";						
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);		
					String query="SELECT COUNT(1) as NumberofRows FROM "+"student_table";
					Statement statement=connection.createStatement();		
//				
					
					ResultSet set = statement.executeQuery(query);
					set.next();
					int n=set.getInt("NumberofRows");
					String data=String.valueOf(n);
					System.out.println(data);
//					System.out.println(set.getInt("NumberofRows"));
							
					Student_data.setText(data);					 
					connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
								
			}
		});
		Student_data.setBackground(new Color(95, 158, 160));
		Student_data.setEditable(false);
		Student_data.setBounds(60, 33, 102, 77);
		score_course_panel_1.add(Student_data);
		
		JPanel score_course_panel_1_1 = new JPanel();
		score_course_panel_1_1.setBounds(558, 20, 203, 116);
		data_panel.add(score_course_panel_1_1);
		score_course_panel_1_1.setBackground(new Color(95, 158, 160));
		score_course_panel_1_1.setLayout(null);
		score_course_panel_1_1.setBorder(UIManager.getBorder("CheckBox.border"));
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Total Teachers");
		lblNewLabel_9_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_9_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_9_1_1.setBounds(40, 10, 102, 13);
		score_course_panel_1_1.add(lblNewLabel_9_1_1);
		
		JTextArea Teacher_data = new JTextArea();
		Teacher_data.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					
					String url="jdbc:mysql://localhost/tutorsdatabase";
					String username="root";
					String password="";						
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);		
					String query="SELECT COUNT(1) as NumberofRows FROM "+"tutortable";
					Statement statement=connection.createStatement();		
//				
					
					ResultSet set = statement.executeQuery(query);
					set.next();
					int n=set.getInt("NumberofRows");
					String data=String.valueOf(n);
					System.out.println(data);
//					System.out.println(set.getInt("NumberofRows"));
							
					Teacher_data.setText(data);					 
					connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
			}
		});
		Teacher_data.setFont(new Font("Arial", Font.PLAIN, 40));
		Teacher_data.setBackground(new Color(95, 158, 160));
		Teacher_data.setEditable(false);
		Teacher_data.setBounds(66, 29, 102, 77);
		score_course_panel_1_1.add(Teacher_data);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 206, 209));
		panel_10.setBounds(57, 179, 704, 302);
		data_panel.add(panel_10);
		panel_10.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(new Color(135, 206, 250));
		scrollPane_3.setBounds(10, 10, 684, 282);
		panel_10.add(scrollPane_3);
		
		enrolltable = new JTable();
		scrollPane_3.setViewportView(enrolltable);
		enrolltable.setForeground(new Color(255, 250, 250));
		enrolltable.setBackground(new Color(0, 139, 139));
		enrolltable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Student Name", "Email", "Course"
			}
		));
		
		JButton enrollbtn = new JButton("Enroll");
		enrollbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new enroll();
				frame.setVisible(true);
			}
		});
		enrollbtn.setFont(new Font("Arial", Font.PLAIN, 12));
		enrollbtn.setBackground(new Color(135, 206, 250));
		enrollbtn.setBounds(850, 100, 93, 30);
		DashboardPanel.add(enrollbtn);
		
		JButton btnViewEnroll = new JButton("View Enroll");
		btnViewEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					String url="jdbc:mysql://localhost/enroll_database";
					String username="root";
					String password="";
					
								
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="SELECT * from enroll_student";
					Statement statement=connection.createStatement();
					
					DefaultTableModel tblmodel=(DefaultTableModel)enrolltable.getModel();
					tblmodel.setRowCount(0);
					 ResultSet set = statement.executeQuery(query);
					 while(set.next()) {
					 String id=set.getString("id");
					 String name=set.getString("Student_name");
					 String email=set.getString("Email");
					 String courses=set.getString("Course");
					 
					 String tableData[]= {id,name,email,courses};	 	 
				 	 tblmodel.addRow(tableData);
				 	}
					 connection.close();
				
		}catch(ClassNotFoundException a) {
			System.out.println(a);
			
		}catch(SQLException ex) {
			System.out.println(ex);
			
			
		}
		
		}
				
			
		});
		btnViewEnroll.setFont(new Font("Arial", Font.PLAIN, 10));
		btnViewEnroll.setBackground(new Color(135, 206, 250));
		btnViewEnroll.setBounds(850, 150, 93, 30);
		DashboardPanel.add(btnViewEnroll);
		
		JPanel Coursespanel = new JPanel();
		Coursespanel.setBackground(new Color(176, 224, 230));
		layeredPane.add(Coursespanel, "name_547006867400800");
		Coursespanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBounds(0, 0, 968, 76);
		Coursespanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Courses");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_10.setBounds(10, 24, 99, 42);
		panel_1.add(lblNewLabel_10);
		
		JButton btn_add_course = new JButton("Add Course");
		btn_add_course.setForeground(new Color(255, 250, 250));
		btn_add_course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click");
				new AddCourse();
				frame.setVisible(true);
				
				
					
				
			}
		});
		btn_add_course.setVisible(false);
		btn_add_course.setBackground(new Color(0, 128, 128));
		btn_add_course.setBounds(10, 100, 101, 21);
		Coursespanel.add(btn_add_course);
		
		JButton btn_edit_course = new JButton("Edit Course");
		btn_edit_course.setForeground(new Color(255, 250, 250));
		btn_edit_course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditCourse();
				frame.setVisible(true);
			}
		});
		btn_edit_course.setVisible(false);
		btn_edit_course.setBackground(new Color(0, 128, 128));
		btn_edit_course.setBounds(148, 100, 101, 21);
		Coursespanel.add(btn_edit_course);
		
		JButton btn_delete_course = new JButton("Delete Course");
		btn_delete_course.setForeground(new Color(255, 250, 250));
		btn_delete_course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteCourse();
				frame.setVisible(true);
			}
		});
		btn_delete_course.setVisible(false);
		btn_delete_course.setBackground(new Color(0, 128, 128));
		btn_delete_course.setBounds(281, 100, 116, 21);
		Coursespanel.add(btn_delete_course);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 128, 128));
		panel_5.setBounds(45, 170, 748, 380);
		Coursespanel.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 728, 360);
		panel_5.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(248, 248, 255));
		table.setSurrendersFocusOnKeystroke(true);
		table.setBackground(new Color(0, 139, 139));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "course_id", "course", "batch", "no_of_seats"
			}
		));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 250, 250));
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Levels", "Level 4", "Level 5", "Level 6"}));
		comboBox.setBounds(468, 100, 170, 21);
		Coursespanel.add(comboBox);
		
		JButton btnNewButton_3 = new JButton("View Data");
		btnNewButton_3.setForeground(new Color(240, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 128, 128));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if(comboBox.getSelectedItem().toString()=="Level 4") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						
									
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						
						String query="SELECT * from first_year";
						Statement statement=connection.createStatement();
						
						DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
							tblmodel.setRowCount(0);
						 ResultSet set = statement.executeQuery(query);
						 while(set.next()) {
						 String id=set.getString("id");
						 String courseID=set.getString("course_id");
						 String courses=set.getString("course");
						 String year=set.getString("batch");
						 String noOfSeats=set.getString("no_of_seats");
						 String tableData[]= {id,courseID,courses,year,noOfSeats};	 	 
					 	 tblmodel.addRow(tableData);
					 }
					 
						 connection.close();

					}else if(comboBox.getSelectedItem().toString()=="Level 5") {
						 String url="jdbc:mysql://localhost/Add_Courses";
						 String username="root";
						 String password="";
						
									
						 Class.forName("com.mysql.cj.jdbc.Driver");
						 Connection connection=DriverManager.getConnection(url,username,password);
						
						 String query="SELECT * from second_year";
						 Statement statement=connection.createStatement();
						
						 DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
						 tblmodel.setRowCount(0);
						 ResultSet set = statement.executeQuery(query);
						 while(set.next()) {
						 String id=set.getString("id");
						 String courseID=set.getString("course_id");
						 String courses=set.getString("course");
						 String year=set.getString("batch");
						 String noOfSeats=set.getString("no_of_seats");
						 String tableData[]= {id,courseID,courses,year,noOfSeats};	 	 
					 	 tblmodel.addRow(tableData);
					 }
						connection.close();
						
						
					}else if(comboBox.getSelectedItem().toString()=="Level 6") {
						String url="jdbc:mysql://localhost/Add_Courses";
						String username="root";
						String password="";
						
									
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection=DriverManager.getConnection(url,username,password);
						
						String query="SELECT * from third_year";
						Statement statement=connection.createStatement();
						
						DefaultTableModel tblmodel=(DefaultTableModel)table.getModel();
						tblmodel.setRowCount(0);
						 ResultSet set = statement.executeQuery(query);
						 while(set.next()) {
						 String id=set.getString("id");
						 String courseID=set.getString("course_id");
						 String courses=set.getString("course");
						 String year=set.getString("batch");
						 String noOfSeats=set.getString("no_of_seats");
						 String tableData[]= {id,courseID,courses,year,noOfSeats};	 	 
					 	 tblmodel.addRow(tableData);
					 	}
						 connection.close();
					}
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBounds(679, 100, 110, 21);
		Coursespanel.add(btnNewButton_3);
		
		JPanel Tutors_panel = new JPanel();
		Tutors_panel.setBackground(new Color(176, 224, 230));
		layeredPane.add(Tutors_panel, "name_549572587256400");
		Tutors_panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_3.setBounds(0, 0, 968, 76);
		Tutors_panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Tutors");
		lblNewLabel_11.setForeground(new Color(255, 250, 250));
		lblNewLabel_11.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_11.setBounds(10, 33, 168, 41);
		panel_3.add(lblNewLabel_11);
		
		JButton add_tutors_btn = new JButton("Add Tutors");
		add_tutors_btn.setForeground(new Color(255, 250, 250));
		add_tutors_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddTutors();
				frame.setVisible(true);
			}
		});
		add_tutors_btn.setVisible(false);
		add_tutors_btn.setBackground(new Color(0, 128, 128));
		add_tutors_btn.setBounds(10, 93, 106, 21);
		Tutors_panel.add(add_tutors_btn);
		
		JButton edit_tutors_btn = new JButton("Edit Tutors");
		edit_tutors_btn.setForeground(new Color(255, 250, 250));
		edit_tutors_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditTutors();
				frame.setVisible(true);
			}
		});
		edit_tutors_btn.setVisible(false);
		edit_tutors_btn.setBackground(new Color(0, 128, 128));
		edit_tutors_btn.setBounds(190, 93, 106, 21);
		Tutors_panel.add(edit_tutors_btn);
		
		JButton delete_tutors_btn = new JButton("DeleteTutors");
		delete_tutors_btn.setForeground(new Color(255, 250, 250));
		delete_tutors_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteTutors();
				frame.setVisible(true);
			}
		});
		delete_tutors_btn.setVisible(false);
		delete_tutors_btn.setBackground(new Color(0, 128, 128));
		delete_tutors_btn.setBounds(349, 93, 116, 21);
		Tutors_panel.add(delete_tutors_btn);
		
		JPanel panel_6 = new JPanel();
		panel_6.setForeground(new Color(0, 139, 139));
		panel_6.setBackground(new Color(0, 128, 128));
		panel_6.setBounds(35, 154, 747, 424);
		Tutors_panel.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 727, 404);
		panel_6.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setShowGrid(false);
		table_1.setGridColor(new Color(0, 128, 128));
		table_1.setSelectionBackground(new Color(240, 255, 255));
		table_1.setForeground(new Color(240, 255, 255));
		table_1.setBackground(new Color(0, 128, 128));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Phone Number"
			}
		));
		
		JButton TutorViewBtn = new JButton("View Data");
		TutorViewBtn.setForeground(new Color(255, 250, 250));
		TutorViewBtn.setBackground(new Color(0, 128, 128));
		TutorViewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
						
					String url="jdbc:mysql://localhost/tutorsdatabase";
					String username="root";
					String password="";
					
								
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="SELECT * from tutortable";
					Statement statement=connection.createStatement();
					
					DefaultTableModel tmodel=(DefaultTableModel)table_1.getModel();
					tmodel.setRowCount(0);
					 ResultSet set = statement.executeQuery(query);
					 while(set.next()) {
						 String id=set.getString("ID");
						 String tutorname=set.getString("Tutor_name");
						 String Temail=set.getString("email");
						 String number=set.getString("phone_number");	 
						 String tableData[]= {id,tutorname,Temail,number};	 	 
					 	 tmodel.addRow(tableData);
					 }
					 
						 connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
							
			}
		});
		TutorViewBtn.setBounds(559, 93, 95, 21);
		Tutors_panel.add(TutorViewBtn);
		
		JPanel student_panel = new JPanel();
		student_panel.setBackground(new Color(176, 224, 230));
		layeredPane.add(student_panel, "name_549663269293100");
		student_panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(95, 158, 160));
		panel_4.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_4.setBounds(0, 0, 958, 86);
		student_panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Students");
		lblNewLabel_12.setForeground(new Color(255, 250, 250));
		lblNewLabel_12.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblNewLabel_12.setBounds(10, 20, 124, 56);
		panel_4.add(lblNewLabel_12);
		
		JButton add_student_btn = new JButton("Add Students");
		add_student_btn.setForeground(new Color(255, 250, 250));
		add_student_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStudent();
				frame.setVisible(true);
			}
		});
		add_student_btn.setVisible(false);
		add_student_btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		add_student_btn.setBackground(new Color(0, 128, 128));
		add_student_btn.setBounds(10, 115, 111, 21);
		student_panel.add(add_student_btn);
		
		JButton edit_student_btn = new JButton("Edit Students");
		edit_student_btn.setForeground(new Color(255, 250, 250));
		edit_student_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStudent();
				frame.setVisible(true);
			}
		});
		edit_student_btn.setVisible(false);
		edit_student_btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		edit_student_btn.setBackground(new Color(0, 128, 128));
		edit_student_btn.setBounds(153, 115, 111, 21);
		student_panel.add(edit_student_btn);
		
		JButton delete_student_btn = new JButton("Delete Students");
		delete_student_btn.setForeground(new Color(255, 250, 250));
		delete_student_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStudent();
				frame.setVisible(true);
			}
		});
		delete_student_btn.setVisible(false);
		delete_student_btn.setFont(new Font("Tahoma", Font.PLAIN, 10));
		delete_student_btn.setBackground(new Color(0, 128, 128));
		delete_student_btn.setBounds(300, 115, 140, 21);
		student_panel.add(delete_student_btn);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 128, 128));
		panel_7.setBounds(20, 146, 791, 347);
		student_panel.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 771, 327);
		panel_7.add(scrollPane_2);
		
		dataofstudent = new JTable();
		scrollPane_2.setViewportView(dataofstudent);
		dataofstudent.setForeground(new Color(240, 255, 255));
		dataofstudent.setBackground(new Color(0, 128, 128));
		dataofstudent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Student Name", "Email", "Phone Number", "Course"
			}
		));
		dataofstudent.getColumnModel().getColumn(1).setPreferredWidth(110);
		dataofstudent.getColumnModel().getColumn(2).setPreferredWidth(103);
		dataofstudent.getColumnModel().getColumn(3).setPreferredWidth(110);
		dataofstudent.getColumnModel().getColumn(4).setPreferredWidth(121);
		
		JButton btnNewButton_2_1_2 = new JButton("View Details");
		btnNewButton_2_1_2.setForeground(new Color(255, 250, 250));
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					String url="jdbc:mysql://localhost/StudentDatabase";
					String username="root";
					String password="";
					
								
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection(url,username,password);
					
					String query="SELECT * from Student_table";
					Statement statement=connection.createStatement();
					
					DefaultTableModel tmodel=(DefaultTableModel)dataofstudent.getModel();
					tmodel.setRowCount(0);
					 ResultSet set = statement.executeQuery(query);
					 while(set.next()) {
						 String id=set.getString("ID");
						 String student_name=set.getString("student_name");
						 String student_email=set.getString("email");
						 String student_number=set.getString("phone_number");
						 String course=set.getString("course");
						 String tableData[]= {id,student_name,student_email,student_number,course};	 	 
					 	 tmodel.addRow(tableData);
					 }
					 
						 connection.close();
			}catch(ClassNotFoundException a) {
				System.out.println(a);
				
			}catch(SQLException ex) {
				System.out.println(ex);
				
				
			}
			}
		});
		btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2_1_2.setBackground(new Color(0, 128, 128));
		btnNewButton_2_1_2.setBounds(488, 115, 111, 21);
		student_panel.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_2_1_2_1 = new JButton("View progress");
		btnNewButton_2_1_2_1.setForeground(new Color(255, 250, 250));
		btnNewButton_2_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewProgress();
				frame.setVisible(true);
				
			}
		});
		
		btnNewButton_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2_1_2_1.setBackground(new Color(0, 128, 128));
		btnNewButton_2_1_2_1.setBounds(640, 116, 111, 21);
		student_panel.add(btnNewButton_2_1_2_1);
		
		JPanel mail_pannel = new JPanel();
		layeredPane.add(mail_pannel, "name_549704933651800");
		mail_pannel.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("This is Mail pannel");
		lblNewLabel_6.setBounds(302, 123, 217, 124);
		mail_pannel.add(lblNewLabel_6);
		
		JPanel Setting_pannel = new JPanel();
		Setting_pannel.setBackground(new Color(176, 224, 230));
		layeredPane.add(Setting_pannel, "name_549747518089000");
		Setting_pannel.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(95, 158, 160));
		panel_8.setBounds(0, 0, 968, 74);
		Setting_pannel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Setting");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 23, 104, 29);
		panel_8.add(lblNewLabel);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(135, 206, 235));
		panel_9.setBounds(10, 84, 742, 518);
		Setting_pannel.add(panel_9);
		panel_9.setLayout(null);
		
		JButton reportbtn = new JButton("Create a Student report");
		reportbtn.setBackground(new Color(128, 128, 128));
		reportbtn.setBorder(new CompoundBorder());
		reportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println("click");
				new StudentResult();
				frame.setVisible(true);
			}
		});
		
		reportbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		reportbtn.setBounds(10, 10, 170, 21);
		panel_9.add(reportbtn);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(33, 141, 89, 21);
		panel_9.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(303, 141, 89, 21);
		panel_9.add(lblNewLabel_1_1);
		
		recent_user = new JTextField();
		recent_user.setBounds(33, 184, 116, 19);
		panel_9.add(recent_user);
		recent_user.setColumns(10);
		
		recent_email_user = new JTextField();
		recent_email_user.setColumns(10);
		recent_email_user.setBounds(302, 172, 170, 19);
		panel_9.add(recent_email_user);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(33, 236, 116, 21);
		panel_9.add(lblNewLabel_1_2);
		
		recent_phone_number = new JTextField();
		recent_phone_number.setColumns(10);
		recent_phone_number.setBounds(33, 279, 116, 19);
		panel_9.add(recent_phone_number);
		
		JLabel lblNewLabel_4 = new JLabel("Profile");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 92, 150, 39);
		panel_9.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Help & Service");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 323, 150, 27);
		panel_9.add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 360, 170, 2);
		panel_9.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 119, 116, 2);
		panel_9.add(separator_1);
		
		JLabel lblNewLabel_7 = new JLabel("Guidelines for Student ?");
		lblNewLabel_7.setForeground(new Color(0, 128, 128));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 372, 170, 21);
		panel_9.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Provide feedback if any any technical error");
		lblNewLabel_7_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_7_1.setBounds(10, 403, 260, 21);
		panel_9.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Contact Us");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(447, 323, 112, 27);
		panel_9.add(lblNewLabel_5_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(443, 360, 205, 2);
		panel_9.add(separator_1_1);
		
		JLabel lblNewLabel_13 = new JLabel("Naxal Bhagawati Marga,\r\nKathmandu, Nepal");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(447, 369, 248, 27);
		panel_9.add(lblNewLabel_13);
		
		JLabel lblNewLabel_13_1 = new JLabel("+977 9801022637\r\n\r\n");
		lblNewLabel_13_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_13_1.setBounds(447, 407, 102, 27);
		panel_9.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_13_1_1 = new JLabel("+977 01-5970120");
		lblNewLabel_13_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_13_1_1.setBounds(593, 407, 102, 27);
		panel_9.add(lblNewLabel_13_1_1);
		
		JLabel lblNewLabel_13_2 = new JLabel("info@heraldcollege.edu.np");
		lblNewLabel_13_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_13_2.setBounds(447, 450, 248, 27);
		panel_9.add(lblNewLabel_13_2);
		
		JPanel logout_pannel = new JPanel();
		logout_pannel.setBackground(new Color(176, 224, 230));
		layeredPane.add(logout_pannel, "name_549885196657200");
		logout_pannel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Log_out section");
		lblNewLabel_8.setBounds(278, 286, 45, 13);
		logout_pannel.add(lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(0, 0, 219, 643);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Course Management System");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 22, 209, 37);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(DashboardPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				
								
				
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(21, 177, 176, 37);
		panel_2.add(btnNewButton);
		
		JButton btnCourse = new JButton("Courses");
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Coursespanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnCourse.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCourse.setBackground(Color.LIGHT_GRAY);
		btnCourse.setBounds(21, 243, 176, 37);
		panel_2.add(btnCourse);
		
		JButton btnTutors = new JButton("Tutors");
		btnTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Tutors_panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnTutors.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTutors.setBackground(Color.LIGHT_GRAY);
		btnTutors.setBounds(21, 317, 176, 37);
		panel_2.add(btnTutors);
		
		JButton btnStudents = new JButton("Students");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(student_panel);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				
			}
		});
		btnStudents.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnStudents.setBackground(Color.LIGHT_GRAY);
		btnStudents.setBounds(21, 389, 176, 37);
		panel_2.add(btnStudents);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Setting_pannel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSettings.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSettings.setBackground(Color.LIGHT_GRAY);
		btnSettings.setBounds(21, 460, 176, 37);
		panel_2.add(btnSettings);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.setVisible(false);
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setBounds(21, 525, 176, 37);
		panel_2.add(btnLogout);
		
		loginuser_txt = new JTextField();
		loginuser_txt.setForeground(new Color(47, 79, 79));
		loginuser_txt.setFont(new Font("Tahoma", Font.BOLD, 20));
		loginuser_txt.setEditable(false);
		loginuser_txt.setBorder(null);
		loginuser_txt.setBackground(new Color(0, 139, 139));
		loginuser_txt.setBounds(36, 88, 161, 46);
		panel_2.add(loginuser_txt);
		loginuser_txt.setColumns(10);
		if(userType.equals("Admin")) {
			btn_add_course.setVisible(true);
			btn_edit_course.setVisible(true);
			btn_delete_course.setVisible(true);
			add_student_btn.setVisible(true);
			edit_student_btn.setVisible(true);
			delete_student_btn.setVisible(true);
			add_tutors_btn.setVisible(true);
			edit_tutors_btn.setVisible(true);
			delete_tutors_btn.setVisible(true);
			reportbtn.setVisible(false);
			enrollbtn.setVisible(false);
			loginuser_txt.setText("Admin");
		}else if(userType.equals("Student")){
			reportbtn.setVisible(false);
			loginuser_txt.setText("Student");
			
		}else if(userType.equals("Teacher")) {
			enrollbtn.setVisible(false);
			loginuser_txt.setText("Teacher");
		
			
			
		}
		
		}
			
			
		
	
}
