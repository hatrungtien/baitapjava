package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_delete extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ID;
	Student student;
	Process_Student process_Student = new Process_Student();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_delete frame = new GUI_delete();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI_delete(Student a) {
		this.student = a;
		init();
	}
	
	public void init() {
		setTitle("Delete Student by ID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbID = new JLabel("Student ID:");
		lbID.setBounds(39, 36, 66, 13);
		contentPane.add(lbID);
		
		txt_ID = new JTextField();
		txt_ID.setColumns(10);
		txt_ID.setBounds(126, 32, 177, 21);
		contentPane.add(txt_ID);
		txt_ID.setText(student.getID());
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idString = student.getID();
				if(process_Student.deleteStudent(idString)==true ) {
					dispose();
					new GUI_Student().setVisible(true);
				};
			}
		});
		btnDelete.setBounds(323, 32, 85, 21);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Student().setVisible(true);
			}
		});
		btnBack.setBounds(323, 216, 85, 24);
		contentPane.add(btnBack);
	}

}
