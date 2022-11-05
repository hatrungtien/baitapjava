package GDiem;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui_insertHV extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Ma;
	private JTextField txt_Ten;
	private JTextField txt_Diem;
	private JTable table;
	XLDiem xlDiem = new XLDiem();
	DefaultTableModel model = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_insertHV frame = new Gui_insertHV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loadData() {
		ArrayList<Hocvien> list = new ArrayList<>();
		list = xlDiem.getHV();
		model.setRowCount(0);
		Object[] row = new Object[5];
		for(int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMaHV();
			row[1] = list.get(i).getHoten();
			row[2] = list.get(i).getLop();
			row[3] = list.get(i).getDiem();
			if(list.get(i).getDiem()>=10) {
				row[4] = "Đạt";
			}
			else {
				row[4] = "";
			}
			model.addRow(row);
		}
		table.setModel(model);
		
	}

	public void InitTable() {
		model.setColumnIdentifiers(new String[] {
				"Mã", "Họ tên", "Lớp", "Điểm", "Kết quả"
			});
	}
	public void makeEmpty() {
		txt_Ma.setText("");
		txt_Ten.setText("");
		txt_Diem.setText("");
	}
	/**
	 * Create the frame.
	 */
	public Gui_insertHV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã: ");
		lblNewLabel.setBounds(28, 29, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblTn = new JLabel("Tên:");
		lblTn.setBounds(28, 54, 45, 13);
		contentPane.add(lblTn);
		
		JLabel lblLp = new JLabel("Lớp:");
		lblLp.setBounds(28, 77, 45, 13);
		contentPane.add(lblLp);
		
		JLabel lblim = new JLabel("Điểm:");
		lblim.setBounds(28, 100, 45, 13);
		contentPane.add(lblim);
		
		txt_Ma = new JTextField();
		txt_Ma.setBounds(115, 26, 170, 19);
		contentPane.add(txt_Ma);
		txt_Ma.setColumns(10);
		
		txt_Ten = new JTextField();
		txt_Ten.setColumns(10);
		txt_Ten.setBounds(115, 51, 170, 19);
		contentPane.add(txt_Ten);
		
		txt_Diem = new JTextField();
		txt_Diem.setColumns(10);
		txt_Diem.setBounds(115, 97, 170, 19);
		contentPane.add(txt_Diem);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"62Th1", "62PM1", "62PM2"}));
		comboBox.setBounds(115, 73, 170, 21);
		contentPane.add(comboBox);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hocvien hv = new Hocvien();
				hv.setMaHV(Integer.parseInt(txt_Ma.getText()));
				hv.setHoten(txt_Ten.getText());
				hv.setLop(comboBox.getSelectedItem().toString());
				hv.setDiem(Double.parseDouble(txt_Diem.getText()));
				if(xlDiem.insertHV(hv)) {
					loadData();
					JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
					makeEmpty();
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
				}
			}
		});
		btnThem.setBounds(315, 50, 85, 21);
		contentPane.add(btnThem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 416, 125);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		InitTable();
		loadData();
	}
}
