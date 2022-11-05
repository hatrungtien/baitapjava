package GLuong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class XLLuong {
	public Connection getCon() {
		try {
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DLLuong", "root", "");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

	public ArrayList<Nhanvien> getListNhanVien() {
		Connection conn = getCon();
		ArrayList<Nhanvien> list = new ArrayList<>();
		String sql = "select * from tbNhanvien";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Nhanvien nv = new Nhanvien();
				nv.setMaNV(rs.getInt("MaNV"));
				nv.setHoten(rs.getString("Hoten"));
				nv.setDiachi(rs.getString("Diachi"));
				nv.setLuong(rs.getDouble("Luong"));
				list.add(nv);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}
	
	public Nhanvien getNV_byMa(String ID) {
		Connection conn = getCon();
		String sql = "select * from tbNhanvien where MaNV=?";
		Nhanvien nv = new Nhanvien();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				nv.setMaNV(rs.getInt("MaNV"));
				nv.setHoten(rs.getString("Hoten"));
				nv.setDiachi(rs.getString("Diachi"));
				nv.setLuong(rs.getDouble("Luong"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		return nv;
	}
	public ArrayList<Nhanvien> getlistNV_byMa(String ID){
		Connection conn = getCon();
		String sqlString = "select * from tbNhanvien where MaNV=?";
		ArrayList<Nhanvien> list = new ArrayList<>();
		try {
			PreparedStatement pst = conn.prepareStatement(sqlString);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Nhanvien nv = new Nhanvien();
				nv.setMaNV(rs.getInt("MaNV"));
				nv.setHoten(rs.getString("Hoten"));
				nv.setDiachi(rs.getString("Diachi"));
				nv.setLuong(rs.getDouble("Luong"));
				list.add(nv);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public boolean updateNV(Nhanvien nv) {
		Connection conn = getCon();
		String sql = "Update tbNhanvien set Hoten=?, Diachi=?, Luong=? where MaNV=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, nv.getHoten());
			pst.setString(2, nv.getDiachi());
			pst.setDouble(3, nv.getLuong());
			pst.setInt(4, nv.getMaNV());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public static void main(String[] args) {
		ArrayList<Nhanvien> list = new ArrayList<>();
		XLLuong xlLuong = new XLLuong();
//		list = xlLuong.getListNhanVien();
//		System.out.println(list);
		
//		Nhanvien nv = xlLuong.getNV_byMa("1");
//		System.out.println(nv);
		
		Nhanvien nv = xlLuong.getNV_byMa("1");
		nv.setHoten("aaa");
		nv.setDiachi("TH");
		nv.setLuong(900000);
		System.out.println(xlLuong.updateNV(nv));
		
		
	}

}
