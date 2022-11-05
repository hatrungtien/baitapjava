package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_Student extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtMark;
	Process_Student pStudent = new Process_Student();
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JComboBox aBox;
	private JRadioButton aButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Student frame = new GUI_Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//	public void load() {
//		try {
//			model.setRowCount(0);
//			Connection connection = Process_Student.getCon();
//			String sql = "Select *from student";
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			while (rs.next()) {
//				String[] row = new String[] {
//						rs.getString("ID"), rs.getString("Name"), rs.getString("ClassID"), rs.getString("Gender"), rs.getString("Mark")
//				};
//				model.addRow(row);
//				
//			}
//			table.setModel(model);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	public void load() {
				ArrayList<Student>arrayList = new ArrayList<>();
				arrayList = pStudent.getListStudent();
				model.setRowCount(0);
				Object[] row = new Object[5];
 				for (int i = 0; i < arrayList.size(); i++) {
					//Object[] abjs = {arrayList.get(i).getID()}
 					row[0] = arrayList.get(i).getID();
 					row[1] = arrayList.get(i).getName();
					row[2] = arrayList.get(i).getClassID();
 					if(arrayList.get(i).isGender()) {
 						row[3] = "Male";
 					}
 					else {
 						row[3] = "Female";
					}
 					row[4] = arrayList.get(i).getMark();
 					model.addRow(row);
				}
 				table.setModel(model);
	}
	
	public void InitTable() {
		model.setColumnIdentifiers(new String[] {"ID", "Name", "ClassID", "Gender", "Mark"} );
	}
	
	public void makeEmpty() {
		
		txtID.setText("");
		txtName.setText("");
		aBox.setSelectedItem("Th1");
		aButton.setSelected(true);
		txtMark.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	
	public GUI_Student() {
		
		setTitle("Student Manage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 356);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 10, 287, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbID = new JLabel("Student ID:");
		lbID.setBounds(12, 10, 66, 13);
		panel.add(lbID);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(88, 6, 177, 21);
		panel.add(txtID);
		
		JLabel lbName = new JLabel("Name:");
		lbName.setBounds(12, 41, 78, 21);
		panel.add(lbName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(88, 41, 177, 21);
		panel.add(txtName);
		
		JLabel lbClass = new JLabel("Class:");
		lbClass.setBounds(12, 72, 78, 21);
		panel.add(lbClass);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 105, 78, 21);
		panel.add(lblGender);
		
		JLabel lblMark = new JLabel("Mark:");
		lblMark.setBounds(12, 136, 78, 21);
		panel.add(lblMark);
		
		txtMark = new JTextField();
		txtMark.setColumns(10);
		txtMark.setBounds(88, 136, 177, 21);
		panel.add(txtMark);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(88, 105, 66, 21);
		panel.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(176, 105, 66, 21);
		panel.add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		JComboBox<Object> cbBClass = new JComboBox<Object>();
		cbBClass.setBounds(88, 72, 177, 21);
		panel.add(cbBClass);
		pStudent.showcbBClass(cbBClass);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(318, 10, 148, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student();
				student.setID(txtID.getText());
				student.setName(txtName.getText());
				student.setClassID(cbBClass.getSelectedItem().toString());
				student.setGender(rdbtnMale.isSelected() ? true:false);
				student.setMark(Double.parseDouble(txtMark.getText()));
				if(pStudent.insertStudent(student) == true) {
					load();
					JOptionPane.showMessageDialog(rootPane, "Insert success");
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Insert failure");
				}
				makeEmpty();
			}
		});
		btnAdd.setBounds(29, 10, 85, 21);
		panel_1.add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setEnabled(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student();
 				student.setID(txtID.getText());
				student.setName(txtName.getText());
				student.setClassID(cbBClass.getSelectedItem().toString());
				student.setGender(rdbtnMale.isSelected() ? true:false);
				student.setMark(Double.parseDouble(txtMark.getText()));
				dispose();
				GUI_update gui_update = new GUI_update(student);
				gui_update.setVisible(true); 
				gui_update.setLocationRelativeTo(null);
				System.out.println(rdbtnMale.isSelected() ? true:false);
			}
		});
		btnEdit.setBounds(29, 51, 85, 21);
		panel_1.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student();
				student.setID(txtID.getText());
				dispose();
				GUI_delete gui_delete = new GUI_delete(student);
				gui_delete.setVisible(true);
				
			}
		});
		btnDelete.setBounds(29, 96, 85, 21);
		panel_1.add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI_finding gui_finding = new GUI_finding();
				gui_finding.setVisible(true);
			}
		});
		btnSearch.setBounds(29, 141, 85, 21);
		panel_1.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 456, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				int row = table.getSelectedRow();
				String a = table.getValueAt(row, 3).toString();
 				if(row >= 0 ) {
					txtID.setText(table.getValueAt(row, 0).toString());
					txtName.setText(table.getValueAt(row, 1).toString());
					cbBClass.setSelectedItem(table.getValueAt(row, 2));
//					rdbtnMale.setSelected(table.getValueAt(row, 3).toString() == "Male" ? true:false);
//					rdbtnFemale.setSelected(table.getValueAt(row, 3).toString() == "Female" ? true:false);
					if(a.equals("Male")) {
						rdbtnMale.setSelected(true);
					}
					if(a.equals("Female")) {
						rdbtnFemale.setSelected(true);
					}
					txtMark.setText(table.getValueAt(row, 4).toString());
				}
			}
		});
		scrollPane.setViewportView(table);
		
		InitTable();
		load();
	}
}
