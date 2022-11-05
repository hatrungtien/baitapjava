package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_finding extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_finding frame = new GUI_finding();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_finding() {
		setTitle("Student Lookup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbClassID = new JLabel("Class:");
		lbClassID.setBounds(38, 10, 53, 24);
		contentPane.add(lbClassID);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 12, 179, 21);
		contentPane.add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(309, 12, 85, 21);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Student List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 44, 416, 185);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 23, 396, 155);
		panel.add(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Student().setVisible(true);
			}
		});
		btnBack.setBounds(324, 229, 85, 24);
		contentPane.add(btnBack);
	}
}
