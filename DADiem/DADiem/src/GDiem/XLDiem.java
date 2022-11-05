package GDiem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class XLDiem {
	
	public Connection getCon() {
		String URL = "jdbc:mysql://localhost:3306/dldiem";
		String user = "root";
		String pass = "";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,user,pass);
			System.out.println("Connect success!");
		} catch (Exception e) {
			// TODO: handle exception\
			System.out.println("connect failure");
		}
		return connection;
	}
	
	public ArrayList<Hocvien> getHV(){
		ArrayList<Hocvien> list = new ArrayList<>();
		String sql = "Select *from tbHocvien";
		Connection connection = getCon();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Hocvien hv = new Hocvien();
				hv.setMaHV(rs.getInt("MaHV"));
				hv.setHoten(rs.getString("Hoten"));
				hv.setLop(rs.getString("Lop"));
				hv.setDiem(rs.getDouble("Diem"));
				list.add(hv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	public boolean insertHV(Hocvien hv) {
		Connection connection = getCon();
		String sql = "Insert into tbHocvien(MaHV, Hoten, Lop, Diem) values(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, hv.getMaHV());
			stmt.setString(2, hv.getHoten());
			stmt.setString(3, hv.getLop());
			stmt.setDouble(4, hv.getDiem());
			stmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
	public static void main(String[] args) {
		XLDiem xl = new XLDiem();
//		ArrayList<Hocvien> arrayList = new ArrayList<>();
//		arrayList = xl.getHV();
		Hocvien hv = new Hocvien();
		hv.setMaHV(980);
		hv.setHoten("Tamne");
		hv.setLop("63PM04");
		hv.setDiem(3);
		System.out.println(xl.insertHV(hv));
	}
}
