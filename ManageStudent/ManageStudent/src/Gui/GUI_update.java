package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Gui.GUI_Student;
public class GUI_update extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Name;
	private JTextField txt_Mark;
	private JComboBox comboBox;
	Student student;
	Process_Student pStudent = new Process_Student();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_update frame = new GUI_update();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}
	/**
	 * Create the frame.
	 */
	public GUI_update(Student a) {
		this.student = a;
		init();
	}
	public void init() {
		setTitle("Update Student's Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(31, 48, 400, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbName = new JLabel("Name:");
		lbName.setBounds(32, 11, 78, 21);
		panel.add(lbName);
		
		txt_Name = new JTextField();
		txt_Name.setColumns(10);
		txt_Name.setBounds(113, 11, 177, 21);
		panel.add(txt_Name);
		txt_Name.setText(student.getName());
		
		JLabel lbClass = new JLabel("Class:");
		lbClass.setBounds(32, 57, 78, 21);
		panel.add(lbClass);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(113, 101, 66, 21);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(211, 101, 66, 21);
		panel.add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);

		rdbtnMale.setSelected(student.isGender());
		 if(student.isGender()==false) {
			rdbtnFemale.setSelected(true);
		}
			
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(32, 101, 78, 21);
		panel.add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 57, 177, 21);
		panel.add(comboBox);
		pStudent.showcbBClass(comboBox);
		comboBox.setSelectedItem(student.getClassID());
		
		JLabel lblMark = new JLabel("Mark:");
		lblMark.setBounds(32, 144, 78, 21);
		panel.add(lblMark);
		
		txt_Mark = new JTextField();
		txt_Mark.setColumns(10);
		txt_Mark.setBounds(113, 145, 177, 21);
		panel.add(txt_Mark);
		txt_Mark.setText(String.valueOf(student.getMark()));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student();
				student.setID(txt_ID.getText());
				student.setName(txt_Name.getText());
				student.setClassID(comboBox.getSelectedItem().toString());
				student.setGender(rdbtnMale.isSelected());
				student.setMark(Double.parseDouble(txt_Mark.getText()));
				pStudent.updateStudent(student);
				dispose();
				new GUI_Student().setVisible(true);
			}
		});
		btnUpdate.setBounds(300, 75, 90, 21);
		panel.add(btnUpdate);
		
		JLabel lbID = new JLabel("Student ID:");
		lbID.setBounds(58, 12, 66, 13);
		contentPane.add(lbID);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(144, 8, 177, 21);
		contentPane.add(txt_ID);
		txt_ID.setColumns(10);
		txt_ID.setText(student.getID());
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(331, 8, 85, 21);
		contentPane.add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Student().setVisible(true);
			}
		});
		btnBack.setBounds(346, 246, 85, 24);
		contentPane.add(btnBack);
		
	}
}
