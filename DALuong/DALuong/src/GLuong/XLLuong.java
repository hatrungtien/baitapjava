package GLuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class XLLuong {
	public Connection getCon() {
		Connection connection = null;
		String URL = "jdbc:mysql://localhost:3306/dlluong";
		String user = "root";
		String pass = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, user, pass);
			System.out.println("success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail");
		}
		return connection;
	}
	
	public Nhanvien getNVbyMa(String ma) {
		Connection connection = getCon();
		Nhanvien nv = new Nhanvien();
		String sql = "Select * from tbNhanvien where MaNV = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				nv.setMaNV(rs.getString("MaNV"));
				nv.setHoten(rs.getString("Hoten"));
				nv.setDiachi(rs.getString("Diachi"));
				nv.setLuong(rs.getDouble("Luong"));
				nv.setBirth(rs.getDate("birth"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}
	
	public boolean updateNV(Nhanvien nv) {
		Connection connection = getCon();
		String sql = "Update tbNhanvien set Hoten = ?, Diachi = ?, Luong = ? where MaNV = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nv.getHoten());
			stmt.setString(2, nv.getDiachi());
			stmt.setDouble(3, nv.getLuong());
			stmt.setString(4, nv.getMaNV());
			
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public ArrayList<Nhanvien> getNhanvien(){
		Connection connection = getCon();
		ArrayList<Nhanvien> list  = new ArrayList<>();
		String sql = "select *from tbNhanvien";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Nhanvien nv = new Nhanvien();
				nv.setMaNV(rs.getString("MaNV"));
				nv.setHoten(rs.getString("Hoten"));
				nv.setDiachi(rs.getString("Diachi"));
				nv.setLuong(rs.getDouble("Luong"));
				nv.setBirth(rs.getDate("birth"));
				list.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public Object[] addItem() {
		ArrayList<String> arr = new ArrayList<>();	

		try {
			Connection connection = getCon();
			String sql = "select name from diachi";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				arr.add(rs.getString("name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Object[] a = arr.toArray();
		return a;
	}
	
	public static void main(String[] args) {
		XLLuong xlLuong = new XLLuong();
		
	}
}
