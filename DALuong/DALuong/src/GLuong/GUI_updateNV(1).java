package GLuong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_updateNV extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtHoten;
	private JTextField txtLuong;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	XLLuong xlLuong = new XLLuong();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_updateNV frame = new GUI_updateNV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initTable() {
		model.setColumnIdentifiers(new String[] { "MaNV", "Hoten", "Diachi", "Luong" });
	}
	public void loadData() {
		ArrayList<Nhanvien> list = new ArrayList<>();
		list = xlLuong.getListNhanVien();
		model.setRowCount(0);
		Object[] row = new Object[4];
		for(int i = 0; i<list.size();i++) {
			row[0] = list.get(i).getMaNV();
			row[1] = list.get(i).getHoten();
			row[2] = list.get(i).getDiachi();
			row[3] = list.get(i).getLuong();
			model.addRow(row);
		}
		table.setModel(model);
	}
	/**
	 * Create the frame.
	 */
	public GUI_updateNV() {
		setTitle("UpdateNV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("MaNV");
		lblNewLabel.setBounds(64, 11, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Hoten");
		lblNewLabel_1.setBounds(64, 36, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Diachi");
		lblNewLabel_2.setBounds(64, 61, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Luong");
		lblNewLabel_3.setBounds(64, 86, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(120, 8, 130, 20);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);

		txtHoten = new JTextField();
		txtHoten.setColumns(10);
		txtHoten.setBounds(120, 33, 130, 20);
		contentPane.add(txtHoten);

		JComboBox cbbDiachi = new JComboBox();
		cbbDiachi.setModel(new DefaultComboBoxModel(new String[] {"TH", "HD", "NB", "TB"}));
		cbbDiachi.setBounds(120, 57, 130, 22);
		contentPane.add(cbbDiachi);

		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(120, 83, 130, 20);
		contentPane.add(txtLuong);

		JButton btnTimkiem = new JButton("Timkiem");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MaNV = txtMaNV.getText();
				Nhanvien nv = xlLuong.getNV_byMa(MaNV);
				txtMaNV.setText(nv.getMaNV()+"");
				txtHoten.setText(nv.getHoten());
				cbbDiachi.setSelectedItem(nv.getDiachi());
				txtLuong.setText(nv.getLuong()+"");
				
				ArrayList<Nhanvien> list = new ArrayList<>();
				list = xlLuong.getlistNV_byMa(MaNV);
				model.setRowCount(0);
				Object[] row = new Object[4];
				for(int i = 0; i<list.size();i++) {
					row[0] = list.get(i).getMaNV();
					row[1] = list.get(i).getHoten();
					row[2] = list.get(i).getDiachi();
					row[3] = list.get(i).getLuong();
					model.addRow(row);
				}
				table.setModel(model);
				
			}
		});
		btnTimkiem.setBounds(303, 7, 89, 23);
		contentPane.add(btnTimkiem);

		JButton btnSua = new JButton("Sua");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nhanvien nv = new Nhanvien();
				nv.setMaNV(Integer.parseInt(txtMaNV.getText()));
				nv.setHoten(txtHoten.getText());
				nv.setDiachi(cbbDiachi.getSelectedItem().toString());
				nv.setLuong(Double.parseDouble(txtLuong.getText()));
				xlLuong.updateNV(nv);
				loadData();
			}
		});
		btnSua.setBounds(303, 57, 89, 23);
		contentPane.add(btnSua);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 414, 114);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		initTable();
		loadData();

	}

}
