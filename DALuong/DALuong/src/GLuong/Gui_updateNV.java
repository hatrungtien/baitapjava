package GLuong;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui_updateNV extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Ma;
	private JTextField txt_Ten;
	private JTextField txt_Luong;
	XLLuong xlLuong = new XLLuong();
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_updateNV frame = new Gui_updateNV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void loaddata() {
		ArrayList<Nhanvien> list = new ArrayList<>();
		list = xlLuong.getNhanvien();
		model.setRowCount(0);
		Object[] row = new Object[5];
		for(int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getMaNV();
			row[1] = list.get(i).getHoten();
			row[2] = list.get(i).getDiachi();
			row[3] = list.get(i).getLuong();
			row[4] = list.get(i).getBirth();
			model.addRow(row);
		}
		table.setModel(model);
 	}
	public void initTable() {
		model.setColumnIdentifiers(new String[] {
				"Mã", "Họ tên", "Địa chỉ", "Lương", "Ngày sinh"
			});
	}
	/**
	 * Create the frame.
	 */
	public Gui_updateNV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã NV:");
		lblNewLabel.setBounds(10, 10, 54, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setBounds(10, 38, 54, 13);
		contentPane.add(lblHTn);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setBounds(10, 72, 54, 13);
		contentPane.add(lblaCh);
		
		JLabel lblLng = new JLabel("Lương:");
		lblLng.setBounds(10, 106, 54, 13);
		contentPane.add(lblLng);
		
		txt_Ma = new JTextField();
		txt_Ma.setBounds(74, 7, 201, 19);
		contentPane.add(txt_Ma);
		txt_Ma.setColumns(10);
		
		txt_Ten = new JTextField();
		txt_Ten.setColumns(10);
		txt_Ten.setBounds(74, 35, 201, 19);
		contentPane.add(txt_Ten);
		
		txt_Luong = new JTextField();
		txt_Luong.setColumns(10);
		txt_Luong.setBounds(74, 103, 201, 19);
		contentPane.add(txt_Luong);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(xlLuong.addItem()));
		comboBox.setBounds(74, 68, 201, 21);
		contentPane.add(comboBox);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nhanvien nv = xlLuong.getNVbyMa(txt_Ma.getText());
				System.out.println(nv);
				txt_Ten.setText(nv.getHoten());
				comboBox.setSelectedItem(nv.getDiachi().toString());
				txt_Luong.setText(nv.getLuong()+"");
				
			}
		});
		btnSearch.setBounds(321, 30, 85, 21);
		contentPane.add(btnSearch);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nhanvien nv = new Nhanvien();
				nv.setMaNV(txt_Ma.getText());
				nv.setHoten(txt_Ten.getText());
				nv.setDiachi(comboBox.getSelectedItem().toString());
				nv.setLuong(Double.parseDouble(txt_Luong.getText()));
				xlLuong.updateNV(nv);
				loaddata();
				
			}
		});
		btnUpdate.setBounds(321, 79, 85, 21);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 416, 124);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if(row >= 0) {
					txt_Ma.setText(table.getValueAt(row, 0).toString());
					txt_Ten.setText(table.getValueAt(row, 1).toString());
					comboBox.setSelectedItem(table.getValueAt(row, 2));
					txt_Luong.setText(table.getValueAt(row, 3).toString());
				}
			}
		});
		scrollPane.setViewportView(table);
		initTable();
		loaddata();
	}
}
