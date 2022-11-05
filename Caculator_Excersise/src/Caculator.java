import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Caculator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caculator frame = new Caculator();
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
	public Caculator() {
		setBackground(new Color(128, 0, 64));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bt1_1 = new JButton("1");
		bt1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt1_1.setBounds(76, 97, 39, 21);
		bt1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(bt1_1);
		
		JButton bt1 = new JButton("2");
		bt1.setBounds(148, 97, 39, 21);
		contentPane.add(bt1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Radian");
		rdbtnNewRadioButton.setBounds(375, 51, 57, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Degree");
		rdbtnNewRadioButton_1.setBounds(470, 51, 59, 21);
		rdbtnNewRadioButton_1.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("4");
		btnNewButton.setBounds(76, 141, 45, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(144, 141, 39, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.setBounds(234, 97, 50, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("6");
		btnNewButton_3.setBounds(234, 146, 50, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("7");
		btnNewButton_4.setBounds(76, 190, 45, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("8");
		btnNewButton_5.setBounds(147, 190, 40, 21);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("9");
		btnNewButton_6.setBounds(234, 190, 50, 21);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("0");
		btnNewButton_7.setBounds(102, 231, 85, 21);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("+");
		btnNewButton_8.setBounds(199, 231, 85, 21);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("CLEAR");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_9.setBounds(76, 275, 203, 21);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("LOG");
		btnNewButton_10.setBounds(364, 97, 85, 21);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("SIN");
		btnNewButton_11.setBounds(483, 97, 85, 21);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_12.setBounds(347, 146, 85, 21);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("New button");
		btnNewButton_13.setBounds(442, 141, 85, 21);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		btnNewButton_14.setBounds(536, 141, 85, 21);
		contentPane.add(btnNewButton_14);
	}
}
